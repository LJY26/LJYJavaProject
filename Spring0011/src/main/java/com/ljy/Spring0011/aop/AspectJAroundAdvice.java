package com.ljy.Spring0011.aop;

import com.ljy.Spring0011.factory.BeanFactory;
import org.aopalliance.aop.Advice;
import org.aopalliance.intercept.MethodInterceptor;
import org.aopalliance.intercept.MethodInvocation;

import java.lang.reflect.Method;

public class AspectJAroundAdvice implements Advice,MethodInterceptor {

    private BeanFactory beanFactory;

    private Method aspectJAdviceMethod;

    private String aspectInstanceName;


    @Override
    public Object invoke(MethodInvocation methodInvocation) throws Throwable {
        return aspectJAdviceMethod.invoke(beanFactory.getBean(aspectInstanceName),methodInvocation);
    }

    public Method getAspectJAdviceMethod() {
        return aspectJAdviceMethod;
    }

    public void setAspectJAdviceMethod(Method aspectJAdviceMethod) {
        this.aspectJAdviceMethod = aspectJAdviceMethod;
    }

    public String getAspectInstanceName() {
        return aspectInstanceName;
    }

    public void setAspectInstanceName(String aspectInstanceName) {
        this.aspectInstanceName = aspectInstanceName;
    }
}
