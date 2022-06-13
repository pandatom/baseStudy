package com.example.pubSubSelfTest;

import redis.clients.jedis.Jedis;

/**
 * @Description: TODO
 * @author: scott
 * @date: 2022年03月08日 9:22 AM
 */
public class clientSub {
    public static void main(String[] args) {
        String channel="myChannel";
        Jedis jedis = new Jedis("127.0.0.1", 6379);
        //输出PONG，redis连通成功
        clientListener clientListener = new clientListener(new Jedis("127.0.0.1", 6379));
        jedis.subscribe(clientListener, channel);
    }
}
