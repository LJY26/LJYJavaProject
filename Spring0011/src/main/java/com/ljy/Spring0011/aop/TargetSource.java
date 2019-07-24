package com.ljy.Spring0011.aop;

/**
 * @author ljy
 * @create 2019-07-23
 * @desc 被代理的对象
 */
public class TargetSource {

//    private Class targetClass;

    private Object target;
    private Class<?> targetClass;
    private Class<?>[] interfaces;

    public TargetSource(Object target,Class<?> targetClass, Class<?>... interfaces) {
        this.target = target;
        this.targetClass = targetClass;
        this.interfaces=interfaces;
    }

    //    public TargetSource(Class targetClass, Object target) {
//        this.targetClass = targetClass;
//        this.target = target;
//    }
//
//
//
//    public Class getTargetClass() {
//        return targetClass;
//    }


    public Class<?> getTargetClass() {
        return targetClass;
    }

    public Class<?>[] getInterfaces() {
        return interfaces;
    }

    public Object getTarget() {
        return target;
    }
}
