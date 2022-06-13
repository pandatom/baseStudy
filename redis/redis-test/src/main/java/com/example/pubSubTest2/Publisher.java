package com.example.pubSubTest2;

/**
 * @Description: TODO
 * @author: scott
 * @date: 2022年03月07日 11:39 AM
 */

import java.io.BufferedReader;
import java.io.InputStreamReader;

import redis.clients.jedis.Jedis;

/**
 *@author 作者 E-mail：ingo
 *@version 创建时间：2016年6月14日上午9:49:41
 *类说明
 */
public class Publisher {
    private Jedis publisherJedis;
    private String channel;

    public Publisher(Jedis publishJedis,String channel){
        this.publisherJedis=publishJedis;
        this.channel=channel;
    }
    public void startPublish(){
        try{
            BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
            while(true){
                System.out.println("请输入message:");
                String line = reader.readLine();
                if(!"quit".equals(line)){
                    publisherJedis.publish(channel, line);
                }else{
                    break;
                }
            }
        }catch(Exception e){
            e.printStackTrace();
        }
    }
}
