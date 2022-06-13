package com.example.pubSubSelfTest;

import org.junit.Test;
import redis.clients.jedis.Jedis;

import java.util.List;

/**
 * @Description: TODO
 * @author: scott
 * @date: 2022年03月08日 9:22 AM
 */
public class servePub {
    public static void main(String[] args) {
        String channel="myChannel";
        Jedis jedis = new Jedis("127.0.0.1", 6379);
        //输出PONG，redis连通成功
//        System.out.println(jedis.ping());
        //发之前存到list
        String message = "3sss";
        jedis.lpush("msgList",message);
        jedis.publish(channel,message );
    }

    @Test
    public void test(){
        String channel="myChannel";
        Jedis jedis = new Jedis("127.0.0.1", 6379);
        jedis.lpush("mylist", "v1");
        List<String> list = jedis.lrange("mylist", 0, -1);
        for (String element : list) {
            System.out.println(element);
        }

        Long llen = jedis.llen("mylist");
        System.out.println(llen);

        String mylist = jedis.lindex("mylist", 0);
        System.out.println(mylist);

        String msg = jedis.lpop("mylist");
        System.out.println(msg);
    }
}
