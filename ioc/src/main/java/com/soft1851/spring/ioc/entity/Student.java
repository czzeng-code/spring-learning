package com.soft1851.spring.ioc.entity;

import lombok.Data;

import java.util.List;
import java.util.Map;
import java.util.Set;

/**
 * @author Zeng
 * @ClassName Student
 * @Description TOOD
 * @Date 2020/3/12
 * @Version 1.0
 **/
@Data
public class Student {
    private String name;
    private Phone phone;
    private List<Phone> phones;
    private Set<String> hobbies;
    private Map<String, Phone> phoneMap;

    public Student() {
    }

    public Student(String name, Phone phone) {
        this.name = name;
        this.phone = phone;
    }

    @Override
    public String toString() {
        return "Student{" +
                "name='" + name + '\'' +
                ", phones=" + phones +
                ", habbies=" + hobbies +
                ", phoneMap=" + phoneMap +
                '}';
    }
}
