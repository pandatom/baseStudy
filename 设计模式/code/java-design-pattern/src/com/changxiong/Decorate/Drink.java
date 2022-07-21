package com.changxiong.Decorate;

public abstract class Drink {

    public String des; // 描述
    private float price = 0.0f; // 价格

    // 计算费用的抽象方法，由子类来实现
    public abstract float cost();

    public String getDes() {
        return des;
    }

    public void setDes(String des) {
        this.des = des;
    }

    public float getPrice() {
        return price;
    }

    public void setPrice(float price) {
        this.price = price;
    }

}

