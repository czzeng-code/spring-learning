package com.soft1851.spring.web.dao;

import com.soft1851.spring.web.entity.Topic;

import java.util.List;

/**
 * @author Zeng
 * @ClassName TopicDao
 * @Description TOOD
 * @Date 2020/3/26
 * @Version 1.0
 **/
public interface TopicDao {
    /**
     * all
     * @return List
     */
    List<Topic> selectAll();

    /**
     * 批量插入
     * @param topics topics
     * @return int[]
     */
    int[] batchInsert(List<Topic> topics);

    /**
     * 新增
     * @param topic topic
     * @return int
     */
    int insert(Topic topic);
}
