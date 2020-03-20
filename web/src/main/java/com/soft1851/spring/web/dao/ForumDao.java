package com.soft1851.spring.web.dao;

import com.soft1851.spring.web.entity.Forum;

import java.util.List;

/**
 * @author Zeng
 * @ClassName ForumDao
 * @Description TOOD
 * @Date 2020/3/17
 * @Version 1.0
 **/
public interface ForumDao {
    /**
     * 新增
     * @param forum
     * @return int
     */
    int insert(Forum forum);

    /**
     * 批量新增
     * @param forums
     * @return int[]
     */
    int[] batchInsert(List<Forum> forums);

    /**
     * 根据id删除Forum
     * @param forumId
     * @return int
     */
    int delete(int forumId);

    /**
     * 修改
     * @param forum
     * @return int
     */
    int update(Forum forum);

    /**
     * 根据id查Forum
     * @param forumId
     * @return Forum
     */
    Forum get(int forumId);

    /**
     * 查询所有论坛信息
     * @return List<Forum>
     */
    List<Forum> selectAll();
}
