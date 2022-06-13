package com.example.pubSubTest2.plusdemo;

/**
 * @Description: TODO
 * @author: scott
 * @date: 2022年03月07日 11:48 AM
 */
    /**
 * @author 作者 E-mail：ingo
 * @version 创建时间：2016年6月16日上午9:07:00 类说明
 */
public class PPubSubTestMain {
    public static void main(String[] args) throws Exception {
        String host = "127.0.0.1";
        int port = 6379;
        String clientId = "myclient";
        PPubClient pubClient = new PPubClient(host, port);
        final String channel = "mychannel";
        final PPSubClient subClient = new PPSubClient(host, port, clientId);
        Thread subThread = new Thread(new Runnable() {
            public void run() {
                System.out.println("------------sub----start------------");
                subClient.sub(channel);
                System.out.println("------------sub----end------------");
            }
        });
        subThread.setDaemon(true);
        subThread.start();

        int i = 0;
        while (i < 20) {
            String message = "message--" + i;
            pubClient.pub(channel, message);
            i++;
            Thread.sleep(100);
        }
        subClient.unsubscribe(channel);
    }
}