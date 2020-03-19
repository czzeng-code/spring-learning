package com.soft1851.spring.ioc.sort;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

/**
 * @author Zeng
 * @ClassName SortTest
 * @Description 排序测试类
 * @Date 2020/3/10
 * @Version 1.0
 **/
public class SortTest {
    public static void main(String[] args) {
        ApplicationContext ac = new ClassPathXmlApplicationContext("beans.xml");
        Sort sort = (Sort) ac.getBean("sort");
        sort.sort();
    }
}
