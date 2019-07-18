package com.ljy.JavaThread0008.ConCurrentThread;

public class PrintDemo {

    public void printCount(){
        try{
            for(int i=5;i>0;i--){
                System.out.println("Counter ----- "+i);
            }
        }catch (Exception ex){
            System.out.println("Thread Interrupt");
        }
    }
}
