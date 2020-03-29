package com.soft1851.spring.web.util;

import com.alibaba.fastjson.JSONArray;
import com.alibaba.fastjson.JSONObject;
import com.soft1851.spring.web.entity.Topic;
import org.apache.http.HttpEntity;
import org.apache.http.client.HttpClient;
import org.apache.http.client.methods.CloseableHttpResponse;
import org.apache.http.client.methods.HttpGet;
import org.apache.http.client.protocol.HttpClientContext;
import org.apache.http.impl.client.CloseableHttpClient;
import org.apache.http.impl.client.HttpClients;
import org.apache.http.util.EntityUtils;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

/**
 * @author Zeng
 * @ClassName JueJinSpider
 * @Description TOOD
 * @Date 2020/3/28
 * @Version 1.0
 **/
public class JueJinSpider {
    static final int SUCCESS = 200;

    public static List<Topic> getTopics() {
        List<Topic> topicList = new ArrayList<>();
        String url = "https://short-msg-ms.juejin.im/v1/topicList?uid=5e7f08bf6fb9a03c576c9b40&device_id=1585383615670&token=eyJhY2Nlc3NfdG9rZW4iOiJCemEySmxzcGFqTWpNeEh2IiwicmVmcmVzaF90b2tlbiI6Im5pbm1ZZkF6SnB5d3pxYlUiLCJ0b2tlbl90eXBlIjoibWFjIiwiZXhwaXJlX2luIjoyNTkyMDAwfQ%3D%3D&src=web&sortType=hot&page=0&pageSize=100";

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
        if (response.getStatusLine().getStatusCode() == SUCCESS) {
            HttpEntity entity = response.getEntity();
            String res = null;
            try {
                res = EntityUtils.toString(entity, "UTF-8");
            } catch (IOException e) {
                e.printStackTrace();
            }
            JSONObject jsonObject = JSONObject.parseObject(res);

            JSONArray list = jsonObject.getJSONObject("d").getJSONArray("list");

            list.forEach(item ->{
                JSONObject json = JSONObject.parseObject(item.toString());
                Topic topic = Topic.builder()
                        .id(json.getString("objectId"))
                        .topicName(json.getString("title"))
                        .topicIcon(json.getString("icon"))
                        .description(json.getString("description"))
                        .msgCount(json.getInteger("msgsCount"))
                        .followersCount(json.getInteger("followersCount"))
                        .followed(json.getBoolean("followed"))
                        .build();
                topicList.add(topic);
            });
        } else {
            System.out.println("请求失败" + response.getStatusLine());
        }
        try {
            response.close();
            httpClient.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
        return topicList;
    }

    public static void main(String[] args) {
        JueJinSpider.getTopics();
    }
}

