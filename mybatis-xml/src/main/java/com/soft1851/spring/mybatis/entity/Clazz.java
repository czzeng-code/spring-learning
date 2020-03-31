package com.soft1851.spring.mybatis.entity;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;

/**
 * @author Zeng
 * @ClassName Clazz
 * @Description TOOD
 * @Date 2020/3/31
 * @Version 1.0
 **/
@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class Clazz {
    private Integer clazzId;
    private String clazzName;
    private Integer teacherId;
    /**管理班级得老师*/
    private Teacher teacher;
    /**班级学生集合 */
    private List<Student> students;
}
