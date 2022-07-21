package com.changxiong.Factory.abstactFactory;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class OrderPizza {

    // 定义一个抽象方法，createPizza , 让各个工厂子类自己实现
    private abFactory abfactory;

    // 构造器
    public OrderPizza(abFactory factory) {
        Pizza pizza = null;
        String orderType; // 订购披萨的类型
        do {
            this.abfactory=factory;
            orderType = getType();
            pizza = abfactory.createPizza(orderType); // 抽象方法，由工厂子类完成
            // 输出pizza 制作过程
            pizza.prepare();
            pizza.bake();
            pizza.cut();
            pizza.box();
            System.out.println();
        } while (true);
    }

    // 写一个方法，可以获取客户希望订购的披萨种类
    private String getType() {
        try {
            BufferedReader strin = new BufferedReader(new InputStreamReader(System.in));
            System.out.println("input pizza 种类:");
            String str = strin.readLine();
            return str;
        } catch (IOException e) {
            e.printStackTrace();
            return "";
        }
    }

}

