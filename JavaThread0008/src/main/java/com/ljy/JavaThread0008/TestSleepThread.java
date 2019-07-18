package com.ljy.JavaThread0008;

public class TestSleepThread extends Thread {
    public void run(){
        for (int i=0;i<5;i++){
            try{
                Thread.sleep(500);
            }catch (InterruptedException ex){
                System.out.print(ex);
            }
            System.out.println(i);
        }
    }
}
