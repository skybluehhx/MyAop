package com.lin;

import org.aopalliance.intercept.MethodInterceptor;
import org.aopalliance.intercept.MethodInvocation;

/**
 * Created by zoujianglin
 * 2018/8/28 0028.
 */
public class MyMethodInterceptor implements MethodInterceptor {
    public Object invoke(MethodInvocation methodInvocation) throws Throwable {
        //实现自己了拦截逻辑
        System.out.println("执行在方法前");
        Object returnValue = methodInvocation.proceed();
        System.out.println("执行在方法后");
        return returnValue;
    }
}
