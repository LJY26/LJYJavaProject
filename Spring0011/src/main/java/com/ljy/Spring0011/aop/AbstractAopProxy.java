package com.ljy.Spring0011.aop;

public abstract class AbstractAopProxy implements AopProxy {
    protected AdvisedSupport advised;

    public AbstractAopProxy(AdvisedSupport advisedSupport){
        this.advised=advisedSupport;
    }
}
