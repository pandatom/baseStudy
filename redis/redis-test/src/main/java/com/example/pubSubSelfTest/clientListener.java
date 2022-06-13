package com.example.pubSubSelfTest;

import redis.clients.jedis.Jedis;
import redis.clients.jedis.JedisPubSub;

import java.util.List;

/**
 * @Description: TODO
 * @author: scott
 * @date: 2022年03月08日 10:57 AM
 */
public class clientListener extends JedisPubSub {
    private PSubHandler handler;

    public clientListener(Jedis jedis){
        //在这里读取list里面的消息值，读取list全部的值
        List<String> list = jedis.lrange("msgList", 0, -1);
        for (String element : list) {
            System.out.println(element);
        }
        jedis.ltrim("msgList",1,0);
        handler = new PSubHandler(jedis);
    }
    @Override
    public void onMessage(String channel, String message) {
        //取出list最新数据，和message对比，一样删除list条记录，就执行next  ---》不一样不删除该条记录，就执行next
        String fmsg=handler.handle();
        if (fmsg.equals(message)){
            handler.pop();
            System.out.println(channel+"----"+message);
        }else{
            System.out.println(channel+"----"+message);
        }
    }

    @Override
    public void onPMessage(String s, String s1, String s2) {
        System.out.println(s+"----"+s1+"----"+s2);

    }

    @Override
    public void onSubscribe(String s, int i) {

    }

    @Override
    public void onUnsubscribe(String s, int i) {

    }

    @Override
    public void onPUnsubscribe(String s, int i) {

    }

    @Override
    public void onPSubscribe(String s, int i) {

    }

    class PSubHandler {
        private Jedis jedis;

        PSubHandler(Jedis jedis) {
            this.jedis = jedis;
        }

        public String handle() {
            String msg = jedis.lindex("msgList", 0);
            return msg;
        }

        public void pop() {
            String msg = jedis.lpop("msgList");
        }
    }


}
