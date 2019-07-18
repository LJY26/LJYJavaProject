package com.ljy.JavaThread0008;

public class WorkerThread implements Runnable {
    private String message;

    public WorkerThread(String message){
        this.message=message;
    }
    public void run() {
        System.out.println(Thread.currentThread().getName()+" Start message ="+message);
        processmessage();
        System.out.println(Thread.currentThread().getName()+" end ");
    }

    private void processmessage(){
        try{
            Thread.sleep(500);
        }catch (InterruptedException ex){
            ex.printStackTrace();
        }
    }
}
