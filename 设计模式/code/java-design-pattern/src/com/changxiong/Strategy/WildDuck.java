package com.changxiong.Strategy;

public class WildDuck extends Duck {

    // 构造器，传入FlyBehavior 和 QuackBehavior 的对象
    public WildDuck() {
        flyBehavior = new GoodFlyBehavior();
        quackBehavior = new GeGeQuackBehavior();
    }

    @Override
    public void display() {
        System.out.println(" 这是野鸭 ");
    }

}

