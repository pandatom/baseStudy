package com.changxiong.Factory.simpleFactory;

//相当于一个客户端，发出订购
public class PizzaStore {

    public static void main(String[] args) {
        // 使用简单工厂模式
        new OrderPizza(new simpleFactory());
        System.out.println("~~退出程序~~");
    }

}

