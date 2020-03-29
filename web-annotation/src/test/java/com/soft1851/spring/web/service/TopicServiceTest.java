package com.soft1851.spring.web.service;

import com.soft1851.spring.web.config.JdbcConfig;
import com.soft1851.spring.web.entity.Topic;
import com.soft1851.spring.web.util.JueJinSpider;
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
public class TopicServiceTest {
    @Resource
    private TopicService topicService;

    @Test
    public void queryAll() {

    }

    @Test
    public void addTopic() {
        Topic topic = Topic.builder().id("192").topicName("sdsd").description("gu").followersCount(123).msgCount(666).topicIcon("www.icon.com")
                .followed(false).build();
        System.out.println(topic);
        topicService.addTopic(topic);

    }

    @Test
    public void batchAddTopic() {
        topicService.batchAddTopic(JueJinSpider.getTopics());
    }
}