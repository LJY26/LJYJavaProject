package com.ljy.Spring0011.factory;

import com.ljy.Spring0011.BeanDefinition;
import com.ljy.Spring0011.BeanPostProcessor;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;

/**
 * @author ljy
 * @create 2019-07-23
 * @desc 抽象方法
 */
public abstract class AbstractBeanFactory implements BeanFactory {

    private Map<String,BeanDefinition> beanDefinitionMap=new ConcurrentHashMap<String,BeanDefinition>();
    private final List<String> beanDefinitionNames=new ArrayList<>();
    private List<BeanPostProcessor> beanPostProcessors=new ArrayList<>();

    @Override
    public Object getBean(String name) throws Exception{
//        return beanDefinitionMap.get(name).getBean()

        BeanDefinition beanDefinition= beanDefinitionMap.get(name);
        if(beanDefinition==null){
            throw new IllegalArgumentException("No bean named " + name + " is defined");
        }
        Object bean=beanDefinition.getBean();
        if(bean==null){
            bean=doCreateBean(beanDefinition);
            initializeBean(bean,name);
        }
        return bean;

    }

    protected void initializeBean(Object bean,String beanName) throws Exception{
        for (BeanPostProcessor beanPostProcessor:beanPostProcessors){
            bean=beanPostProcessor.postProcessBeforeInitialization(bean,beanName);
        }

        for(BeanPostProcessor beanPostProcessor:beanPostProcessors){
            bean=beanPostProcessor.postProcessAfterInitialization(bean,beanName);
        }
    }

    /**
     *
     * @param beanDefinition
     * @return
     * @throws InstantiationException
     * @throws IllegalAccessException
     */
    protected Object createBeanInstance(BeanDefinition beanDefinition) throws InstantiationException,IllegalAccessException{
        return beanDefinition.getBeanClass().newInstance();
    }

    @Override
    public void registerBeanDefinition(String name, BeanDefinition beanDefinition) throws Exception {
//        Object object=doCreateBean(beanDefinition);
//        beanDefinition.setBean(object);
        beanDefinitionMap.put(name,beanDefinition);
        beanDefinitionNames.add(name);
    }

    public void preInstantiateSingletons() throws Exception{
        for(Iterator it=this.beanDefinitionNames.iterator();it.hasNext();){
            String beanName=(String)it.next();
            getBean(beanName);
        }
    }

    protected Object doCreateBean(BeanDefinition beanDefinition) throws Exception{
        Object bean=createBeanInstance(beanDefinition);
        beanDefinition.setBean(bean);
        applyPropertyValues(bean,beanDefinition);
        return bean;
    }

    protected void applyPropertyValues(Object bean,BeanDefinition beanDefinition)throws Exception{

    }

    public void addBeanPostProcessor(BeanPostProcessor beanPostProcessor)throws Exception{
        this.beanPostProcessors.add(beanPostProcessor);
    }

    public List getBeansForType(Class type)throws Exception{
        List beans=new ArrayList<Object>();
        for(String beanDefinitionName:beanDefinitionNames){
            if(type.isAssignableFrom(beanDefinitionMap.get(beanDefinitionName).getBeanClass())){
                beans.add(getBean(beanDefinitionName));
            }
        }
        return beans;
    }


}
