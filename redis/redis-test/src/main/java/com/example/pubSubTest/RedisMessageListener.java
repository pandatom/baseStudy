package com.example.pubSubTest;

import org.springframework.data.redis.connection.Message;
import org.springframework.data.redis.connection.MessageListener;

/**
 * @Description: TODO
 * @author: scott
 * @date: 2022年03月07日 11:28 AM
 */
public class RedisMessageListener implements MessageListener {
    @Override
    public void onMessage(final Message message, final byte[] pattern ) {
        System.out.println("Message received: " + message.toString() );
    }
}
