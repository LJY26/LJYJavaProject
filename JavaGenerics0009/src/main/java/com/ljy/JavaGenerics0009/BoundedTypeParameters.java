package com.ljy.JavaGenerics0009;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Calendar;
import java.util.List;

public class BoundedTypeParameters {

    public static <T extends Comparable<T>> T maximum(T x,T y,T z){
        T max=x;
        if(y.compareTo(max)>0)max=y;
        if(z.compareTo(max)>0)max=z;
        return max;
    }

    public static <T extends  Number & Comparable<T>> T maximum2(T x,T y,T z){
        T max=x;
        if(y.compareTo(max)>0)max=y;
        if(z.compareTo(max)>0)max=z;
        return max;
    }

    public static double sum(List<? extends Number> numbers){
        double sum=0.0;
        for (Number n:numbers){
            sum+=n.doubleValue();
        }
        return sum;
    }

    private static class Animal{}

    private static class Cat extends Animal{}

    private static class RedCat extends Cat{}

    private static class Dog extends Animal{}

    public static void addCat(List<? super Cat> objects){
        objects.add(new RedCat());
        System.out.println("Cat Added");
    }

    public static void printAll(List<?> list){
        for (Object item:list){
            System.out.println(item+" ");
        }
    }

    public static void main(String[] args){
        System.out.printf("Max of %d %d and %d is %d \n\n",3,5,4,maximum(3,5,4));
        System.out.printf("Max of %.1f %.1f and %.1f is %.1f \n\n",6.7,6.8,6.6,maximum(6.7,6.8,6.6));
        System.out.printf("Max of %s %s %s is %s \n\n","apple","cat","aa",maximum("apple","cat","aa"));


        System.out.printf("Max2 of %d %d and %d is %d \n\n",3,5,4,maximum2(3,5,4));
        System.out.printf("Max2 of %.1f %.1f and %.1f is %.1f \n\n",6.7,6.8,6.6,maximum2(6.7,6.8,6.6));
//        System.out.printf("Max2 of %s %s %s is %s \n\n","apple","cat","aa",maximum2("apple","cat","aa"));

        printAll(Arrays.asList(1,2,3,4));
        System.out.println(sum(Arrays.asList(1,2,3,4)));
        printAll(Arrays.asList(1.1,1.2,1.4));
        System.out.println(sum(Arrays.asList(1.1,1.2,1.4)));

        List<Animal> animalList=new ArrayList<>();
        List<Cat> catList=new ArrayList<>();
        List<RedCat> redCats=new ArrayList<>();
        List<Dog> dogs=new ArrayList<>();

        addCat(animalList);
        addCat(catList);
//        addCat(redCats);
//        addCat(dogs);



    }
}
