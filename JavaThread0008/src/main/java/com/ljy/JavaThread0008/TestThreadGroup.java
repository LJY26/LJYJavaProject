package com.ljy.JavaThread0008;

public class TestThreadGroup implements Runnable {
    public void run() {
        System.out.println(Thread.currentThread().getName());
    }
}
