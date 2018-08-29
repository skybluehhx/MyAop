package com.autoproxy.Adapter;

import org.aopalliance.aop.Advice;
import org.aopalliance.intercept.MethodInterceptor;

/**
 * Created by zoujianglin
 * 2018/8/29 0029.
 */
public class ThrowsAdviceAdapter implements AdviceAdapter {
    public boolean supportsAdvice(Advice advice) {
        return advice instanceof ThrowsAdvice;
    }

    public MethodInterceptor getInterceptor(Advice advice) {
        ThrowsAdvice throwsAdvice = (ThrowsAdvice) advice;
        return new ThrowsAdviceInterceptor(throwsAdvice);
    }
}
