package com.soft1851.spring.orm.config;

import com.alibaba.druid.pool.DruidDataSource;
import com.soft1851.spring.orm.dao.ForumDao;
import com.soft1851.spring.orm.dao.impl.ForumDaoImpl;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.jdbc.core.JdbcTemplate;

/**
 * @author Zeng
 * @ClassName JDBCConfig
 * @Description TOOD
 * @Date 2020/3/19
 * @Version 1.0
 **/
@Configuration
@ComponentScan("com.soft1851.spring.orm")
public class JdbcConfig {

    @Bean
    public DruidDataSource dataSource() {
        DruidDataSource source = new DruidDataSource();
        source.setDriverClassName("com.mysql.jdbc.Driver");
        source.setUrl("jdbc:mysql://localhost:3306/bbs?useUnicode=true&characterEncoding=utf8&useSSL=false&autoReconnect=true");
        source.setUsername("root");
        source.setPassword("root");
        source.setInitialSize(8);
        return source;
    }

    @Bean
    public JdbcTemplate jdbcTemplate(DruidDataSource dataSource) {
        return new JdbcTemplate(dataSource);
    }

    @Bean
    public ForumDao forumDao(JdbcTemplate jdbcTemplate) {
        return new ForumDaoImpl(jdbcTemplate);
    }
}
