package com.soft1851.spring.web.controller;

import com.alibaba.fastjson.JSONObject;
import com.soft1851.spring.web.service.BlogService;
import com.soft1851.spring.web.util.ResponseObject;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.annotation.Resource;

/**
 * @author Zeng
 * @ClassName BlogController
 * @Description TOOD
 * @Date 2020/3/29
 * @Version 1.0
 **/
@Controller
@RequestMapping(value = "/")
public class BlogController {
    @Resource
    private BlogService blogService;

    @GetMapping(value = "blogs", produces = "application/json; charset=utf-8")
    @ResponseBody
    public String getBlog() {
        ResponseObject rs = new ResponseObject(1, "success", blogService.queryAll());
        return JSONObject.toJSONString(rs);
    }


}
