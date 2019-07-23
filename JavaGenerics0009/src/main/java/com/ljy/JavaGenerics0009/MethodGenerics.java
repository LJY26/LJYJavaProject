package com.ljy.JavaGenerics0009;

public class MethodGenerics {


    public static <E> void printArray(E[] inputArray){
        for(E element:inputArray){
            System.out.printf("%s ",element);
        }

        System.out.println();
    }

    public static void main(String[] args){
        Integer[] intArray={1,2,3,4,5};
        String[] strArray={"a","b","c","d","e","f"};

        System.out.println("Integer array:");
        printArray(intArray);
        System.out.println("String array:");
        printArray(strArray);
    }
}
