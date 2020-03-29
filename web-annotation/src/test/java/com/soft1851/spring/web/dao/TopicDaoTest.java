package com.soft1851.spring.web.dao;

import com.soft1851.spring.web.config.JdbcConfig;
import com.soft1851.spring.web.entity.Topic;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.test.context.web.WebAppConfiguration;

import javax.annotation.Resource;

import static org.junit.Assert.*;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(classes = {JdbcConfig.class})
@WebAppConfiguration("src/main/resources")  //webAppConfiguration注解类默认为webapp目录，需要切换到src/main/resources目录
public class TopicDaoTest {

    @Resource
    private TopicDao topicDao;

    @Test
    public void selectAll() {
        System.out.println(topicDao.selectAll());
    }

    @Test
    public void insert() {
        Topic topic = Topic.builder().id("12").topicName("sdsd").description("gu").followersCount(123).msgCount(666).topicIcon("add")
                .followed(false).build();

        assertEquals(1, topicDao.insert(topic));
    }
}