package com.example.pubSubTest2.plusdemo;

import java.util.Set;

import redis.clients.jedis.Jedis;

/**
 *@author 作者 E-mail：ingo
 *@version 创建时间：2016年6月16日上午8:55:21
 *类说明
 */
public class PPubClient {
    private Jedis jedis;
    private String CONSTANT_CLIENTSET = "clientSet";
    public PPubClient(String host,int port){
        jedis = new Jedis(host,port);
    }
    private void put(String message){
        Set<String> subClients = jedis.smembers(CONSTANT_CLIENTSET);
        for(String clientKey:subClients){
            jedis.rpush(clientKey, message);
        }
    }
    public void pub(String channel,String message){
        Long txid = jedis.incr("MAXID");
        String content = txid+"/"+message;
        this.put(content);
        jedis.publish(channel, message);
    }
    public void close(String channel){
        jedis.publish(channel, "quit");
        jedis.del(channel);
    }
}
