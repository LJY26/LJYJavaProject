package com.ljy.JavaThread0008.ConCurrentThread;

public class AnswerRunnable implements Runnable {
    Chat m;
    String[] s2={"Hi","I am good,what about you ","Great!"};

    public AnswerRunnable(Chat m1){
        this.m=m1;
        new Thread(this,"Answer").start();
    }

    public void run() {
        for (int i=0;i<s2.length;i++){
            m.Answer(s2[i]);
        }
    }
}
