package com.ljy.Spring0011.aop;


import org.aopalliance.intercept.MethodInterceptor;

import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Method;
import java.lang.reflect.Proxy;

/**
 * @author ljy
 * @create 2019-07-23
 * @desc 基于JDK动态代理
 */
public class JdkDynamicAopProxy implements AopProxy,InvocationHandler {

    private AdvisedSupport advised;

    public JdkDynamicAopProxy(AdvisedSupport advised) {
        this.advised = advised;
    }

    public Object getProxy() {
//        return Proxy.newProxyInstance(getClass().getClassLoader(),new Class[]{advisd.getTargetSource().getTargetClass()},this);
        return Proxy.newProxyInstance(getClass().getClassLoader(),advised.getTargetSource().getInterfaces(),this);

    }

    public Object invoke(Object proxy, Method method, Object[] args)throws Throwable {
        MethodInterceptor interceptor=advised.getMethodInterceptor();
        if(advised.getMethodMatcher()!=null
                &&advised.getMethodMatcher().matches(method,advised.getTargetSource().getTarget().getClass())){
            return interceptor.invoke(new ReflectiveMethodInvocation(advised.getTargetSource().getTarget(),method,args));
        }
        return method.invoke(new ReflectiveMethodInvocation(advised.getTargetSource().getTarget(),method,args));
    }
}
