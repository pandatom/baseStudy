package com.example.pubSubTest2.plusdemo;

/**
 * @Description: TODO
 * @author: scott
 * @date: 2022年03月07日 11:48 AM
 */

import redis.clients.jedis.Jedis;
import redis.clients.jedis.JedisPubSub;

/**
 *@author 作者 E-mail：ingo
 *@version 创建时间：2016年6月16日上午9:01:45
 *类说明
 */
public class PPSubClient {
    private Jedis jedis;
    private JedisPubSub listener;
    private String CONSTANT_CLIENTSET="clientSet";
    public PPSubClient(String host,int port,String clientId){
        jedis = new Jedis(host,port);
        listener = new PPrintListener(clientId,new Jedis(host,port));
        jedis.sadd(CONSTANT_CLIENTSET, clientId);
    }
    public void sub(String channel){
        jedis.subscribe(listener, channel);
    }
    public void unsubscribe(String channel){
        listener.unsubscribe(channel);
    }
}
