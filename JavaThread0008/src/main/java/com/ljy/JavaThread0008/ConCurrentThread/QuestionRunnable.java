package com.ljy.JavaThread0008.ConCurrentThread;

public class QuestionRunnable implements Runnable {
    Chat m;
    String[] s1={"Hi","How are you?","I am also doing fine!"};

    public QuestionRunnable(Chat m1){
        this.m=m1;
        new Thread(this,"Question").start();
    }

    public void run() {
        for(int i=0;i<s1.length;i++){
            m.Question(s1[i]);
        }
    }
}
