package com.soft1851.spring.orm;

import com.soft1851.spring.orm.config.JdbcConfig;
import com.soft1851.spring.orm.dao.ForumDao;
import com.soft1851.spring.orm.entity.Forum;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

import java.util.List;

/**
 * @author Zeng
 * @ClassName App
 * @Description TOOD
 * @Date 2020/3/19
 * @Version 1.0
 **/
public class App {
    public static void main(String[] args) {
        AnnotationConfigApplicationContext ctx = new AnnotationConfigApplicationContext(JdbcConfig.class);
        ctx.scan("com.soft1851.spring.ioc.config");
        ForumDao forumDao = (ForumDao) ctx.getBean("forumDao");
        List<Forum> forumList = forumDao.selectAll();
        System.out.println(forumList);
    }
}
