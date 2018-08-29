package com.util;

import com.autoproxy.Adapter.AdviceAdapter;
import com.autoproxy.Adapter.AfterReturningAdviceAdapter;
import com.autoproxy.Adapter.MethodBeforeAdviceAdapter;
import org.aopalliance.aop.Advice;
import org.aopalliance.intercept.MethodInterceptor;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by zoujianglin
 * 2018/8/29 0029.
 */
public class AdviceUtil {

    private static List<AdviceAdapter> adviceAdapters;

    static {
        adviceAdapters = new ArrayList<AdviceAdapter>();
        adviceAdapters.add(new MethodBeforeAdviceAdapter());
        adviceAdapters.add(new AfterReturningAdviceAdapter());


    }


    /**
     * 使用第一个符合条件的适配器进行适配，并返回相应拦截器
     *
     * @param advice
     * @return
     */
    public static MethodInterceptor getMethodInterceptor(Advice advice) {
        for (int i = 0; i < adviceAdapters.size(); i++) {
            AdviceAdapter adviceAdapter = adviceAdapters.get(i);
            if (adviceAdapter.supportsAdvice(advice)) {
                return adviceAdapter.getInterceptor(advice);
            }

        }
        return null;
    }

    public static void registerAdapter(AdviceAdapter adviceAdapter) {
        adviceAdapters.add(adviceAdapter);

    }

}
