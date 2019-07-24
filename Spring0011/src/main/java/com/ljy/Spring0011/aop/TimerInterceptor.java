package com.ljy.Spring0011.aop;

import org.aopalliance.intercept.MethodInterceptor;
import org.aopalliance.intercept.MethodInvocation;

public class TimerInterceptor implements MethodInterceptor {

    public Object invoke(MethodInvocation methodInvocation) throws Throwable{
        long time=System.nanoTime();

        System.out.println("Invocation of Method"+methodInvocation.getMethod().getName()+" start!");
        Object proceed=methodInvocation.proceed();
        System.out.println("Invocation of Method"+methodInvocation.getMethod().getName()+" end!");

        return proceed;
    }
}
