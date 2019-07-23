package com.ljy.Java80010;

@FunctionalInterface
public interface CustomerF<T,R> {

    R apply(T t);
}
