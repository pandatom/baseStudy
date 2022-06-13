package com.example.pubSubTest;

import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.data.redis.core.RedisTemplate;

/**
 * @Description: TODO
 * @author: scott
 * @date: 2022年03月07日 11:29 AM
 */
public class PubSubMain {

    RedisTemplate<String,Object> redisTemplate;

    public  void execute() {
        String channel = "pubsub:queue";
        redisTemplate.convertAndSend(channel, "from testData");
    }
    public static void main(String[] args) {
        ApplicationContext applicationContext   = new AnnotationConfigApplicationContext(AppConfig.class);
        PubSubMain pubSubMain = new PubSubMain();
        pubSubMain.redisTemplate = (RedisTemplate<String, Object>) applicationContext.getBean("redisTemplate");
        pubSubMain.execute();
    }
}
