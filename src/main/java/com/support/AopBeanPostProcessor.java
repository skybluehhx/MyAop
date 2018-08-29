package com.support;

import com.AopSupport;
import com.MethodConfig;
import com.annotations.EnableAop;
import com.annotations.InterceptorAdvice;
import org.aopalliance.aop.Advice;
import org.springframework.beans.BeansException;
import org.springframework.beans.factory.config.BeanPostProcessor;

import java.lang.reflect.Method;

/**
 * Created by zoujianglin
 * 2018/8/29 0029.
 */
public class AopBeanPostProcessor implements BeanPostProcessor {
    public Object postProcessBeforeInitialization(Object bean, String s) throws BeansException {
        return bean;
    }

    public Object postProcessAfterInitialization(Object bean, String s) throws BeansException {
        if (bean.getClass().isAnnotationPresent(EnableAop.class)) {
            AopSupport aopSupport = new AopSupport();
            Method[] methods = bean.getClass().getDeclaredMethods();
            for (int i = 0; i < methods.length; i++) {
                //如果是object方法，跳过,这里有待考虑需不需要跳过，
                if (Object.class.equals(methods[i].getDeclaringClass())) {
                    continue;
                }
                if (methods[i].isAnnotationPresent(InterceptorAdvice.class)) {
                    InterceptorAdvice interceptorAdvice = methods[i].getAnnotation(InterceptorAdvice.class);
                    Class<? extends Advice>[] advices = interceptorAdvice.advices();
                    MethodConfig methodConfig = new MethodConfig(bean, methods[i], advices);
                    aopSupport.addMethodConfig(methods[i].getName(), methodConfig);

                }


            }
            return null;
        } else {


            return bean;
        }
    }
}
