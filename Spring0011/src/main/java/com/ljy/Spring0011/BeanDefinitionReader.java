package com.ljy.Spring0011;

/**
 * @author ljy
 * @create 2019-07-23
 * @desc 从配置中读取BeanDefinition
 */
public interface BeanDefinitionReader {
    void loadBeanDefinitions(String localtion) throws Exception;
}
