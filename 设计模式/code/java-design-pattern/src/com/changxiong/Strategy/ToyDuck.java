package com.changxiong.Strategy;

public class ToyDuck extends Duck {

    public ToyDuck() {
        flyBehavior = new NoFlyBehavior();
        quackBehavior = new NoQuackBehavior();
    }

    @Override
    public void display() {
        System.out.println("玩具鸭");
    }

    public void swim() {
        System.out.println("玩具鸭不会游泳~~");
    }

}

