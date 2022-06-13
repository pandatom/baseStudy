package com.netty.socketdemo;

import java.nio.IntBuffer;

public class client {
    public static void main(String[] args) {
       // 1 ��������

        //����ָ�����ȵĻ�����
        IntBuffer buf = IntBuffer.allocate(10);
        buf.put(13);// positionλ�ã�0 - > 1
        buf.put(21);// positionλ�ã�1 - > 2
        buf.put(35);// positionλ�ã�2 - > 3

        //��λ�ø�λΪ0��Ҳ����positionλ�ã�3 - > 0
        buf.flip();
        System.out.println("ʹ��flip��λ��" + buf);
        System.out.println("����Ϊ: " + buf.capacity());	//����һ����ʼ��������ı䣨warp��������������⣩
        System.out.println("����Ϊ: " + buf.limit());		//����ֻװ��������Ԫ��,���Կɶ�ȡ���߲�����Ԫ��Ϊ3 ��limit=3


        System.out.println("��ȡ�±�Ϊ1��Ԫ�أ�" + buf.get(1));
        System.out.println("get(index)������positionλ�ò��ı䣺" + buf);
        buf.put(1, 4);
        System.out.println("put(index, change)������positionλ�ò��䣺" + buf);;

        for (int i = 0; i < buf.limit(); i++) {
            //����get������ʹ�仺����λ�ã�position��������һλ
            System.out.print(buf.get() + "\t");
        }
        System.out.println("buf�������֮��Ϊ: " + buf);


        // 2 wrap����ʹ��

         //  wrap���������һ������: һ�������÷������ȳ�ʼ���������ĳ��ȣ���Ϊû�����壬��󻹻ᱻwrap�����������鸲�ǵ���
         //  ����wrap�����޸Ļ����������ʱ�����鱾��Ҳ����ŷ����仯��
         int[] arr = new int[]{1,2,5};
         IntBuffer buf1 = IntBuffer.wrap(arr);
         System.out.println(buf1);

         IntBuffer buf2 = IntBuffer.wrap(arr, 0 , 2);
         //����ʹ�ñ�ʾ����Ϊ����arr�ĳ��ȣ����ǿɲ�����Ԫ��ֻ��ʵ�ʽ��뻺������Ԫ�س���
         System.out.println(buf2);




        // 3 ��������

         IntBuffer buff= IntBuffer.allocate(10);
         int[] arr1 = new int[]{1,2,5};
        buff.put(arr1);
         System.out.println(buff);
         //һ�ָ��Ʒ���
         IntBuffer buf3 = buff.duplicate();
         System.out.println(buf3);

         //����buf2��λ������
         //buf2.position(0);
        buff.flip();
         System.out.println(buff);

         System.out.println("�ɶ�����Ϊ��" + buff.remaining());

         int[] arr3 = new int[buff.remaining()];
         //�����������ݷ���arr2������ȥ
        buff.get(arr3);
         for(int i : arr3){
         System.out.print(Integer.toString(i) + ",");
         }

    }
}
