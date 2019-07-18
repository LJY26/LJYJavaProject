package com.ljy.JavaThread0008;

public class TestJoinThread extends Thread {
    public void run(){
        for (int i=0;i<5;i++){
            try{
                if(Thread.currentThread().isDaemon()){
                    Thread.sleep(1000);
                }else {
                    Thread.sleep(500);
                }
            }catch (InterruptedException ex){
                System.out.print(ex);
            }
            System.out.println(i+" "+Thread.currentThread().getName()+"-"+Thread.currentThread().getId());
        }
    }
}
