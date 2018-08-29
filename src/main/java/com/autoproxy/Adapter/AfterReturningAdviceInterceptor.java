package com.autoproxy.Adapter;

import com.util.Assert;
import org.aopalliance.intercept.MethodInterceptor;
import org.aopalliance.intercept.MethodInvocation;

/**
 * Created by zoujianglin
 * 2018/8/29 0029.
 */
public class AfterReturningAdviceInterceptor implements MethodInterceptor {
    private AfterReturningAdice advice;

    public AfterReturningAdviceInterceptor(AfterReturningAdice methodAfterAdice) {
        Assert.notNull(methodAfterAdice, "methodAfrerAdvice is null");
        this.advice = methodAfterAdice;


    }


    public Object invoke(MethodInvocation mi) throws Throwable {
        Object returnValue = mi.proceed();
        this.advice.after(mi.getMethod(), mi.getArguments(), mi.getThis());
        return returnValue;
    }
}
