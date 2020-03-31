package com.soft1851.spring.mybatis.mapper;

import com.soft1851.spring.mybatis.entity.Clazz;
import com.soft1851.spring.mybatis.entity.ClazzVo;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.Map;

/**
 * @author Zeng
 * @ClassName ClazzMapper
 * @Description TOOD
 * @Date 2020/3/31
 * @Version 1.0
 **/
@Transactional(rollbackFor = Exception.class)
public interface ClazzMapper {
    /**
     * 获取班课中所有学生信息
     * @param clazzId int
     * @return ClazzVo
     */
    List<ClazzVo> getClazzStudent(int clazzId);

    /**
     * 获取指定班课得所有教师信息
     * @param id int
     * @return List
     */
    List<Map<String, Object>> getClazzStudent1(int id);

    /**
     * 根据C1azzId一对多关联查询本班所有学生
     * @param clazzId clazzId
     * @return Clazz
     */
    Clazz getClazzOneToMany(int clazzId);
}
