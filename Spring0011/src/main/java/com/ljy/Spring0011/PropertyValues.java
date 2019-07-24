package com.ljy.Spring0011;

import java.util.ArrayList;
import java.util.List;

/**
 * @author ljy
 * @create 2019-07-23
 * @desc 包装一个对象所有的 属性
 */
public class PropertyValues {

    private final List<PropertyValue> propertyValues=new ArrayList<>();

    public void addPropertyValue(PropertyValue pv){
        this.propertyValues.add(pv);
    }

    public List<PropertyValue> getPropertyValues() {
        return propertyValues;
    }
}
