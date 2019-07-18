package com.ljy.JavaThread0008;

public class TestGarbage {
    public void finalize(){
        System.out.println("object is garbage collected");
    }
}
