package com.example.redistest;

import org.junit.Test;
import redis.clients.jedis.Jedis;

import java.util.*;

/**
 * @Description: TODO
 * @author: scott
 * @date: 2022年03月07日 10:06 AM
 */
public class apiTest {
        @Test
        public void test01() {
            Jedis jedis = new Jedis("127.0.0.1", 6379);
            //输出PONG，redis连通成功
            System.out.println(jedis.ping());
        }

    @Test
    public void test02() {
        Jedis jedis = new Jedis("127.0.0.1", 6379);
        // key
        Set<String> keys = jedis.keys("*");
        for (Iterator iterator = keys.iterator(); iterator.hasNext(); ) {
            String key = (String) iterator.next();
            System.out.println(key);
        }
        System.out.println("jedis.exists====>" + jedis.exists("k2"));
        System.out.println(jedis.ttl("k1"));

        // String
        System.out.println("-----------------String-----------------------");
        System.out.println(jedis.get("k1"));
        jedis.set("k4", "k4_redis");
        jedis.mset("str1", "v1", "str2", "v2", "str3", "v3");
        System.out.println(jedis.mget("str1", "str2", "str3"));

        // list
        System.out.println("-------------------list---------------------");
        jedis.lpush("mylist", "v1", "v2", "v3", "v4", "v5");
        List<String> list = jedis.lrange("mylist", 0, -1);
        for (String element : list) {
            System.out.println(element);
        }

        // set
        System.out.println("-------------------set---------------------");
        jedis.sadd("orders", "jd001");
        jedis.sadd("orders", "jd002");
        jedis.sadd("orders", "jd003");
        Set<String> set1 = jedis.smembers("orders");
        for (Iterator iterator = set1.iterator(); iterator.hasNext(); ) {
            String string = (String) iterator.next();
            System.out.println(string);
        }
        jedis.srem("orders", "jd002");
        System.out.println(jedis.smembers("orders").size());

        // hash
        System.out.println("-------------------hash---------------------");
        jedis.hset("hash1", "userName", "lisi");
        System.out.println(jedis.hget("hash1", "userName"));
        Map<String, String> map = new HashMap<String, String>();
        map.put("telphone", "13811814763");
        map.put("address", "atguigu");
        map.put("email", "abc@163.com");
        jedis.hmset("hash2", map);
        List<String> result = jedis.hmget("hash2", "telphone", "email");
        for (String element : result) {
            System.out.println(element);
        }

        // zset
        jedis.zadd("zset01", 60d, "v1");
        jedis.zadd("zset01", 70d, "v2");
        jedis.zadd("zset01", 80d, "v3");
        jedis.zadd("zset01", 90d, "v4");

        Set<String> s1 = jedis.zrange("zset01", 0, -1);
        for (Iterator iterator = s1.iterator(); iterator.hasNext(); ) {
            String string = (String) iterator.next();
            System.out.println(string);
        }

    }

    @Test
    public void test03() {


    }

    @Test
    public void test04() {

    }
}
