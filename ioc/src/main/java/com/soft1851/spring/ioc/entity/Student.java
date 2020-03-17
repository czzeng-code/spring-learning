package com.soft1851.spring.ioc.entity;

/**
 * @author Zeng
 * @ClassName Student
 * @Description TOOD
 * @Date 2020/3/12
 * @Version 1.0
 **/
public class Student {
    private String name;
    private Phone phone;

    public Student() {
    }

    public Student(String name, Phone phone) {
        this.name = name;
        this.phone = phone;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setPhone(Phone phone) {
        this.phone = phone;
    }

    @Override
    public String toString() {
        return "Student{" +
                "name='" + name + '\'' +
                ", phone=" + phone +
                '}';
    }
}
