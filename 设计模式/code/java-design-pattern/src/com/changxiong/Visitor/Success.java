package com.changxiong.Visitor;

public class Success extends Action {

    @Override
    public void getResult(Person person) {
        System.out.println(person.gender + "给的评价该歌手很成功 !");
    }

}

