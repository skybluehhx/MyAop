package com.example;

import com.example.SpringAOp.Hello;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import java.lang.reflect.Field;

/**
 * Created by zoujianglin
 * 2018/8/29 0029.
 */
public class AopTest {

    public static void main(String[] args) {
        ApplicationContext applicationContext = new ClassPathXmlApplicationContext("applicationContext.xml");
        UserDao userDao = (UserDao) applicationContext.getBean("userDao");
     //   userDao.test();
        Hello hello = (Hello) applicationContext.getBean("helloimp");
          hello.say();


    }



}