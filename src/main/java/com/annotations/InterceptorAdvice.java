package com.annotations;

import org.aopalliance.aop.Advice;

import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

/**
 * Created by zoujianglin
 * 2018/8/29 0029.
 * 该注解作用于方法上，标志着某个类的方法
 * 将被连接，advices()将返回该方法上的拦截器
 * 并且，使用该注解时你必须配合{@link EnableAop} 才可以
 * 正常工作
 */
@Target(ElementType.METHOD)
@Retention(RetentionPolicy.RUNTIME)
public @interface InterceptorAdvice {
    Class<? extends Advice>[] advices();

}
