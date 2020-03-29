package com.soft1851.spring.web.dao;

import com.soft1851.spring.web.entity.Blog;

import java.util.List;

/**
 * @author ZENG
 */
public interface BlogDao {

    List<Blog> selectAll();

    int[] batchInsert(List<Blog> blogs);
}
