package com.example;

import com.autoproxy.Adapter.MethodBeforeAdvice;

import java.lang.reflect.Method;

/**
 * Created by zoujianglin
 * 2018/8/29 0029.
 */
public class MyMethodBeforeSecondAdvice implements MethodBeforeAdvice {
    public void before(Method method, Object[] args, Object target) throws Throwable {
        System.out.println("方法执行之前 second");
    }
}
