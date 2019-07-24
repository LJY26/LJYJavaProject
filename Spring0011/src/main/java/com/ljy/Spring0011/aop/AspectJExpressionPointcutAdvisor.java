package com.ljy.Spring0011.aop;

import org.aspectj.weaver.Advice;

public class AspectJExpressionPointcutAdvisor implements PointcutAdvisor {

    private AspectJExpressionPointcut pointcut=new AspectJExpressionPointcut();
    private Advice advice;

    public void setAdvice(Advice advice) {
        this.advice = advice;
    }

    public void  setExpression(String expression){
        this.pointcut.setExpression(expression);
    }

    @Override
    public Pointcut getPointcut() {
        return pointcut;
    }

    @Override
    public Advice getAdvice() {
        return advice;
    }
}
