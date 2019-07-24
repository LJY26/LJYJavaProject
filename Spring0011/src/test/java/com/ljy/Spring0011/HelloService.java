package com.ljy.Spring0011;

public class HelloService implements HelloSpringService {

    private String helloMessage;

    private OutputService outputService;

    public String getHelloMessage() {
        return helloMessage;
    }

    public void setHelloMessage(String helloMessage) {
        this.helloMessage = helloMessage;
    }

    public void setOutputService(OutputService outputService) {
        this.outputService = outputService;
    }

    public void print(){
        System.out.println(helloMessage);
    }

    public void output(){
        outputService.output(helloMessage);
    }
}
