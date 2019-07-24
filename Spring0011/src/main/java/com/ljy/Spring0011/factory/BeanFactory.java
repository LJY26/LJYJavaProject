package com.ljy.Spring0011.factory;

import com.ljy.Spring0011.BeanDefinition;

/**
 * @author ljy
 * @create 2019-07-23
 * @desc 创建Bean 工作类
 */
public interface BeanFactory {

    /**
     * 获取Bean
     * @param name
     * @return
     */
    Object getBean(String name) throws Exception;

    /**
     * 注册Bean
     * @param name
     * @param beanDefinition
     */
    void registerBeanDefinition(String name, BeanDefinition beanDefinition)  throws Exception ;

}
