package com.soft1851.spring.web.dao.impl;

import com.soft1851.spring.web.dao.BlogDao;
import com.soft1851.spring.web.entity.Blog;
import com.soft1851.spring.web.entity.Topic;
import org.springframework.jdbc.core.BatchPreparedStatementSetter;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

import javax.annotation.Resource;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.util.List;

/**
 * @author Zeng
 * @ClassName BlogDaoImpl
 * @Description TOOD
 * @Date 2020/3/29
 * @Version 1.0
 **/
@Repository
public class BlogDaoImpl implements BlogDao {

    @Resource
    private JdbcTemplate jdbcTemplate;

    @Override
    public List<Blog> selectAll() {
        String sql = "SELECT * FROM t_blog";
        return jdbcTemplate.query(sql, new BeanPropertyRowMapper<>(Blog.class));

    }

    @Override
    public int[] batchInsert(List<Blog> blogs) {
        final List<Blog> blogList = blogs;
        String sql = "INSERT INTO t_blog (user_name, avatar, zan, view_count) VALUES (?,?,?,?)";

        return jdbcTemplate.batchUpdate(sql, new BatchPreparedStatementSetter() {
            @Override
            public void setValues(PreparedStatement preparedStatement, int i) throws SQLException {
                Blog blog = blogList.get(i);
                preparedStatement.setString(1, blog.getUserName());
                preparedStatement.setString(2, blog.getAvatar());
                preparedStatement.setInt(3, blog.getZan());
                preparedStatement.setInt(4, blog.getViewCount());
            }

            @Override
            public int getBatchSize() {
                return blogList.size();
            }
        });
    }
}
