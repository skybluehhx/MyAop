package com.example.SpringAOp;

import com.annotations.EnableAop;
import com.annotations.InterceptorAdvice;
import com.example.MyMethodBeforeAdvice;
import org.springframework.stereotype.Component;

/**
 * Created by lin on 2018/9/8.
 */
@Component
@EnableAop
public class Helloimp implements Hello {
    @InterceptorAdvice(advices = MyMethodBeforeAdvice.class)
    public void say() {
        System.out.println("springAop hello");
    }
}
