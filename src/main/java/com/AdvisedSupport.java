package com;

import java.lang.reflect.Method;
import java.util.List;

/**
 * Created by zoujianglin
 * 2018/8/28 0028.
 */
public class AdvisedSupport extends ProxyConfig {
    //被代理的对象
    private Object target;


    //被代理的接口
    private List<Class<?>> interfaces;

    //获取拦截器
    List<Object> getInterceptors(Method method, Class<?> targetClass) {

        return null;
    }


}
