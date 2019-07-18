package com.ljy.JavaThread0008.ConCurrentThread;

public class ThreadPrint extends Thread {

    private Thread t;
    private String threadName;
    private PrintDemo printDemo;

    public ThreadPrint(String threadName,PrintDemo printDemo){
        this.printDemo=printDemo;
        this.threadName=threadName;
    }

    @Override
    public void run() {
        synchronized (printDemo){
            printDemo.printCount();
        }
        System.out.println("Thread "+threadName+" exiting.");
    }

    public void start(){
        System.out.println("Thread Starting "+threadName);
        if(t==null){
            t=new Thread(this,threadName);
            t.start();
        }
    }

}
