package com.autoproxy;

/**
 * Created by zoujianglin
 * 2018/8/28 0028.
 */
public interface AopProxy {
    //获取代理
    Object getProxy();

    Object getProxy(ClassLoader var1);

}
