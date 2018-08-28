package com.autoproxy.Adapter;

import org.aopalliance.aop.Advice;

import java.lang.reflect.Method;

/**
 * Created by zoujianglin
 * 2018/8/28 0028
 * advice表示拦截点，及表示用户的拦截动作
 * 而spring中使用拦截器表示，因此你需要一个适配器.
 */
public interface MethodBeforeAdvice extends Advice {

    void before(Method method, Object[] args, Object target) throws Throwable;
}
