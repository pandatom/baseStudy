package com.example.pubSubTest;

import redis.clients.jedis.JedisPubSub;

/**
 * @Description: TODO
 * @author: scott
 * @date: 2022年03月07日 10:29 AM
 */
public class TestPubSub extends JedisPubSub {
    //监听到订阅频道接受到消息时的回调 (onMessage )
    @Override
    public void onMessage(String channel, String message) {
        // TODO Auto-generated method stub
        System.out.println(channel + "," + message);
    }

    //监听到订阅模式接受到消息时的回调 (onPMessage)
    @Override
    public void onPMessage(String pattern, String channel, String message) {
        // TODO Auto-generated method stub
        System.out.println(pattern + "," + channel + "," + message);

    }

    //订阅频道时的回调( onSubscribe )
    @Override
    public void onSubscribe(String channel, int subscribedChannels) {
        // TODO Auto-generated method stub
        System.out.println("onSubscribe: channel[" + channel + "]," + "subscribedChannels[" + subscribedChannels + "]");
    }

    // 取消订阅频道时的回调( onUnsubscribe )
    @Override
    public void onUnsubscribe(String channel, int subscribedChannels) {
        // TODO Auto-generated method stub
        System.out.println(
                "onUnsubscribe: channel[" + channel + "], " + "subscribedChannels[" + subscribedChannels + "]");
    }

    // 订阅频道模式时的回调 ( onPSubscribe )
    @Override
    public void onPUnsubscribe(String pattern, int subscribedChannels) {
        // TODO Auto-generated method stub
        System.out.println("onPUnsubscribe: pattern[" + pattern + "]," +

                "subscribedChannels[" + subscribedChannels + "]");

    }

    // 取消订阅模式时的回调( onPUnsubscribe )
    @Override
    public void onPSubscribe(String pattern, int subscribedChannels) {
        System.out.println("onPSubscribe: pattern[" + pattern + "], " +

                "subscribedChannels[" + subscribedChannels + "]");

    }
}
