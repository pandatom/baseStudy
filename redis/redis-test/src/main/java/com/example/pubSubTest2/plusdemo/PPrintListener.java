package com.example.pubSubTest2.plusdemo;

/**
 * @Description: TODO
 * @author: scott
 * @date: 2022年03月07日 11:48 AM
 */

import java.util.Date;

import redis.clients.jedis.Jedis;
import redis.clients.jedis.JedisPubSub;

/**
 * @author 作者 E-mail：ingo
 * @version 创建时间：2016年6月16日上午8:30:00 类说明
 */
public class PPrintListener extends JedisPubSub {

    private String clientId;
    private PSubHandler handler;
    private String CONSTANT = "clientSet";
    public PPrintListener(String clientId, Jedis jedis) {
        this.clientId = clientId;
        handler = new PSubHandler(jedis);
    }

    @Override
    public void onMessage(String channel, String message) {
        if (message.equalsIgnoreCase("quit")) {
            this.unsubscribe(channel);
        }
        handler.handle(channel, message);
        System.out.println("message receive:" + message + ",channel:" + channel);
    }

    private void message(String channel, String message) {
        Date time = new Date();
        System.out.println("message receive:" + message + ",channel:" + channel + time.toString());
    }

    @Override
    public void onPMessage(String pattern, String channel, String message) {
        System.out.println("message receive:" + message + ",pattern channel:" + channel);
    }

    @Override
    public void onSubscribe(String channel, int subscribedChannels) {
        handler.subscribe(channel);
        System.out.println("subscribe:" + channel + ",total channels:" + subscribedChannels);
    }

    @Override
    public void onUnsubscribe(String channel, int subscribedChannels) {
        handler.unsubscribe(channel);
        System.out.println("unsubscribe:" + channel + ",total channels:" + subscribedChannels);
    }

    @Override
    public void onPUnsubscribe(String s, int i) {

    }

    @Override
    public void onPSubscribe(String pattern, int subscribedChannels) {
        System.out.println("subscribe pattern:" + pattern + ",total channels:" + subscribedChannels);
    }

    @Override
    public void unsubscribe(String... channels) {
        super.unsubscribe(channels);
        for (String channel : channels) {
            handler.unsubscribe(channel);
        }
    }

    class PSubHandler {
        private Jedis jedis;

        PSubHandler(Jedis jedis) {
            this.jedis = jedis;
        }

        public void handle(String channel, String message) {
            int index = message.indexOf("/");
            if (index < 0) {
                return;
            }
            Long txid = Long.valueOf(message.substring(0, index));
            String key = clientId + "/" + channel;
            while (true) {
                String lm = jedis.lindex(key, 0);
                if (lm == null) {
                    break;
                }
                int li = lm.indexOf("/");
                if(li<0){
                    String result = jedis.lpop(key);
                    if(result == null){
                        break;
                    }
                    message(channel, lm);
                    continue;
                }
                Long lxid = Long.valueOf(lm.substring(0, li));
                if(txid>=lxid){
                    jedis.lpop(key);
                    message(channel,lm);
                    continue;
                }else{
                    break;
                }
            }
        }
        public void subscribe(String channel){
            String key = clientId+"/"+channel;
            boolean exist = jedis.sismember(CONSTANT, key);
            if(!exist){
                jedis.sadd(CONSTANT, key);
            }
        }
        public void unsubscribe(String channel){
            String key = clientId+"/"+channel;
            jedis.srem(CONSTANT, key);
            jedis.del(key);
        }
    }
}
