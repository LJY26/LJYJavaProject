package com.ljy.Spring0011.Bean;

import com.Ljy.Spring0011.Bean.BeanDefine;
import com.Ljy.Spring0011.Bean.BeanFactory;
import org.junit.Test;


public class BeanFactoryTest {


    @Test
    public void HelloServiceTest(){

        //初始化Factory
        BeanFactory beanFactory=new BeanFactory();

        //注入
        BeanDefine beanDefine=new BeanDefine(new HelloService());
        beanFactory.registerBeanDefinition("HelloService",beanDefine);

        //获取Bean
        HelloService helloService=(HelloService)beanFactory.getBean("HelloService");
        helloService.print();


    }
}
