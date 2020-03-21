package com.soft1851.spring.web.controller;

import com.alibaba.fastjson.JSON;
import com.soft1851.spring.web.service.ForumService;
import com.soft1851.spring.web.util.ResponseObject;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

/**
 * @author Zeng
 * @ClassName ForumController
 * @Description TOOD
 * @Date 2020/3/20
 * @Version 1.0
 **/
@RestController
@RequestMapping(value = "forum")
public class ForumController {
    @Autowired
    private ForumService forumService;

    @RequestMapping(value = "/list", produces = "application/json; charset=utf-8")
    public String getForums() {
        ResponseObject ro = new ResponseObject(1, "成功", forumService.selectAll());
        return JSON.toJSONString(ro);
    }

    @RequestMapping(value = "/{forumId}", produces = "application/json; charset=utf-8")
    public String getForumById(@PathVariable int forumId) {
        ResponseObject ro = new ResponseObject(1, "成功", forumService.selectById(forumId));
        return JSON.toJSONString(ro);
    }

    @RequestMapping(value = "", produces = "application/json; charset=utf-8")
    public String getForumsByKey(@RequestParam("keyword") String keyword) {
        ResponseObject ro = new ResponseObject(1, "成功", forumService.getByKeyWord(keyword));
        return JSON.toJSONString(ro);
    }
}
