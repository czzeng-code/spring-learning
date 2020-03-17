package com.soft1851.spring.ioc;

import com.soft1851.spring.ioc.entity.Student;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import org.springframework.test.context.ContextConfiguration;

import java.sql.SQLOutput;

/**
 * @author Zeng
 * @ClassName StudentTest
 * @Description TOOD
 * @Date 2020/3/17
 * @Version 1.0
 **/
public class StudentTest {

    private static Logger logger = LoggerFactory.getLogger(Student.class);

    public static void main(String[] args) {
        ApplicationContext ac = new ClassPathXmlApplicationContext("beans.xml");
        Student student2 = (Student) ac.getBean("student2");
        try {
            System.out.println(student2);
            logger.info("输出成功");
        } catch (Exception e) {
           logger.error(e.getMessage());
        }

    }
}
