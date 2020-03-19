package com.soft1851.spring.ioc.entity;

import com.soft1851.spring.ioc.config.AppConfig;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import static org.junit.Assert.*;

@RunWith(SpringJUnit4ClassRunner.class)
//使用配置文件
//@ContextConfiguration(locations = {"/beans.xml"})

//使用java注解配置类
@ContextConfiguration(classes = {AppConfig.class})
public class StudentTest {

    @Autowired
    private Student student;

    @Test
    public void test() {
        System.out.println(student);
    }
}