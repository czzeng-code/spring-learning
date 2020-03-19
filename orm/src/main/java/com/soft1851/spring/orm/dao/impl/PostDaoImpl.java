package com.soft1851.spring.orm.dao.impl;

import com.soft1851.spring.orm.dao.PostDao;
import com.soft1851.spring.orm.entity.Post;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.BatchPreparedStatementSetter;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.util.List;

/**
 * @author Zeng
 * @ClassName PostDaoImpl
 * @Description TOOD
 * @Date 2020/3/17
 * @Version 1.0
 **/
@Repository
public class PostDaoImpl implements PostDao {
    @Autowired
    private JdbcTemplate jdbcTemplate;

    @Override
    public int insert(Post post) {
        String sql = "INSERT INTO t_post VALUES (NULL,?,?,?,NULL,?) ";
        Object[] args = {post.getForumId(), post.getTitle(), post.getContent(), post.getCreateTime()};
        return jdbcTemplate.update(sql, args);
    }

    @Override
    public int[] batchInsert(List<Post> posts) {
        final List<Post> postList = posts;
        String sql = "INSERT INTO t_post VALUES (NULL,?,?,?,NULL,?) ";
        return jdbcTemplate.batchUpdate(sql, new BatchPreparedStatementSetter() {
            @Override
            public void setValues(PreparedStatement preparedStatement, int i) throws SQLException {
                preparedStatement.setInt(1, postList.get(i).getForumId());
                preparedStatement.setString(2, postList.get(i).getTitle());
                preparedStatement.setString(3, postList.get(i).getContent());
                preparedStatement.setTimestamp(4, postList.get(i).getCreateTime());
            }

            @Override
            public int getBatchSize() {
                return postList.size();
            }
        });
    }

    @Override
    public int delete(int postId) {
        String sql = "DELETE FROM t_post WHERE post_id = ? ";
        Object[] args = {postId};
        return jdbcTemplate.update(sql, args);
    }

    @Override
    public int[] batchDelete(int[] postIds) {
//        final List<Integer> postIdList = postIds;
        String sql = "DELETE FROM t_post WHERE post_id = ? ";
        return jdbcTemplate.batchUpdate(sql, new BatchPreparedStatementSetter() {
            @Override
            public void setValues(PreparedStatement preparedStatement, int i) throws SQLException {
                preparedStatement.setInt(1, postIds[i]);
            }

            @Override
            public int getBatchSize() {
                return postIds.length;
            }
        });

    }

    @Override
    public Post get(int postId) {
        String sql = "SELECT * FROM t_post WHERE post_id=? ";
        Object[] args = {postId};
        return jdbcTemplate.queryForObject(sql, args, new BeanPropertyRowMapper<>(Post.class));
    }

    @Override
    public List<Post> getByKeyword(String key) {
//        String sql = "select * from t_post where " +
//                "title like CONCAT('%', ?, '%') " +
//                "or content like CONCAT('%', ?, '%') ";
        String sql = "SELECT * FROM t_post WHERE " +
              "title LIKE '%" + key + "%' "  ;
        return jdbcTemplate.query(sql, new BeanPropertyRowMapper<>(Post.class));

    }

    @Override
    public  int sumPost(int forumId) {
        String sql = "SELECT COUNT(*) FROM t_post WHERE forum_id = " + forumId;
        return jdbcTemplate.queryForObject(sql, Integer.class);
    }
}
