package com.ljy.Spring0011;

public interface BeanPostProcessor {
    Object postProcessBeforeInitialization(Object bean,String beanName)throws Exception;

    Object postProcessAfterInitialization(Object bean,String beanName)throws Exception;

}
