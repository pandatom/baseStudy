package com.example.pubSubTest;

import redis.clients.jedis.Jedis;

/**
 * @Description: TODO
 * @author: scott
 * @date: 2022年03月07日 10:36 AM
 */
public class pubsubjava {
    public static void main(String[] args) {
        // TODO Auto-generated method stub
        Jedis jr = null;
        try {
            jr = new Jedis("127.0.0.1", 6379, 0);// redis服务地址和端口号
            jr.auth("wx950709");
            TestPubSub sp = new TestPubSub();
            // jr客户端配置监听两个channel
            sp.subscribe(jr.getClient().toString(), "news.share", "news.blog");
        } catch (Exception e) {
            e.printStackTrace();
        } finally{
            if(jr!=null){
                jr.disconnect();
            }
        }
    }
}
