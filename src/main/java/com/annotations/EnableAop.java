package com.annotations;

import org.aopalliance.aop.Advice;

import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

/**
 * Created by zoujianglin
 * 2018/8/29 0029.
 * <p>
 * 这仅仅是一个标志性注解，使用该注解意味着
 * 你将对该类实现动态代理，启动aop功能，具体需要
 * 配合{@link InterceptorAdvice} 使用,如果你给EnableAop
 * 的advices赋值，那么它将对该类的所有方法生效，（除了object自带的方法以外）
 */
@Target(ElementType.TYPE)
@Retention(RetentionPolicy.RUNTIME)
public @interface EnableAop {

    Class<? extends Advice>[] advices() default {};

    ;
}
