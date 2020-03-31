package com.soft1851.spring.mybatis.mapper;

import com.soft1851.spring.mybatis.entity.MatterDto;
import com.soft1851.spring.mybatis.entity.MatterVo;

import java.util.List;

/**
 * @author Zeng
 * @ClassName MatterMapper
 * @Description TOOD
 * @Date 2020/3/31
 * @Version 1.0
 **/
public interface MatterMapper {
    /**
     * 查询某位老师的某个班级上面的某个学生
     * @param matterDto
     * @return
     */
    List<MatterVo> selectLimitFromTeacherInClassByDynamicSql(MatterDto matterDto);
}
