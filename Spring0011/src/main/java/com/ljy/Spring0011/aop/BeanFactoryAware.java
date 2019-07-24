package com.ljy.Spring0011.aop;

import com.ljy.Spring0011.factory.BeanFactory;

public interface BeanFactoryAware {
    void setBeanFactory(BeanFactory beanFactory)throws Exception;
}
