package com.changxiong.SingletonPattern;

/**
 * 懒汉式（静态内部类）
 * 懒汉式（静态内部类）的具体实现步骤
 *
 * 构造器私有化，外部不能 new
 * 在本类内部新增一个静态内部类，封装一个单例对象，用于实现单例模式
 * 静态内部类的实现方式本质是利用类加载的同步机制，保证单例对象的线程安全，
 * 并且该方式能保证该单例对象的懒加载机制，因为只有用到静态内部类时，才会加载该静态内部类以及单例对象
 * 在本类内部提供一个静态方法 getInstance() 用于返回静态内部类中的单例对象
 */
public class SingletonStaticInterClass {
    public static void main(String[] args) {
        System.out.println("使用静态内部类完成单例模式");
        Singleton5 instance = Singleton5.getInstance();
        Singleton5 instance2 = Singleton5.getInstance();
        System.out.println(instance == instance2); // true
        System.out.println("instance.hashCode=" + instance.hashCode());
        System.out.println("instance2.hashCode=" + instance2.hashCode());
    }
}


// 静态内部类完成， 推荐使用
class Singleton5 {
    //构造器私有化
    private Singleton5() {}

    //写一个静态内部类,该类中有一个静态属性 Singleton

    /**
     * 内部类的特点:
     *
     * 在内部类中可以直接访问外部类的成员,包括私有的成员
     * 在外部类中不能直接访问内部类的成员,必须通过创建内部类的对象来调用内部类成员
     *
     * 静态内部类方式在Singleton类被装载时并不会立即实例化，而是在需要实例化时，调用getInstance()方法，
     * 才会装载SingletonInstance类，从而完成Singleton的实例化。
     * 类的静态属性只会在第一次加载类的时候初始化，所以在这里， JVM帮助我们保证了线程的安全性，在类进行初始化时，
     * 别的线程是无法进入的
     */
    private static class SingletonInstance {
        private static final Singleton5 INSTANCE = new Singleton5();
    }

    //提供一个静态的公有方法，直接返回SingletonInstance.INSTANCE
    public static Singleton5 getInstance() {
        return SingletonInstance.INSTANCE;
    }
}