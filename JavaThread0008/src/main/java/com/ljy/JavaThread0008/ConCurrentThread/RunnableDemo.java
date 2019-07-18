package com.ljy.JavaThread0008.ConCurrentThread;

public class RunnableDemo implements Runnable {

    public Thread t;
    private String threadName;
    private boolean suspended=false;

    public RunnableDemo(String threadName){
        this.threadName=threadName;
        System.out.println("Creating thread:"+threadName);
    }

    public void run() {
        System.out.println("Running "+threadName);
        try{
            for (int i=0;i<=4;i++){
                System.out.println("Thread:"+threadName+"-"+i);
                Thread.sleep(300);
                synchronized(this) {
                    while(suspended) {
                        wait();
                    }
                }

            }
        }catch (InterruptedException ex){
            System.out.println("Thread "+threadName+"interrupt");
        }
        System.out.println("Thread "+threadName+" existing");
    }

    public void  start(){
        System.out.println("starting "+threadName);
        if(t==null){
            t=new Thread(this,threadName);
            t.start();
        }
    }

    public void suspend(){
        suspended=true;
    }

    public synchronized void resume(){
        suspended=false;
        notify();
    }
}
