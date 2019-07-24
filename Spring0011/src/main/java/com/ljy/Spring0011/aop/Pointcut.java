package com.ljy.Spring0011.aop;

public interface Pointcut {
    ClassFilter getClassFilter();

    MethodMatcher getMethodMatcher();

}
