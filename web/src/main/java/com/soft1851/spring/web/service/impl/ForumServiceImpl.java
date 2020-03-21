package com.soft1851.spring.web.service.impl;

import com.soft1851.spring.web.dao.ForumDao;
import com.soft1851.spring.web.entity.Forum;
import com.soft1851.spring.web.service.ForumService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * @author Zeng
 * @ClassName ForumServiceImpl
 * @Description TOOD
 * @Date 2020/3/20
 * @Version 1.0
 **/
@Service
public class ForumServiceImpl implements ForumService {

    @Autowired
    private ForumDao forumDao;

    @Override
    public List<Forum> selectAll() {
        return forumDao.selectAll();
    }

    @Override
    public Forum selectById(int id) {
        return forumDao.get(id);
    }

    @Override
    public List<Forum> getByKeyWord(String key) {
        return forumDao.selectByKeyword(key);
    }
}
