package com.changxiong.Visitor;

public abstract class Person {

    String gender;

    // 提供一个方法，让访问者可以访问
    public abstract void accept(Action action);

}

