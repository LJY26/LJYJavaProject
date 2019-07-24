package com.ljy.Spring0011.aop;

import com.ljy.Spring0011.BeanPostProcessor;
import com.ljy.Spring0011.factory.AbstractBeanFactory;
import com.ljy.Spring0011.factory.BeanFactory;
import org.aopalliance.intercept.MethodInterceptor;

import java.util.List;

public class AspectJAwareAdvisorAutoProxyCreator implements BeanPostProcessor,BeanFactoryAware {

    private AbstractBeanFactory abstractBeanFactory;

    @Override
    public Object postProcessBeforeInitialization(Object bean, String beanName) throws Exception {
        return bean;
    }

    @Override
    public Object postProcessAfterInitialization(Object bean, String beanName) throws Exception {
        if(bean instanceof AspectJExpressionPointcutAdvisor){
            return bean;
        }
        if(bean instanceof MethodInterceptor){
            return bean;
        }
        List<AspectJExpressionPointcutAdvisor> advisors=abstractBeanFactory.getBeansForType(AspectJExpressionPointcutAdvisor.class);
        for(AspectJExpressionPointcutAdvisor advisor:advisors){
            AdvisedSupport advisedSupport=new AdvisedSupport();
            advisedSupport.setMethodInterceptor((MethodInterceptor)advisor.getAdvice());
            advisedSupport.setMethodMatcher(advisor.getPointcut().getMethodMatcher());

            TargetSource targetSource=new TargetSource(bean,bean.getClass(),bean.getClass().getInterfaces());
            advisedSupport.setTargetSource(targetSource);

            return new JdkDynamicAopProxy(advisedSupport).getProxy();
        }
        return bean;
    }

    @Override
    public void setBeanFactory(BeanFactory beanFactory) throws Exception {
        this.abstractBeanFactory=(AbstractBeanFactory)beanFactory;
    }
}
