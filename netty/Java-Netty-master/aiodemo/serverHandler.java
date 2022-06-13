package com.netty.aiodemo;

import java.nio.ByteBuffer;
import java.nio.channels.AsynchronousSocketChannel;
import java.nio.channels.CompletionHandler;
import java.util.concurrent.ExecutionException;


public class serverHandler implements CompletionHandler<AsynchronousSocketChannel, server> {
    @Override
    public void completed(AsynchronousSocketChannel asc, server attachment) {
        //������һ���ͻ��˽����ʱ�� ֱ�ӵ���Server��accept��������������ִ����ȥ����֤����ͻ��˶���������
        attachment.assc.accept(attachment, this);
        read(asc);
    }

    private void read(final AsynchronousSocketChannel asc) {
        //��ȡ����
        ByteBuffer buf = ByteBuffer.allocate(1024);
        asc.read(buf, buf, new CompletionHandler<Integer, ByteBuffer>() {
            @Override
            public void completed(Integer resultSize, ByteBuffer attachment) {
                //���ж�ȡ֮��,���ñ�ʶλ
                attachment.flip();
                //��ö�ȡ���ֽ���
                System.out.println("Server -> " + "�յ��ͻ��˵����ݳ���Ϊ:" + resultSize);
                //��ȡ��ȡ������
                String resultData = new String(attachment.array()).trim();
                System.out.println("Server -> " + "�յ��ͻ��˵�������ϢΪ:" + resultData);
                String response = "��������Ӧ, �յ��˿ͻ��˷���������: " + resultData;
                write(asc, response);
            }
            @Override
            public void failed(Throwable exc, ByteBuffer attachment) {
                exc.printStackTrace();
            }
        });
    }

    private void write(AsynchronousSocketChannel asc, String response) {
        try {
            ByteBuffer buf = ByteBuffer.allocate(1024);
            buf.put(response.getBytes());
            buf.flip();
            asc.write(buf).get();
        } catch (InterruptedException e) {
            e.printStackTrace();
        } catch (ExecutionException e) {
            e.printStackTrace();
        }
    }

    public void failed(Throwable exc, server attachment) {
        exc.printStackTrace();
    }
}
