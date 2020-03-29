package com.soft1851.spring.web.service.impl;

import com.soft1851.spring.web.dao.BlogDao;
import com.soft1851.spring.web.entity.Blog;
import com.soft1851.spring.web.service.BlogService;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import javax.annotation.Resource;
import java.util.List;

/**
 * @author Zeng
 * @ClassName BlogServiceImpl
 * @Description TOOD
 * @Date 2020/3/29
 * @Version 1.0
 **/
@Service
@Transactional(rollbackFor = Exception.class)
public class BlogServiceImpl implements BlogService {
    @Resource
    private BlogDao blogDao;

    @Override
    public List<Blog> queryAll() {
        return blogDao.selectAll();
    }
}
