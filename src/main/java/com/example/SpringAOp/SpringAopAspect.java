package com.example.SpringAOp;

import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.aspectj.lang.annotation.Pointcut;
import org.springframework.stereotype.Component;

/**
 * Created by lin on 2018/9/8.
 */
@Component
@Aspect
public class SpringAopAspect {
    /**execution (*.com.example..*.*(..))
     * execution (* com.sample.service.impl..*.*(..))
     */
    @Before("execution (* com.example..*.*(..))")
    public void before() {
     System.out.println("springAop == before");
    }

}
