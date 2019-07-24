package com.ljy.Spring0011;

import org.junit.Assert;

public class OutputService {
    private HelloService helloService;

    public void setHelloService(HelloService helloService) {
        this.helloService = helloService;
    }

    public void output(String text){
        Assert.assertNotNull(helloService);
        System.out.println(text);
    }
}
