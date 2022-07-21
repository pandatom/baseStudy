package com.changxiong.Decorate;

public class Milk extends Decorator {
    public Milk(Drink obj) {
        super(obj);
        setDes(" еёдл ");
        setPrice(2.0f);
    }
}
