package com.soft1851.spring.ioc.dao;

import com.soft1851.spring.ioc.entity.Post;

import java.util.List;

/**
 * @author Zeng
 * @ClassName PostDao
 * @Description TOOD
 * @Date 2020/3/17
 * @Version 1.0
 **/
public interface PostDao {

    int insert(Post post);

    int[] batchInsert(List<Post> posts);

    int delete(int postId);

    int[] batchDelete(int[] postIds);

    Post get(int postId);

    Post getByKeyword(String key);

    int sumPost(int forumId);

}
