package com.ljy.JavaThread0008.ConCurrentThread;

import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

public class LockPrintDemo {

    private final Lock queueLock=new ReentrantLock();

    public void print(){
        queueLock.lock();

        try{
            Long duration=(long)(Math.random()*10000);
            System.out.println(Thread.currentThread().getName()
                +" Time Taken "+(duration/1000)+" seconds.");
            Thread.sleep(duration);
        }catch (InterruptedException e){
            e.printStackTrace();
        }finally {
            System.out.printf("%s printed the document successfuly .\n",Thread.currentThread().getName());
            queueLock.unlock();
        }
    }
}
