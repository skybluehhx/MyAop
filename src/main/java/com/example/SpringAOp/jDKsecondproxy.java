package com.example.SpringAOp;

import org.junit.jupiter.api.Test;

/**
 * Created by lin on 2018/9/8.
 */
public class jDKsecondproxy {

    public static void main(String[] args) {
        Helloimp helloimp = new Helloimp();
        MyInvocationHandler myInvocationHandler = new MyInvocationHandler(helloimp);
        Hello t = (Hello) myInvocationHandler.getProxy();
        t.say();
        MyInvocationHandler myInvocationHandler1 = new MyInvocationHandler(t);
        Hello t1 = (Hello) myInvocationHandler1.getProxy();
        t1.say();
    }

}
