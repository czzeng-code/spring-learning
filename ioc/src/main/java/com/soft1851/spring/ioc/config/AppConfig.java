package com.soft1851.spring.ioc.config;

import com.soft1851.spring.ioc.entity.Book;
import com.soft1851.spring.ioc.entity.Phone;
import com.soft1851.spring.ioc.entity.Student;
import com.soft1851.spring.ioc.sort.Sort;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import java.util.*;

/**
 * @author Zeng
 * @ClassName AppConfig
 * @Description TOOD
 * @Date 2020/3/17
 * @Version 1.0
 **/
@Configuration
public class AppConfig {
    @Bean
    public Book book() {
        return new Book();
    }

    @Bean
    public Phone phone() {
        return new Phone("iPhone11",8888.0);
    }

    @Bean
    public Phone phone2() {
        Phone phone = new Phone();
        phone.setBrand("iPhoneX");
        phone.setPrice(7788.0);
        return phone;
    }

    @Bean
    public Phone phone3() {
        Phone phone = new Phone();
        phone.setBrand("MI10");
        phone.setPrice(59990.0);
        return phone;
    }

    @Bean
    public Student student() {
        Student student = new Student();
//        List
        List<Phone> phones = new ArrayList<>();
        phones.add(phone());
        phones.add(phone());
        phones.add(phone3());
//        Set
        Set<String> hobbies = new HashSet<>();
        hobbies.add("编程");
        hobbies.add("打球");
        hobbies.add("看电影");
//      Map
        Map<String, Phone> phoneMap = new HashMap<>();
        phoneMap.put("phone1", phone());
        phoneMap.put("phone2", phone2());
        phoneMap.put("phone3", phone3());


        student.setName("王麻子");
        student.setPhones(phones);
        student.setHobbies(hobbies);
        student.setPhoneMap(phoneMap);
        return student;
    }

    @Bean
    public Sort sort() { return new Sort();}
}
