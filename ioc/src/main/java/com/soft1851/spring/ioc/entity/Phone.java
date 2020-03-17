package com.soft1851.spring.ioc.entity;

/**
 * @author Zeng
 * @ClassName Phone
 * @Description TOOD
 * @Date 2020/3/12
 * @Version 1.0
 **/
public class Phone {
    private String brand;
    private Double price;

    public Phone() {
    }

    public Phone(String brand, Double price) {
        this.brand = brand;
        this.price = price;
    }

    @Override
    public String toString() {
        return "Phone{" +
                "brand='" + brand + '\'' +
                ", price=" + price +
                '}';
    }
}
