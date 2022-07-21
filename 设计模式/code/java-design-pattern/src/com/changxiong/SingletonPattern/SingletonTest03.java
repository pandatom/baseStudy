package com.changxiong.SingletonPattern;

/**
 * 懒汉式（线程不安全）的具体实现步骤
 *
 * 构造器私有化，外部不能 new
 * 在本类内部的 getInstance() 静态方法中，判断单例对象是否为空
 * 如果为空，则创建单例对象并返回
 * 如果不为空，则直接返回此对象
 */
public class SingletonTest03 {

    public static void main(String[] args) {
        System.out.println("懒汉式1 ， 线程不安全~");
        Singleton03 instance = Singleton03.getInstance();
        Singleton03 instance2 = Singleton03.getInstance();
        System.out.println(instance == instance2); // true
        System.out.println("instance.hashCode=" + instance.hashCode());
        System.out.println("instance2.hashCode=" + instance2.hashCode());
    }

}

class Singleton03 {
    private static Singleton03 instance;

    private Singleton03() {
    }

    // 提供一个静态的公有方法，当使用到该方法时，才去创建 instance
    // 即懒汉式
    public static Singleton03 getInstance() {
        if (instance == null) {
            instance = new Singleton03();
        }
        return instance;
    }
}


/*
// 懒汉式(线程安全，同步方法)
/**
懒汉式（同步方法）的优缺点说明

解决了线程安全问题
效率太低了， 每个线程在想获得类的实例时候， 执行 getInstance() 方法都要进行同步。
而其实这个方法只执行一次实例化代码就够了， 后面的想获得该类实例， 直接 return 就行了。 方法进行同步效率太低
结论： 在实际开发中， 不推荐使用这种方式
*/
/*
class Singleton {
    private static Singleton instance;

    private Singleton() {
    }

    // 提供一个静态的公有方法，加入同步处理的代码，解决线程安全问题
    // 即懒汉式
    public static synchronized Singleton getInstance() {
        if (instance == null) {
            instance = new Singleton();
        }
        return instance;
    }
}*/


//懒汉式（同步代码块）
/**
 * 懒汉式（同步代码块）的具体实现步骤
 *
 * 构造器私有化，外部不能 new
 * 在本类内部的 getInstance() 静态方法中，先判断对象是否为空
 * 如果为空，则加锁创建单例对象，并返回
 * 如果不为空，则直接返回此对象
 */
/*class Singleton{
    private static Singleton singleton;
    private Singleton(){
    }

    public static singleton getInstance(){
        if(singleton==null){
            synchronized(Singleton. class){
                singleton=new Singleton();
            }
        }
    }
    return singleton;
}*/
