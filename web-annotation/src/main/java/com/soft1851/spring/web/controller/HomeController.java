package com.soft1851.spring.web.controller;

import com.soft1851.spring.web.entity.Article;
import com.soft1851.spring.web.entity.User;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

import java.util.Arrays;
import java.util.List;

/**
 * @author Zeng
 * @ClassName HomeController
 * @Description TOOD
 * @Date 2020/3/24
 * @Version 1.0
 **/
@Controller
public class HomeController {
    @GetMapping("/")
    public String home(Model model) {
        model.addAttribute("message", "Hello Spring MVC");
        User user = new User(1, "游人","https://upload.jianshu.io/users/upload_avatars/5796592/73837104-47e5-4fe9-a5be-054bd50b06f7.jpg?imageMogr2/auto-orient/strip|imageView2/1/w/180/h/180");
        Article[] articles = {
                new Article(1, "出自国人之手，不容忽视的Twitter第三方客户端", "前言前两天无意中看到又有一个新的Twitter第三方客户端正在测试，安装下来试玩了一下觉得不错，突然在思考，既然已经有Tweetbot或Twitterrific这么好的第三方客户端在前头，为什么还有那...", "https://cdn.sspai.com/2020/03/19/bf1518cc9cdc365af8a90ec8eda973c5.jpg?imageMogr2/quality/95/thumbnail/!1420x708r/gravity/Center/crop/1420x708/interlace/1"),
                new Article(2, "用 Substats 和 Shields.io 为你的个人主页定制动态数据小牌子", "如果你浏览过一些 GitHub 的开源项目，你一定见过很多 README 文档中都会出现的五颜六色、各式各样的「小牌子」。 经常出现在 GitHub 项目里面的小牌子￼最初，这些「小牌子」的主要作用...", "https://cdn.sspai.com/editor/u_spencerwoo/15846965973555.jpg?imageMogr2/quality/95/thumbnail/!1420x708r/gravity/Center/crop/1420x708/interlace/1"),
                new Article(3, "OverPicture：一款使所有网页视频支持画中画的 Safari 插件", "从 2016 年的 macOS Sierra 开始，Apple 就在 macOS 系统中加入了画中画（Picture-in-Picture）功能，使网页或播放器中的视频可以在系统中小窗播放，在不影响使...", "https://cdn.sspai.com/2020/03/19/08a2e0ccee41b05e76050b8291b483b3.jpg?imageMogr2/quality/95/thumbnail/!1420x708r/gravity/Center/crop/1420x708/interlace/1")
        };
        List<Article> articleList = Arrays.asList(articles);
        model.addAttribute("user", user);
        model.addAttribute("articleList", articleList);
        return "home";
    }
}
