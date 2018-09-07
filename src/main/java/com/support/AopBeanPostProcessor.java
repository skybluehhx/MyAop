package com.support;

import com.MethodConfig;
import com.annotations.EnableAop;
import com.annotations.InterceptorAdvice;
import com.autoproxy.JDKDynamicProxy;
import org.aopalliance.aop.Advice;
import org.springframework.beans.BeansException;
import org.springframework.beans.factory.config.BeanPostProcessor;
import org.springframework.stereotype.Component;

import java.lang.reflect.Field;
import java.lang.reflect.Method;

/**
 * Created by zoujianglin
 * 2018/8/29 0029.
 */
@Component
public class AopBeanPostProcessor implements BeanPostProcessor {

    private final String AOP_NAME_PREFIX = "com.sun.proxy.";
    private final String AOP_SIMPLE_NAMEPREFIX = "$Proxy";

    public Object postProcessBeforeInitialization(Object bean, String s) throws BeansException {
        return bean;
    }

    public Object postProcessAfterInitialization(Object bean, String s) throws BeansException {

        //判断是否是代理对象
        boolean isProxy = isSpringAOPProxy(bean);

        if (isProxy) {//是动态代理对象
            Object target = getBeanFromProxy(bean);
          //  System.out.println(s);
            //有时候

            bean = getAopBeanByCustomMode(target, bean);


        } else {//不是动态代理对象
            bean = getAopBeanByCustomMode(bean, null);
        }

        return bean;
    }

    public Object getAopBeanByCustomMode(Object target, Object proxy) {
        if (target.getClass().isAnnotationPresent(EnableAop.class)) {
            EnableAop enableAop = target.getClass().getAnnotation(EnableAop.class);
            Class<? extends Advice>[] enableAopAdvice = enableAop.advices();
            AopSupport aopSupport = new AopSupport();
            Method[] methods = target.getClass().getDeclaredMethods();

            for (int i = 0; i < methods.length; i++) {
                //如果是object方法，跳过,这里有待考虑需不需要跳过，
                if (Object.class.equals(methods[i].getDeclaringClass())) {
                    continue;
                }
                if (methods[i].isAnnotationPresent(InterceptorAdvice.class)) {
                    InterceptorAdvice interceptorAdvice = methods[i].getAnnotation(InterceptorAdvice.class);
                    Class<? extends Advice>[] advices = interceptorAdvice.advices();
                    MethodConfig methodConfig = new MethodConfig(target, methods[i], advices);
                    if (enableAopAdvice != null && enableAopAdvice.length > 0) {
                        methodConfig.addMethodInterceptorsByAdviceClass(enableAopAdvice);
                    }
                    aopSupport.addMethodConfig(methods[i].getName(), methodConfig);
                }

            }


            if (proxy != null) {
                aopSupport.addInterfaces(proxy.getClass().getInterfaces());
                aopSupport.setTarget(proxy);

            } else {
                aopSupport.addInterfaces(target.getClass().getInterfaces());
                aopSupport.setTarget(target);
            }
            return new JDKDynamicProxy(aopSupport).getProxy();
        } else {
            return target;
        }
    }

    /**
     * 根据spring代理的特点，产生的代理类一般为com.sun.proxy.$proxy等形式
     *
     * @param bean
     * @return
     */
    public boolean isSpringAOPProxy(Object bean) {
        Class<?> clazz = bean.getClass();
        if (clazz.getSimpleName().startsWith(AOP_SIMPLE_NAMEPREFIX)) {
            if (clazz.getName().startsWith(AOP_NAME_PREFIX + AOP_SIMPLE_NAMEPREFIX)) {
                return true;
            }
        }
        return false;
    }

    public static final <T> T getBeanFromProxy(T proxyObject) {
        Class<?> clazz = proxyObject.getClass();
      //  System.out.println(clazz.getSimpleName());
        if (clazz.getSimpleName().startsWith("$Proxy")) {
            try {
                clazz = clazz.getSuperclass();
                Field hField = clazz.getDeclaredField("h");
                hField.setAccessible(true);
                Object hObject = hField.get(proxyObject);

                Class<?> dynamicProxyClass = hObject.getClass();
                Field advisedField = dynamicProxyClass.getDeclaredField("advised");
                advisedField.setAccessible(true);
                Object advisedObject = advisedField.get(hObject);

                Class<?> advisedSupportClass = advisedObject.getClass().getSuperclass().getSuperclass();
                Field targetField = advisedSupportClass.getDeclaredField("targetSource");
                targetField.setAccessible(true);
                Object targetObject = targetField.get(advisedObject);

                Class<?> targetSourceClass = targetObject.getClass();
                Field targetClassField = targetSourceClass.getDeclaredField("target");
                targetClassField.setAccessible(true);
                return (T) targetClassField.get(targetObject);
            } catch (SecurityException e) {
                e.printStackTrace();
            } catch (NoSuchFieldException e) {
                e.printStackTrace();
            } catch (IllegalArgumentException e) {
                e.printStackTrace();
            } catch (IllegalAccessException e) {
                e.printStackTrace();
            }
        }
        return null;

    }


}
