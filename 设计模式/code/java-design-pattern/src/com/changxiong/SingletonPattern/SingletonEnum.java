package com.changxiong.SingletonPattern;

public class SingletonEnum {
    public static void main(String[] args) {
        Singleton6 instance = Singleton6.INSTANCE;
        Singleton6 instance2 = Singleton6.INSTANCE;
        System.out.println(instance == instance2);

        System.out.println(instance.hashCode());
        System.out.println(instance2.hashCode());

        instance.sayOK();


    }
}


//使用枚举，可以实现单例, 推荐
enum Singleton6 {
    INSTANCE; // 属性

    public void sayOK() {
        System.out.println("ok~");
    }
}