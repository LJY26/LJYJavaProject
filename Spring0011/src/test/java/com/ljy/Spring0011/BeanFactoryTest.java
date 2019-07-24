package com.ljy.Spring0011;

import com.ljy.Spring0011.aop.*;
import com.ljy.Spring0011.context.ApplicationContext;
import com.ljy.Spring0011.context.ClassPathXmlApplicationContext;
import com.ljy.Spring0011.factory.AutowireCapableBeanFactory;
import com.ljy.Spring0011.factory.BeanFactory;
import com.ljy.Spring0011.io.ResourceLoader;
import com.ljy.Spring0011.xml.XmlBeanDefinitionReader;
import org.junit.Assert;
import org.junit.Test;

import java.util.Map;


public class BeanFactoryTest {


    @Test
    public void HelloServiceTest(){

        // region 版本1
//        //初始化Factory
//        BeanFactory beanFactory=new BeanFactory();
//
//        //注入
//        BeanDefine beanDefine=new BeanDefine(new HelloService());
//        beanFactory.registerBeanDefinition("com.ljy.Spring0011.HelloService",beanDefine);
//
//        //获取Bean
//        HelloService helloService=(HelloService)beanFactory.getBean("com.ljy.Spring0011.HelloService");
//        helloService.print();
        // endregion


        // region 版本2 使用类名创建对象
//        BeanFactory beanFactory=new AutowireCapableBeanFactory();
//
//        BeanDefinition beanDefinition=new BeanDefinition();
//        beanDefinition.setBeanClassName("com.ljy.Spring0011.HelloService");
//        beanFactory.registerBeanDefinition("HelloService",beanDefinition);
//
//        HelloService helloService=(HelloService)beanFactory.getBean("HelloService");
//        helloService.print();
        //endregion

        // region 版本3 Bean属性注入
//        try {
//            BeanFactory beanFactory = new AutowireCapableBeanFactory();
//
//            BeanDefinition beanDefinition = new BeanDefinition();
//            beanDefinition.setBeanClassName("com.ljy.Spring0011.HelloService");
//
//            PropertyValues propertyValues = new PropertyValues();
//            propertyValues.addPropertyValue(new PropertyValue("helloMessage", "你好"));
//            propertyValues.addPropertyValue(new PropertyValue("helloMessage", "Hello"));
//            beanDefinition.setPropertyValues(propertyValues);
//
//            beanFactory.registerBeanDefinition("HelloService", beanDefinition);
//
//            HelloService helloService = (HelloService) beanFactory.getBean("HelloService");
//            helloService.print();
//        }catch (Exception ex){
//            ex.printStackTrace();
//        }
        //endregion

        //region 版本4 xml注入
//        try {
//            XmlBeanDefinitionReader reader = new XmlBeanDefinitionReader(new ResourceLoader());
//            reader.loadBeanDefinitions("bean.xml");
//
//            BeanFactory beanFactory=new AutowireCapableBeanFactory();
//            for(Map.Entry<String,BeanDefinition> beanDefinitionEntry:reader.getRegistry().entrySet()){
//                beanFactory.registerBeanDefinition(beanDefinitionEntry.getKey(),beanDefinitionEntry.getValue());
//            }
//
//            HelloService helloService = (HelloService) beanFactory.getBean("helloService");
//            helloService.print();
//        }catch (Exception ex){
//            ex.printStackTrace();
//        }
        //endregion

        //region 版本 5.1 bean之间相互引用 懒加载

//        try{
//            XmlBeanDefinitionReader reader=new XmlBeanDefinitionReader(new ResourceLoader());
//            reader.loadBeanDefinitions("bean.xml");
//
//            BeanFactory beanFactory=new AutowireCapableBeanFactory();
//            for(Map.Entry<String,BeanDefinition> beanDefinitionEntry:reader.getRegistry().entrySet()){
//                beanFactory.registerBeanDefinition(beanDefinitionEntry.getKey(),beanDefinitionEntry.getValue());
//            }
//
//            HelloService helloService=(HelloService) beanFactory.getBean("helloService");
//            helloService.output();
//        }catch (Exception ex){
//            ex.printStackTrace();
//        }
        //endregion

        //region 版本5.2 bean之间相互引用 预加载
//        try{
//            XmlBeanDefinitionReader reader=new XmlBeanDefinitionReader(new ResourceLoader());
//            reader.loadBeanDefinitions("bean.xml");
//
//            BeanFactory beanFactory=new AutowireCapableBeanFactory();
//            for(Map.Entry<String,BeanDefinition> beanDefinitionEntry:reader.getRegistry().entrySet()){
//                beanFactory.registerBeanDefinition(beanDefinitionEntry.getKey(),beanDefinitionEntry.getValue());
//            }
//
//            ((AutowireCapableBeanFactory) beanFactory).preInstantiateSingletons();
//
//            HelloService helloService=(HelloService) beanFactory.getBean("helloService");
//            helloService.output();
//        }catch (Exception ex){
//            ex.printStackTrace();
//        }
        //endregion

        //region 版本 6 spring上下文
//        try {
//            ApplicationContext applicationContext = new ClassPathXmlApplicationContext("bean.xml");
//            HelloService helloService=(HelloService)applicationContext.getBean("helloService");
//            helloService.output();
//            helloService.print();
//        }catch (Exception ex){
//            ex.printStackTrace();
//        }
        //endregion

        //region 版本7 aop 代理
//        try {
//            ApplicationContext applicationContext = new ClassPathXmlApplicationContext("bean.xml");
//            HelloSpringService helloService = (HelloSpringService) applicationContext.getBean("helloService");
//
//            AdvisedSupport advisedSupport = new AdvisedSupport();
//            TargetSource targetSource = new TargetSource(HelloSpringService.class, helloService);
//            advisedSupport.setTargetSource(targetSource);
//
//            TimerInterceptor timerInterceptor = new TimerInterceptor();
//            advisedSupport.setMethodInterceptor(timerInterceptor);
//
//
//            JdkDynamicAopProxy jdkDynamicAopProxy=new JdkDynamicAopProxy(advisedSupport);
//            HelloSpringService helloServiceProxy=(HelloSpringService)jdkDynamicAopProxy.getProxy();
//
//            helloServiceProxy.print();
//        }catch (Exception ex){
//            ex.printStackTrace();
//        }

        //endregion

        //region 版本8 /9 aop pointcut 代理/aop proxy
//        try{
//            String expression="execution(* com.ljy.Spring0011.*.*(..))";
//            AspectJExpressionPointcut aspectJExpressionPointcut=new AspectJExpressionPointcut();
//            aspectJExpressionPointcut.setExpression(expression);
//            boolean matches=aspectJExpressionPointcut.getClassFilter().matches(HelloSpringService.class);
//            Assert.assertTrue(matches);
//            matches=aspectJExpressionPointcut.getMethodMatcher().matches(HelloSpringService.class.getDeclaredMethod("print"),HelloSpringService.class);
//            Assert.assertTrue(matches);
//        }catch (Exception ex){
//            ex.printStackTrace();
//        }
        //enregion

        //region 版本10
        try {
            ApplicationContext applicationContext = new ClassPathXmlApplicationContext("bean.xml");
            HelloSpringService helloSpringService = (HelloSpringService)applicationContext.getBean("helloService");
            helloSpringService.print();

            AdvisedSupport advisedSupport=new AdvisedSupport();
            TargetSource targetSource=new TargetSource(helloSpringService,HelloService.class,HelloSpringService.class);
            advisedSupport.setTargetSource(targetSource);

            TimerInterceptor timerInterceptor=new TimerInterceptor();
            advisedSupport.setMethodInterceptor(timerInterceptor);

            Cglib2AopProxy proxy=new Cglib2AopProxy(advisedSupport);
            HelloSpringService serviceProxy=(HelloSpringService)proxy.getProxy();

            serviceProxy.print();
        }catch (Exception ex){
            ex.printStackTrace();
        }
        //endregion
    }

    @Test
    public void testXMlReader() throws Exception {
        XmlBeanDefinitionReader xmlBeanDefinitionReader = new XmlBeanDefinitionReader(new ResourceLoader());
        xmlBeanDefinitionReader.loadBeanDefinitions("bean.xml");
        Map<String, BeanDefinition> registry = xmlBeanDefinitionReader.getRegistry();
        Assert.assertTrue(registry.size() > 0);
    }
}
