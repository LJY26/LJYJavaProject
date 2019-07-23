package com.Ljy.Spring0011.Bean;

import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;

/**
 * @author ljy
 * @create 2019-07-23
 */
public class BeanFactory {

    private Map<String,BeanDefine> beanDefineMap=new ConcurrentHashMap<String,BeanDefine>();

    public Object getBean(String name){
        return beanDefineMap.get(name).getBean();
    }

    public void registerBeanDefinition(String name,BeanDefine beanDefine){
        beanDefineMap.put(name,beanDefine);
    }
}
