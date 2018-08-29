package com.autoproxy.Adapter;

import org.aopalliance.aop.Advice;
import org.aopalliance.intercept.MethodInterceptor;

/**
 * Created by zoujianglin
 * 2018/8/28 0028.
 */
public interface AdviceAdapter {

    boolean supportsAdvice(Advice advice);

    MethodInterceptor getInterceptor(Advice advice);
}
