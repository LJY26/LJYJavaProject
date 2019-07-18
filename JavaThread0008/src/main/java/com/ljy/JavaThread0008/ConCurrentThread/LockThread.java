package com.ljy.JavaThread0008.ConCurrentThread;

public class LockThread extends Thread {

    LockPrintDemo printDemo;

    public LockThread(String name,LockPrintDemo printDemo){
        super(name);
        this.printDemo=printDemo;
    }

    @Override
    public void run() {
        System.out.printf("%s starts printing a document \n",Thread.currentThread().getName());
        printDemo.print();
    }
}
