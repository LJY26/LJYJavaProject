package com.ljy.Spring0011.aop;

import java.lang.reflect.Method;

public interface MethodMatcher {
    boolean matches(Method method,Class targtetClass);
}
