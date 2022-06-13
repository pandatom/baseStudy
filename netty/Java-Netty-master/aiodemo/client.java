package com.netty.aiodemo;

import java.io.UnsupportedEncodingException;
import java.net.InetSocketAddress;
import java.nio.ByteBuffer;
import java.nio.channels.AsynchronousSocketChannel;
import java.util.concurrent.ExecutionException;

public class client implements Runnable{

    private AsynchronousSocketChannel asc ;

    public client() throws Exception {
        asc = AsynchronousSocketChannel.open();
    }

    public void connect(){
        asc.connect(new InetSocketAddress("127.0.0.1", 8765));
    }

    public void write(String request){
        try {
            asc.write(ByteBuffer.wrap(request.getBytes())).get();
            read();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    private void read() {
        ByteBuffer buf = ByteBuffer.allocate(1024);
        try {
            asc.read(buf).get();
            buf.flip();
            byte[] respByte = new byte[buf.remaining()];
            buf.get(respByte);
            System.out.println(new String(respByte,"utf-8").trim());
        } catch (InterruptedException e) {
            e.printStackTrace();
        } catch (ExecutionException e) {
            e.printStackTrace();
        } catch (UnsupportedEncodingException e) {
            e.printStackTrace();
        }
    }

    @Override
    public void run() {
        while(true){

        }
    }

    public static void main(String[] args) throws Exception {
        client c1 = new client();
        c1.connect();

        client c2 = new client();
        c2.connect();

        client c3 = new client();
        c3.connect();

        new Thread(c1, "c1").start();
        new Thread(c2, "c2").start();
        new Thread(c3, "c3").start();

        Thread.sleep(1000);

        c1.write("c1 aaa");
        c2.write("c2 bbbb");
        c3.write("c3 ccccc");

        System.out.println("lllllssll");
    }

}
