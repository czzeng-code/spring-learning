package com.soft1851.spring.web.util;

import com.gargoylesoftware.htmlunit.BrowserVersion;
import com.gargoylesoftware.htmlunit.NicelyResynchronizingAjaxController;
import com.gargoylesoftware.htmlunit.WebClient;
import com.gargoylesoftware.htmlunit.html.HtmlDivision;
import com.gargoylesoftware.htmlunit.html.HtmlPage;
import com.soft1851.spring.web.entity.Blog;
import com.soft1851.spring.web.entity.Topic;
import org.apache.http.HttpEntity;
import org.apache.http.client.methods.CloseableHttpResponse;
import org.apache.http.client.methods.HttpGet;
import org.apache.http.client.protocol.HttpClientContext;
import org.apache.http.impl.client.CloseableHttpClient;
import org.apache.http.impl.client.HttpClients;
import org.apache.http.util.EntityUtils;
import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.nodes.Element;
import org.jsoup.select.Elements;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

/**
 * @author Zeng
 * @ClassName cB
 * @Description TOOD
 * @Date 2020/3/29
 * @Version 1.0
 **/
public class BlogSpider {

    public static List<Blog> getBlog() throws Exception {
        List<Blog> blogList = new ArrayList<>();
        String url = "https://blog.csdn.net/nav/java";

        CloseableHttpClient httpClient = HttpClients.createDefault();
        HttpGet get = new HttpGet(url);
        HttpClientContext context = HttpClientContext.create();
        CloseableHttpResponse response = null;
        try {
            response = httpClient.execute(get, context);
        } catch (IOException e) {
            e.printStackTrace();
        }
        assert response != null;
        int statusCode = response.getStatusLine().getStatusCode();
        if (statusCode == 200) {
            HttpEntity entity = response.getEntity();
            if (entity != null) {
                String res = EntityUtils.toString(entity);
                Document document = Jsoup.parse(res);
                Elements elements = document.getElementsByClass("list_con");
                for (Element element : elements) {
                    String title = element.child(0).child(0).child(0).text();
                    String avatar = element.child(2).child(0).child(0).child(0).attr("src");
                    String userName = element.child(2).child(1).child(0).text();
                    Blog blog = Blog.builder().userName(userName)
                            .avatar(avatar)
                            .userName(userName)
                            .viewCount((int)(Math.random()*1000))
                            .zan((int)(Math.random()*1000))
                            .build();
                    blogList.add(blog);
                }

            }
        }
        return blogList;

    }

    public static void main(String[] args) throws Exception {
        BlogSpider.getBlog();
    }
}
