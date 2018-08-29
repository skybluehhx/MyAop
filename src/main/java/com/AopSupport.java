package com;

import java.lang.reflect.Method;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * Created by zoujianglin
 * 2018/8/28 0028.
 * 维持着一个类的所有代理配置
 */
public final class AopSupport extends ProxyConfig {

    //保持着方法名和该方法的配置
    private Map<String, MethodConfig> methodConfigMap;
    //被代理的对象
    private Object target;

    //被代理的接口
    private List<Class<?>> interfaces;

    public AopSupport() {
        methodConfigMap = new HashMap<String, MethodConfig>();
        interfaces = new ArrayList<Class<?>>();
    }

    public void addMethodConfig(String methodName, MethodConfig methodConfig) {

        methodConfigMap.put(methodName, methodConfig);

    }

    public MethodConfig getMethodConfig(String methodName) {
        return methodConfigMap.get(methodName);
    }

    public Object getTarget() {
        return target;
    }

    public void setTarget(Object target) {
        this.target = target;
    }

    public List<Class<?>> getInterfaces() {
        return interfaces;
    }

    public void setInterfaces(List<Class<?>> interfaces) {
        this.interfaces = interfaces;
    }

    public void addInterfaces(Class<?>[] interClass) {
        for (int i = 0; i < interClass.length; i++) {
            if (interClass[i].isInterface()) {
                interfaces.add(interClass[i]);
            }
        }
    }
}
