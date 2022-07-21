package com.changxiong.Visitor;

//说明
//1. 这里我们使用到了双分派, 即首先在客户端程序中，将具体状态作为参数传递Man中(第一次分派)
//2. 然后Man 类调用作为参数的 "具体方法" 中方法getResult, 同时将自己(this)作为参数传入，完成第二次的分派
public class Man extends Person {

    public Man() {
        gender = "男性";
    }

    @Override
    public void accept(Action action) {
        action.getResult(this);
    }

}

