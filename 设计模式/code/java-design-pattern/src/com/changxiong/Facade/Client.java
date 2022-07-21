package com.changxiong.Facade;

public class Client {

    public static void main(String[] args) {
        // 这里直接调用。。。很麻烦，也不利于扩展

        // 使用外观模式
        HomeTheaterFacade homeTheaterFacade = new HomeTheaterFacade();
        homeTheaterFacade.ready();
        homeTheaterFacade.play();
        homeTheaterFacade.end();
    }

}

