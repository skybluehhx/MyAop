package com;

import com.util.AdviceUtil;
import com.util.Assert;
import org.aopalliance.aop.Advice;
import org.aopalliance.intercept.MethodInterceptor;

import java.lang.reflect.Method;
import java.util.ArrayList;
import java.util.List;

/**
 * Created by zoujianglin
 * 2018/8/29 0029.
 * 保持着被代理的方法的配置
 */
public class MethodConfig {

    private Object target; //被代理的目标对象
    private Method method;  //被代理的方法
    private List<MethodInterceptor> methodInterceptors; //方法拦截器


    public MethodConfig(Object target, Method method, Class<? extends Advice>[] advices) {
        List<MethodInterceptor> methodInterceptors = getMethodInterceptorsByAdvicesClass(advices);
        Assert.notNull(method, "被代理的方法不能为空");
        Assert.notNull(target, "代理对象不能为空");
        this.target = target;
        this.method = method;
        this.methodInterceptors = methodInterceptors;

    }

    public MethodConfig(Object target, Method method, List<MethodInterceptor> methodInterceptors) {

        Assert.notNull(method, "被代理的方法不能为空");
        Assert.notNull(target, "代理对象不能为空");
        this.target = target;
        this.method = method;
        this.methodInterceptors = methodInterceptors;
    }

    public Object getTarget() {
        return target;
    }

    public void setTarget(Object target) {
        this.target = target;
    }

    public Method getMethod() {
        return method;
    }

    public void setMethod(Method method) {
        this.method = method;
    }

    public List<MethodInterceptor> getMethodInterceptors() {
        return methodInterceptors;
    }

    public void setMethodInterceptors(List<MethodInterceptor> methodInterceptors) {
        this.methodInterceptors = methodInterceptors;
    }

    public void addMethodInterceptors(MethodInterceptor m) {
        methodInterceptors.add(m);

    }

    public List<MethodInterceptor> getMethodInterceptorsByAdvicesClass(Class<? extends Advice>[] advices) {
        List<MethodInterceptor> methodInterceptors = new ArrayList<MethodInterceptor>();
        for (int i = 0; i < advices.length; i++) {
            Advice advice = null;
            try {
                advice = advices[i].newInstance();
            } catch (InstantiationException e) {
                e.printStackTrace();
                throw new RuntimeException(e);
            } catch (IllegalAccessException e) {
                e.printStackTrace();
                throw new RuntimeException(e);
            }
            MethodInterceptor methodInterceptor = AdviceUtil.getMethodInterceptor(advice);
            Assert.notNull(methodInterceptor, "请确保" + advice + "为正确类型");
            methodInterceptors.add(methodInterceptor);
        }

        return methodInterceptors;
    }


}
