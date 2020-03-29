package com.soft1851.spring.web.dao;

import com.soft1851.spring.web.config.JdbcConfig;
import com.soft1851.spring.web.entity.Blog;
import com.soft1851.spring.web.util.BlogSpider;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.test.context.web.WebAppConfiguration;

import javax.annotation.Resource;

import static org.junit.Assert.*;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(classes = {JdbcConfig.class})
@WebAppConfiguration("src/main/resources")
public class BlogDaoTest {

    @Resource
    private BlogDao blogDao;

    @Test
    public void selectAll() {
        blogDao.selectAll();
    }

    @Test
    public void batchInsert() throws Exception {
        blogDao.batchInsert(BlogSpider.getBlog());
    }
}