package com.changxiong.Visitor;

public class Wait extends Action {

    @Override
    public void getResult(Person person) {
        System.out.println(person.gender + "给的评价是该歌手待定 ..");
    }

}

