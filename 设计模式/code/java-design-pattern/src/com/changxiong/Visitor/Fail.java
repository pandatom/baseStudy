package com.changxiong.Visitor;

public class Fail extends Action {

    @Override
    public void getResult(Person person) {
        System.out.println(person.gender + "给的评价该歌手失败 !");
    }

}

