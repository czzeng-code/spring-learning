package com.soft1851.spring.web.service;

import com.soft1851.spring.web.entity.Topic;

import java.util.List;

/**
 * @author ZENG
 */
public interface TopicService {
    /**
     * 查询all
     * @return List
     */
    List<Topic> queryAll();

    /**
     * 新增
     * @param topic topic
     */
    void addTopic(Topic topic);

    /**
     * 批量
     * @param topics
     */
    void batchAddTopic(List<Topic> topics);



}
