package com.changxiong.sevenprinciple.Liskovprinciple;

public class Liskov2 {

    public static void main(String[] args) {

        A2 a = new A2();
        System.out.println("11-3=" + a.func1(11, 3));
        System.out.println("1-8=" + a.func1(1, 8));

        System.out.println("-----------------------");
        B2 b = new B2();

        // 因为B类不再继承A类，因此调用者，不会再func1是求减法
        // 调用完成的功能就会很明确
        System.out.println("11+3=" + b.func1(11, 3));// 这里本意是求出11+3
        System.out.println("1+8=" + b.func1(1, 8));// 这里本意是求出1+8
        System.out.println("11+3+9=" + b.func2(11, 3));

        // 使用组合仍然可以使用到A类相关方法
        System.out.println("11-3=" + b.func3(11, 3));// 这里本意是求出11-3

    }

}

//创建一个更加基础的基类
class Base {
    // 把更加基础的方法和成员写到Base类
}

// A类
class A2 extends Base {
    // 返回两个数的差
    public int func1(int num1, int num2) {
        return num1 - num2;
    }
}

// B类继承了A
// 增加了一个新功能：完成两个数相加,然后和9求和
class B2 extends Base {
    // 如果B需要使用A类的方法,使用组合关系
    private A a = new A();

    // 这里虽然方法名是 fun1()，但由于类 B 集成于类 Base，已和类 A 无关
    public int func1(int a, int b) {
        return a + b;
    }

    public int func2(int a, int b) {
        return func1(a, b) + 9;
    }

    // 我们仍然想使用A的方法
    public int func3(int a, int b) {
        return this.a.func1(a, b);
    }
}


