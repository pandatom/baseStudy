package com.changxiong.Factory.simpleFactory;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class OrderPizza {

    private simpleFactory spFactory;
    Pizza pizza = null;

    public OrderPizza(simpleFactory  spFactory) {
        setFactory(spFactory);
    }

    public void setFactory(simpleFactory spFactory) {
        String orderType = ""; // 用户输入的
        this.spFactory = spFactory; // 设置简单工厂对象
        do {
            orderType = getType();
            pizza = this.spFactory.createfactory(orderType);
            // 输出pizza
            if (pizza != null) { // 订购成功
                pizza.prepare();
                pizza.bake();
                pizza.cut();
                pizza.box();
                System.out.println();
            } else {
                System.out.println("订购披萨失败");
                break;
            }
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
