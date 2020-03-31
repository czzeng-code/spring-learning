package com.soft1851.spring.mybatis.mapper;

import com.soft1851.spring.mybatis.entity.Teacher;

/**
 * @author Zeng
 * @ClassName TeacherMapper
 * @Description TOOD
 * @Date 2020/3/31
 * @Version 1.0
 **/
public interface TeacherMapper {
    /**
     * 根据 teacher一对一关联查询其管理的班级信息
     * @param  teacherId teacherId
     * @return Teacher
     */
    Teacher getTeacherOneToOne(int teacherId);
}
