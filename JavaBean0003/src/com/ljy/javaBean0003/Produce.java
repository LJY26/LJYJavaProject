package com.ljy.javaBean0003;

/**
 * 商品
 */
public class Produce {
    private String name="Java  Web 编程宝典";

    private double salePrice=698.5;

    private int count=400;

    private String factoryAdd="吉林省长春市明日科技有效公司";

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public double getSalePrice() {
        return salePrice;
    }

    public void setSalePrice(double salePrice) {
        this.salePrice = salePrice;
    }

    public int getCount() {
        return count;
    }

    public void setCount(int count) {
        this.count = count;
    }

    public String getFactoryAdd() {
        return factoryAdd;
    }

    public void setFactoryAdd(String factoryAdd) {
        this.factoryAdd = factoryAdd;
    }
}
