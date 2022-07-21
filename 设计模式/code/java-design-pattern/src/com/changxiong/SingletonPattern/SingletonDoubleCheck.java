package com.changxiong.SingletonPattern;

/**
 * 懒汉式（双重检查）的具体实现步骤
 *
 * 构造器私有化，外部不能 new
 * 在本类内部的 getInstance() 静态方法中，先判断对象是否为空
 * 如果为空，则先加锁，再判断此单例对象是否为空，如果还为空，才创建对象
 * 如果不为空，则直接返回此对象
 * 注意：单例变量需要使用 volatile 关键字进行修饰，保证内存可见性，以及防止指令重排序
 */
public class SingletonDoubleCheck {
    public static void main(String[] args) {
        System.out.println("双重检查");
        Singleton04 instance = Singleton04.getInstance();
        Singleton04 instance2 = Singleton04.getInstance();
        System.out.println(instance == instance2); // true
        System.out.println("instance.hashCode=" + instance.hashCode());
        System.out.println("instance2.hashCode=" + instance2.hashCode());
    }
}


// 懒汉式(线程安全，同步方法)
class Singleton04 {
    private static volatile Singleton04 instance;//volatile关键字主要是变量在多个线程间可见。

    private Singleton04() {
    }

    // 提供一个静态的公有方法，加入双重检查代码，解决线程安全问题, 同时解决懒加载问题
    // 同时保证了效率, 推荐使用
    public static synchronized Singleton04 getInstance() {
        if (instance == null) {
            synchronized (Singleton04.class) {
                if (instance == null) {
                    instance = new Singleton04();
                }
            }

        }
        return instance;
    }
}