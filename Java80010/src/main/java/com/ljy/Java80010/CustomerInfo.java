package com.ljy.Java80010;

public class CustomerInfo {

    private int age;

    private String name;

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public CustomerInfo() {
    }

    public CustomerInfo(int age, String name) {
        this.age = age;
        this.name = name;
    }
}
