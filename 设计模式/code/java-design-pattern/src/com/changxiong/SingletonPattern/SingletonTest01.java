package com.changxiong.SingletonPattern;

public class SingletonTest01 {

    public static void main(String[] args) {
        // 测试
        Singleton instance = Singleton.getInstance();
        Singleton instance2 = Singleton.getInstance();
        System.out.println(instance == instance2); // true
        System.out.println("instance.hashCode=" + instance.hashCode());
        System.out.println("instance2.hashCode=" + instance2.hashCode());
    }

}

//饿汉式(静态变量)
class Singleton {

    // 1. 构造器私有化, 外部不能new
    private Singleton() {

    }

    // 2.本类内部创建对象实例
    //  静态变量被所有的对象所共享，在内存中只有一个副本，它当且仅当在类初次加载时会被初始化
    //对于一个final变量，如果是基本数据类型的变量，则其数值一旦在初始化之后便不能更改；如果是引用类型的变量，
       // 则在对其初始化之后便不能再让其指向另一个对象。
    private final static Singleton instance = new Singleton();

    // 3. 提供一个公有的静态方法，返回实例对象
    public static Singleton getInstance() {
        return instance;
    }

}
