package com.ljy.Spring0011.factory;


import com.ljy.Spring0011.BeanDefinition;
import com.ljy.Spring0011.BeanReference;
import com.ljy.Spring0011.PropertyValue;
import com.ljy.Spring0011.aop.BeanFactoryAware;

import java.lang.reflect.Field;
import java.lang.reflect.Method;

/**
 * @author ljy
 * @create 2019-07-23
 */
public class AutowireCapableBeanFactory extends AbstractBeanFactory {
//    @Override
//    protected Object doCreateBean(BeanDefinition beanDefinition) throws Exception {
////        try{
////            Object bean=beanDefinition.getBeanClass().newInstance();
////            return bean;
////        }catch (InstantiationException ex){
////            ex.printStackTrace();
////        }catch (IllegalAccessException ex){
////            ex.printStackTrace();
////        }
////        return null;
//
//        Object bean=createBeanInstance(beanDefinition);
//        beanDefinition.setBean(bean);
//        applyPropertyValues(bean,beanDefinition);
//        return bean;
//    }


//    /**
//     *
//     * @param beanDefinition
//     * @return
//     * @throws InstantiationException
//     * @throws IllegalAccessException
//     */
//    protected Object createBeanInstance(BeanDefinition beanDefinition) throws InstantiationException,IllegalAccessException{
//        return beanDefinition.getBeanClass().newInstance();
//    }

    /**
     *
     * @param bean
     * @param beanDefinition
     * @throws NoSuchFieldException
     * @throws IllegalAccessException
     */
    protected void applyPropertyValues(Object bean,BeanDefinition beanDefinition) throws Exception{
//        for (PropertyValue propertyValue:beanDefinition.getPropertyValues().getPropertyValues()){
//            Field declaredField=bean.getClass().getDeclaredField(propertyValue.getName());
//            declaredField.setAccessible(true);
//            Object value=propertyValue.getValue();
//            if(value instanceof BeanReference){
//                BeanReference beanReference=(BeanReference)value;
//                value=getBean(beanReference.getName());
//            }
//            declaredField.set(bean,value);
//        }

        if(bean instanceof BeanFactoryAware){
            ((BeanFactoryAware)bean).setBeanFactory(this);
        }
        for(PropertyValue propertyValue:beanDefinition.getPropertyValues().getPropertyValues()){
            Object value=propertyValue.getValue();
            if(value instanceof BeanReference){
                BeanReference beanReference=(BeanReference)value;
                value=getBean(beanReference.getName());
            }
            try{
                Method declaredMethod=bean.getClass().getDeclaredMethod("set"+propertyValue.getName().substring(0,1).toLowerCase()
                                        +propertyValue.getName().substring(1),value.getClass());
                declaredMethod.setAccessible(true);
                declaredMethod.invoke(bean,value);
            }catch (NoSuchMethodException e){
                Field declaredField=bean.getClass().getDeclaredField(propertyValue.getName());
                declaredField.setAccessible(true);
                declaredField.set(bean,value);
            }
        }
    }
}
