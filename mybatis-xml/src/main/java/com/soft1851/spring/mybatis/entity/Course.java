package com.soft1851.spring.mybatis.entity;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;

/**
 * @author Zeng
 * @ClassName Course
 * @Description TOOD
 * @Date 2020/3/31
 * @Version 1.0
 **/
@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class Course {
    private Integer courseId;
    private String courseName;
    /** 课程学生列表*/
    private List<Student> students;
}
