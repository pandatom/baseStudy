package com.changxiong.Factory.MethodFactory;

public class PizzaStore {

    public static void main(String[] args) {
        String loc = "bj"; // 假设这里是用户输入的位置信息
        if (loc.equals("bj")) {
            // 创建北京口味的各种Pizza
            new BJOrderPizza();
        } else {
            // 创建伦敦口味的各种Pizza
            new LDOrderPizza();
        }
    }

}
