package com;

import org.aopalliance.intercept.MethodInterceptor;
import org.aopalliance.intercept.MethodInvocation;

import java.lang.reflect.AccessibleObject;
import java.lang.reflect.Method;
import java.util.List;

/**
 * Created by zoujianglin
 * 2018/8/28 0028.
 */
public class MyMethodInvocation implements MethodInvocation {
    //控制拦截器偏移量
    private int currentIndex = -1;

    private List<MethodInterceptor> methodInterceptors;
    //代理对象
    private Object target;
    //代理方法
    private Method method;
    //代理方法的参数
    private Object[] arguments;

    public MyMethodInvocation(Object target, Method method, Object[] arguments,
                              List<MethodInterceptor> methodInterceptors) {
        this.methodInterceptors = methodInterceptors;
        this.target = target;
        this.method = method;
        this.arguments = arguments;
    }

    public Method getMethod() {
        return this.method;
    }

    public Object[] getArguments() {
        return arguments;
    }

    public Object proceed() throws Throwable {

        if (currentIndex == methodInterceptors.size() - 1) {
            return methodInterceptors.get(++currentIndex).invoke(this);
        } else {
            System.out.print("原来方法调用");   //调用原先方法 method.invoke(),可以通过参数获得
            //添加判断 防止递归完后每个方法都回到这 也算终止条件
            return method.invoke(target, arguments);

        }

    }

    public Object getThis() {
        return this.target;
    }

    public AccessibleObject getStaticPart() {
        return this.method;
    }

    public String toString() {
        StringBuilder sb = new StringBuilder("ReflectiveMethodInvocation: ");
        sb.append(this.method).append("; ");
        if (this.target == null) {
            sb.append("target is null");
        } else {
            sb.append("target is of class [").append(this.target.getClass().getName()).append(']');
        }

        return sb.toString();
    }

}
