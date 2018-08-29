package com.autoproxy;

import com.AopSupport;
import com.MethodConfig;
import com.MyMethodInvocation;
import org.aopalliance.intercept.MethodInvocation;

import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Method;
import java.lang.reflect.Proxy;

/**
 * Created by zoujianglin
 * 2018/8/29 0029.
 */
public class JDKDynamicProxy implements AopProxy, InvocationHandler {


    private AopSupport aopSupport;

    public JDKDynamicProxy(AopSupport aopSupport) {
        this.aopSupport = aopSupport;
    }

    public Object getProxy() {
        return Proxy.newProxyInstance(Thread.currentThread().getContextClassLoader(), (Class[]) aopSupport.getInterfaces().toArray(), this);
    }

    public Object getProxy(ClassLoader var1) {
        return null;
    }

    public Object invoke(Object proxy, Method method, Object[] args) throws Throwable {

        MethodConfig methodConfig = aopSupport.getMethodConfig(method.getName());
        MethodInvocation methodInvocation = new MyMethodInvocation(methodConfig.getTarget(), method,
                args, methodConfig.getMethodInterceptors());

        return methodInvocation.proceed();

    }

    public AopSupport getAopSupport() {
        return aopSupport;
    }
}
