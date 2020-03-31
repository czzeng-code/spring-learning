package com.soft1851.spring.mybatis.entity;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

/**
 * @author Zeng
 * @ClassName CourseStudent
 * @Description TOOD
 * @Date 2020/3/31
 * @Version 1.0
 **/
@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class CourseStudent {
    private Integer id;
    private Integer courseId;
    private Integer studentId;

}
