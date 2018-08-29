package com.example;

import com.autoproxy.Adapter.AfterReturningAdice;
import com.sun.org.apache.xpath.internal.SourceTree;

import java.lang.reflect.Method;

/**
 * Created by zoujianglin
 * 2018/8/29 0029.
 */
public class MyAfterReturnAdvice implements AfterReturningAdice {
    public void after(Method method, Object[] args, Object target) throws Throwable {
        System.out.println("执行在方法运行之后");
    }
}
