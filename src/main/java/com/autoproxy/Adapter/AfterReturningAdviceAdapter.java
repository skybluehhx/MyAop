package com.autoproxy.Adapter;

import org.aopalliance.aop.Advice;
import org.aopalliance.intercept.MethodInterceptor;

/**
 * Created by zoujianglin
 * 2018/8/29 0029.
 */
public class AfterReturningAdviceAdapter implements AdviceAdapter {

    public boolean supportsAdvice(Advice advice) {
        return advice instanceof AfterReturningAdice;
    }

    public MethodInterceptor getInterceptor(Advice advice1) {

        AfterReturningAdice advice = (AfterReturningAdice) advice1;
        return new AfterReturningAdviceInterceptor(advice);

    }

}
