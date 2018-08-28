package com.lin;

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
    private int currentIndex = -1;

    private List<MethodInterceptor> methodInterceptors;

    private Method method;
    private Object[] arguments;

    public Method getMethod() {
        return this.method;
    }

    public Object[] getArguments() {
        return arguments;
    }

    public Object proceed() throws Throwable {

        if (currentIndex < methodInterceptors.size() - 1) {
            methodInterceptors.get(++currentIndex).invoke(this);
        } else {
            //添加判断 防止递归完后每个方法都回到这 也算终止条件

            System.out.print("原来方法调用");   //调用原先方法 method.invoke(),可以通过参数获得
        }

        return null;
    }

    public Object getThis() {
        return null;
    }

    public AccessibleObject getStaticPart() {
        return null;
    }
}
