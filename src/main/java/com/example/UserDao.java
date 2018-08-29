package com.example;

import com.annotations.EnableAop;
import com.annotations.InterceptorAdvice;
import com.autoproxy.Adapter.MethodBeforeAdvice;

/**
 * Created by zoujianglin
 * 2018/8/29 0029.
 */
public interface UserDao {

     void test();
}
