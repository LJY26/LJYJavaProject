package com.ljy.JavaGenerics0009;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class TypeParametersTest {

    public static void main(String[] args){
        MyBox<Integer,String> box=new MyBox<Integer, String>();
        box.add(Integer.valueOf(99),"Hello");
        System.out.printf("Integer value :%d \n",box.getFirst());
        System.out.printf("String value: %s \n",box.getSecond());

        Pair<String,Integer> pair=new Pair<String, Integer>();
        pair.addKeyValue("1",Integer.valueOf(100));
        System.out.printf("(Pair) Integer value:%d \n",pair.getValue("1"));

        CustomeList<MyBox> customeList=new CustomeList<MyBox>();
        customeList.addItem(box);
        System.out.printf("(CustomList)Integer value: %d \n",customeList.getItem(0).getFirst());
    }


    private static class MyBox<T,S>{

        private T t;
        private S s;

        public void add(T t,S s){
            this.t=t;
            this.s=s;
        }

        public T getFirst(){
            return t;
        }

        public S getSecond(){
            return s;
        }
    }

    private static class Pair<K,V>{
        private Map<K,V> map=new HashMap<K, V>();

        public void addKeyValue(K key,V value){
            map.put(key,value);
        }

        public V getValue(K key){
            return map.get(key);
        }
    }

    private static class CustomeList<E>{
        private List<E> list=new ArrayList<E>();

        public void addItem(E e){
            list.add(e);
        }

        public E getItem(int index){
            return list.get(index);
        }
    }
}
