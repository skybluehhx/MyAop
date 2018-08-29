package com.autoproxy.Adapter;

import org.aopalliance.aop.Advice;
import org.aopalliance.intercept.MethodInterceptor;

/**
 * Created by zoujianglin
 * 2018/8/28 0028.
 * 适配器，将advice适配为拦截器，从而方便处理
 */
public class MethodBeforeAdviceAdapter implements AdviceAdapter {

    public boolean supportsAdvice(Advice advice) {
        return advice instanceof MethodBeforeAdvice;
    }

    public MethodInterceptor getInterceptor(Advice advice1) {
        MethodBeforeAdvice advice = (MethodBeforeAdvice) advice1;
        return new MethodBeforeAdviceInterceptor(advice);
    }
}
