package com.ljy.Spring0011.context;

import com.ljy.Spring0011.factory.AbstractBeanFactory;

public abstract class AbstractApplicationContext implements ApplicationContext{

    protected AbstractBeanFactory beanFactory;

    public AbstractApplicationContext(AbstractBeanFactory beanFactory) {
        this.beanFactory = beanFactory;
    }

    public void refresh() throws Exception{

    }

    @Override
    public Object getBean(String name) throws Exception{
        return beanFactory.getBean(name);
    }
}
