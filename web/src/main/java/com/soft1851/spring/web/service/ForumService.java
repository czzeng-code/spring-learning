package com.soft1851.spring.web.service;

import com.soft1851.spring.web.entity.Forum;

import java.util.List;

/**
 * @author Zeng
 * @ClassName ForumService
 * @Description TOOD
 * @Date 2020/3/20
 * @Version 1.0
 **/
public interface ForumService {

    /**
     * 查询所有论坛
     * @return
     */
    List<Forum> selectAll();
}
