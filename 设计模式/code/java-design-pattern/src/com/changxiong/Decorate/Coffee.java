package com.changxiong.Decorate;

//±»×°ÊÎÕß
public abstract class Coffee extends Drink {
    @Override
    public float cost() {
        return super.getPrice();
    }
}

