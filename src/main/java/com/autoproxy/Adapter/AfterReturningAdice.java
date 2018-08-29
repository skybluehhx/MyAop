package com.autoproxy.Adapter;

import org.aopalliance.aop.Advice;

import java.lang.reflect.Method;

/**
 * Created by zoujianglin
 * 2018/8/29 0029.
 */
public interface AfterReturningAdice extends Advice {

    void after(Method method, Object[] args, Object target) throws Throwable;
}
