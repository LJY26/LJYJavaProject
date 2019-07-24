package com.ljy.Spring0011;

/**
 * @author ljy
 * @create 2019-07-23
 * @desc 用于Bean的属性注入
 */
public class PropertyValue {

    private final String name;
    private final Object value;

    public PropertyValue(String name, Object value) {
        this.name = name;
        this.value = value;
    }

    public String getName() {
        return name;
    }

    public Object getValue() {
        return value;
    }
}
