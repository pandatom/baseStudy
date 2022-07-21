package com.changxiong.Decorate;

// 装饰者
public class Decorator extends Drink {

    private Drink obj; // 聚合一个单品咖啡（被装饰者）

    public Decorator(Drink obj) {
        this.obj = obj;
    }

    @Override
    public float cost() {
        // super.getPrice：调味品（装饰者）的价格
        // obj.cost()：单品咖啡（被装饰者）的价格
        return super.getPrice() + obj.cost();
    }

    @Override
    public String getDes() {
        // des：调味品（装饰者）的描述信息
        // getPrice()：调味品（装饰者）的价格
        // obj.getDes()：单品咖啡（被装饰者）的信息
        return des + " " + getPrice() + " && " + obj.getDes();
    }

}

