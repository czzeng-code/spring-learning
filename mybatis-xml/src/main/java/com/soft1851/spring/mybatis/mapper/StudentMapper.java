package com.soft1851.spring.mybatis.mapper;

import com.soft1851.spring.mybatis.entity.MatterDto;
import com.soft1851.spring.mybatis.entity.MatterVo;
import com.soft1851.spring.mybatis.entity.Student;
import org.apache.ibatis.annotations.Param;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

/**
 * @author ZENG
 */
@Transactional(rollbackFor = Exception.class)
public interface StudentMapper {
    /**
     * 新增学生，返回自增主键
     * @param student student
     */
    void insert(Student student);

    /**
     * 根据id删除student
     * @param studentId studentId
     */
    void delete(int studentId);

    /**
     * 更新student
     * @param student student
     */
    void update(Student student);

    /**
     * 根据id查student
     * @param studentId studentId
     * @return Student
     */
    Student getStudentById(int studentId);

    /**
     * 批量插入
     * @param students students
     * @return int
     */
    int batchInsert(@Param("students") List<Student> students);

    /**
     * 批量删除
     * @param idList idList
     * @return int
     */
    int batchDelete(@Param("idList") List<Integer> idList);

    /**
     * 带两个指定条件  2班 江苏的同学
     * @return List
     */
    List<Student> selectLimit();

    /**
     * 单表指定条件查询（结合动态SQL)
     * @param student student
     * @return List
     */
    List<Student> selectLimitByDynamicSql(Student student);

    /**
     * 查询所有学生，按生日排序，多对一关联查询学生所在班级信息
     * @return List
     */
    List<Student> selectAll();

    /**
     * 批量修改
     * @param students students
     * @return int
     */
    int batchUpdate(@Param("students") List<Student> students);
}
