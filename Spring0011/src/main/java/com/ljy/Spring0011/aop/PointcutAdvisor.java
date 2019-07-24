package com.ljy.Spring0011.aop;

public interface PointcutAdvisor extends Advisor {
    Pointcut getPointcut();
}
