package com.changxiong.Memento.demo1;

public class Client {

    public static void main(String[] args) {

        Originator originator = new Originator();
        Caretaker caretaker = new Caretaker();

        originator.setState(" 状态#1 攻击力 100 "); // 设置攻击速度
        caretaker.add(originator.saveStateMemento()); // 保存了当前的状态

        originator.setState(" 状态#2 攻击力 80 "); // 设置攻击速度
        caretaker.add(originator.saveStateMemento()); // 保存了当前的状态

        originator.setState(" 状态#3 攻击力 50 "); // 设置攻击速度
        caretaker.add(originator.saveStateMemento()); // 保存了当前的状态

        System.out.println("当前的状态是 =" + originator.getState());

        // 希望得到状态 1, 将 originator 恢复到状态1
        originator.getStateFromMemento(caretaker.get(0)); // 恢复对象属性
        System.out.println("恢复到状态1 , 当前的状态是");
        System.out.println("当前的状态是 =" + originator.getState());

    }

}

