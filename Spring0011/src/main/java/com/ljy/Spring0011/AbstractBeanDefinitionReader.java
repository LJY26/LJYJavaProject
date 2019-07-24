package com.ljy.Spring0011;

import com.ljy.Spring0011.io.ResourceLoader;

import java.util.HashMap;
import java.util.Map;

/**
 * @author ljy
 * @create 2019-07-23
 * @desc 从配置中读取BeanDefinition
 */
public  abstract  class AbstractBeanDefinitionReader implements BeanDefinitionReader {

    private Map<String,BeanDefinition> registry;

    private ResourceLoader resourceLoader;

    public AbstractBeanDefinitionReader(ResourceLoader resourceLoader) {
        this.registry=new HashMap<>();
        this.resourceLoader = resourceLoader;
    }

    public Map<String, BeanDefinition> getRegistry() {
        return registry;
    }

    public ResourceLoader getResourceLoader() {
        return resourceLoader;
    }

}
