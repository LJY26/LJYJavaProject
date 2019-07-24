package com.ljy.Spring0011.context;

import com.ljy.Spring0011.BeanDefinition;
import com.ljy.Spring0011.factory.AbstractBeanFactory;
import com.ljy.Spring0011.factory.AutowireCapableBeanFactory;
import com.ljy.Spring0011.io.ResourceLoader;
import com.ljy.Spring0011.xml.XmlBeanDefinitionReader;

import java.util.Map;

public class ClassPathXmlApplicationContext extends AbstractApplicationContext {

    private String configLocation;

    public ClassPathXmlApplicationContext(String configLocation) throws Exception{
        this(new AutowireCapableBeanFactory(),configLocation);
    }

    public ClassPathXmlApplicationContext(AbstractBeanFactory beanFactory, String configLocation)throws Exception {
        super(beanFactory);
        this.configLocation = configLocation;
        refresh();
    }

    @Override
    public void refresh() throws Exception {
        XmlBeanDefinitionReader reader=new XmlBeanDefinitionReader(new ResourceLoader());
        reader.loadBeanDefinitions(this.configLocation);
        for(Map.Entry<String,BeanDefinition> beanDefinitionEntry:reader.getRegistry().entrySet()){
            beanFactory.registerBeanDefinition(beanDefinitionEntry.getKey(),beanDefinitionEntry.getValue());
        }
    }

    @Override
    public void registerBeanDefinition(String name, BeanDefinition beanDefinition) throws Exception {
        beanFactory.registerBeanDefinition(name,beanDefinition);
    }


}
