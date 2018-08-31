package com.example;

import com.annotations.EnableAop;
import com.annotations.InterceptorAdvice;
import org.springframework.stereotype.Component;

/**
 * Created by zoujianglin
 * 2018/8/29 0029.
 */
@Component("userDao")
@EnableAop
public class UserDaoImp implements UserDao {

    @InterceptorAdvice(advices = {MyMethodBeforeAdvice.class,
            MyAfterReturnAdvice.class})
    public void test() {
        System.out.println("  test方法  ");
    }
}
