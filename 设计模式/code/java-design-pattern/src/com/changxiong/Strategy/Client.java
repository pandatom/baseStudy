package com.changxiong.Strategy;

/**
 * 策略模式： 分别封装行为接口， 实现算法族， 超类里放行为接口对象， 在子类里具体设定行为对象。
 * 原则就是：分离变化部分， 封装接口， 基于接口编程各种功能。 此模式让行为的变化独立于算法的使用者
 */
public class Client {

    public static void main(String[] args) {
        WildDuck wildDuck = new WildDuck();
        wildDuck.fly();

        ToyDuck toyDuck = new ToyDuck();
        toyDuck.fly();

        PekingDuck pekingDuck = new PekingDuck();
        pekingDuck.fly();

        // 动态改变某个对象的行为, 北京鸭 不能飞
        pekingDuck.setFlyBehavior(new NoFlyBehavior());
        System.out.println("北京鸭的实际飞翔能力");
        pekingDuck.fly();
    }

}

