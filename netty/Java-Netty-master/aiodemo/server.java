package com.netty.aiodemo;

import java.net.InetSocketAddress;
import java.nio.channels.AsynchronousChannelGroup;
import java.nio.channels.AsynchronousServerSocketChannel;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

public class server {
    //�̳߳�
    private ExecutorService executorService;
    //�߳���
    private AsynchronousChannelGroup threadGroup;
    //������ͨ��
    public AsynchronousServerSocketChannel assc;

    public server(int port){
        try {
            //����һ�������
            executorService = Executors.newCachedThreadPool();
            //�����߳���
            threadGroup = AsynchronousChannelGroup.withCachedThreadPool(executorService, 1);
            //����������ͨ��
            assc = AsynchronousServerSocketChannel.open(threadGroup);
            //���а�
            assc.bind(new InetSocketAddress(port));

            System.out.println("server start , port : " + port);
            //��������
            assc.accept(this, new serverHandler());
            //һֱ���� ���÷�����ֹͣ
            Thread.sleep(Integer.MAX_VALUE);

        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public static void main(String[] args) {
        server serve = new server(8765);
    }
}
