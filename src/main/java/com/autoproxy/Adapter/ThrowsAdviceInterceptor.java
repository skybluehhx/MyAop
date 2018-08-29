package com.autoproxy.Adapter;

import org.aopalliance.intercept.MethodInterceptor;
import org.aopalliance.intercept.MethodInvocation;

/**
 * Created by zoujianglin
 * 2018/8/29 0029.
 */
public class ThrowsAdviceInterceptor implements MethodInterceptor {

    private ThrowsAdvice throwsAdvice;

    public ThrowsAdviceInterceptor(ThrowsAdvice throwsAdvice) {
        this.throwsAdvice = throwsAdvice;
    }

    public Object invoke(MethodInvocation mi) throws Throwable {
        Object returnValue = null;
        try {
            returnValue = mi.proceed();
        } catch (Throwable e) {
            throwsAdvice.throwAdvice(mi.getMethod(), mi.getArguments(), mi.getThis(), e);
        }
        return returnValue;
    }
}
