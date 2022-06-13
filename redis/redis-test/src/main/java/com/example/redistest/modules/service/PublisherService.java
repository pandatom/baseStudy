package com.example.redistest.modules.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.redis.core.StringRedisTemplate;
import org.springframework.stereotype.Service;

/**
 * @Description: TODO
 * @author: scott
 * @date: 2022年03月09日 2:25 PM
 */
@Service
public class PublisherService {

    @Autowired
    private StringRedisTemplate redisTemplate;

    public String sendMessage(String name) {
        try {
            redisTemplate.convertAndSend("TOPIC_USERNAME", name);
            return "消息发送成功了";

        } catch (Exception e) {
            e.printStackTrace();
            return "消息发送失败了";
        }
    }
}