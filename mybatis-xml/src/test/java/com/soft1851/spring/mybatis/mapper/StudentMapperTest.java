package com.soft1851.spring.mybatis.mapper;

import com.soft1851.spring.mybatis.entity.MatterDto;
import com.soft1851.spring.mybatis.entity.Student;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import javax.annotation.Resource;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

import static org.junit.Assert.*;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(locations = {"/spring-mybatis.xml"})
public class StudentMapperTest {
    @Resource
    private StudentMapper studentMapper;

    @Test
    public void insert() {
        Student student = Student.builder()
                .clazzId(1)
                .studentName("测试学生0")
                .hometown("江苏南京")
                .birthday(LocalDate.of(2000, 10, 10))
                .build();
        studentMapper.insert(student);
        System.out.println(student.getStudentId());
    }

    @Test
    public void delete() {
        studentMapper.delete(2010);
    }

    @Test
    public void update() {
        Student student = studentMapper.getStudentById(4010);
        System.out.println(student);
        student.setStudentName("new name");
        student.setHometown("Shanghai");
        student.setBirthday(LocalDate.of(1999, 11, 11));
        studentMapper.update(student);
        System.out.println(studentMapper.getStudentById(2011));

    }

    @Test
    public void batchInsert() {
        List<Student> students = new ArrayList<>();
        for (int i = 0; i < 5; i++) {
            Student student = Student.builder()
                    .studentId(3000 + i)
                    .studentName("测试" + i)
                    .clazzId(1)
                    .hometown("测试城市")
                    .birthday(LocalDate.of(1999, 1, 1))
                    .build();
            students.add(student);
        }
        System.out.println(studentMapper.batchInsert(students));
    }

    @Test
    public void batchDelete() {
        List<Integer> idList = new ArrayList<>();
        for (int i = 0; i < 5; i++) {
            idList.add(3000 + i);
        }
        System.out.println(studentMapper.batchDelete(idList));
    }

    @Test
    public void selectLimit() {
        studentMapper.selectLimit().forEach(System.out::println);
    }

    @Test
    public void selectLimitByDynamicSql() {
        Student student = Student.builder()
//                .studentName("颜子皓")
                .hometown("江苏")
                .clazzId(2)
                .build();
        studentMapper.selectLimitByDynamicSql(student).forEach(System.out::println);
    }

    @Test
    public void selectAll() {
        List<Student> students = studentMapper.selectAll();
        students.forEach(student -> {
            System.out.println(student.getStudentId()
                    + "," + student.getStudentName()
                    + "," + student.getHometown()
                    + "," + student.getBirthday()
                    + "," + student.getClazz().getClazzName()
            );
        });
    }

    @Test
    public void batchUpdate() {
        List<Student> list = new ArrayList<>();
        for (int i = 1; i < 5; i++) {
            Student student = Student.builder()
                    .studentId(3000 + i)
                    .studentName("测试444-" +i)
                    .build();
            list.add(student);
        }
        System.out.println(studentMapper.batchUpdate(list));
    }
}