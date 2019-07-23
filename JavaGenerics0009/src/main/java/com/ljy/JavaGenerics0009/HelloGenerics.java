package com.ljy.JavaGenerics0009;

public class HelloGenerics {


    public static void main(String[] args){
        Box<Integer> integerBox=new Box<>();
        Box<String> stringBox=new Box<String>();

        integerBox.add(666);
        stringBox.add("Hello World");

        System.out.printf("Integer value :%d\n",integerBox.get());
        System.out.printf("String value:%s\n",stringBox.get());
    }

    private static class Box<T>{
        private T t;

        public void add(T t){
            this.t=t;
        }
        public T get(){
            return t;
        }
    }
}
