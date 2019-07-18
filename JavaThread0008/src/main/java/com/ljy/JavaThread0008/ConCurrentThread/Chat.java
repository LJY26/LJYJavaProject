package com.ljy.JavaThread0008.ConCurrentThread;

public class Chat {

    boolean flag=false;

    public synchronized void Question(String msg){
        if(flag){
            try{
                wait();
            }catch (InterruptedException ex){
                ex.printStackTrace();
            }
        }
        System.out.println(msg);
        flag=true;
        notify();
    }

    public synchronized void Answer(String msg){
        if(!flag){
            try{
                wait();
            }catch (InterruptedException ex){
                ex.printStackTrace();
            }
        }
        System.out.println(msg);
        flag=false;
        notify();
    }
}
