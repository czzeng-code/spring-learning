package com.soft1851.spring.ioc.dao;

import com.soft1851.spring.ioc.entity.Post;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import java.sql.Timestamp;
import java.time.LocalDateTime;
import java.util.Arrays;
import java.util.Date;
import java.util.List;

import static org.junit.Assert.*;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(locations = {"/applicationContext.xml"})
public class PostDaoTest {

    @Autowired
    private PostDao postDao;

    @Test
    public void insert() {
        Post post = Post.builder().forumId(1)
                .title("帖子")
                .content("帖子内容")
                .createTime(Timestamp.valueOf(LocalDateTime.now()))
                .build();
        int n = postDao.insert(post);
        assertEquals(1, n);
    }

    @Test
    public void batchInsert() {
        Post[] posts = {Post.builder().forumId(1)
                .title("帖子0")
                .content("帖子内容0")
                .createTime(Timestamp.valueOf(LocalDateTime.now()))
                .build(),
                Post.builder().forumId(1)
                        .title("帖子1")
                        .content("帖子内容1")
                        .createTime(Timestamp.valueOf(LocalDateTime.now()))
                        .build(),
                Post.builder().forumId(1)
                        .title("帖子2")
                        .content("帖子内容2")
                        .createTime(Timestamp.valueOf(LocalDateTime.now()))
                        .build()
        };
        List<Post> postList = Arrays.asList(posts);
        int[] rows = postDao.batchInsert(postList);
        assertEquals(3, rows.length);
    }

    @Test
    public void delete() {
        int n = postDao.delete(1);
        assertEquals(1, n);
    }

    @Test
    public void batchDelete() {
        int[] num = {4, 5};
        int[] n = postDao.batchDelete(num);
        assertEquals(2, num.length);
    }

    @Test
    public void get() {

    }

    @Test
    public void getByKeyword() {
        String key = "帖子";
        Post byKeyword = postDao.getByKeyword(key);
    }
}