package com.changxiong.Factory.simpleFactory;

import java.util.function.Consumer;

public abstract class Pizza {

    private String name;

    public abstract void prepare();


    // ºæ¿¾
    public void bake() {
        System.out.println(name + " baking;");
    }

    // ÇÐ¸î
    public void cut() {
        System.out.println(name + " cutting;");
    }

    //´ò°ü
    public void box() {
        System.out.println(name + " boxing;");
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }
}
