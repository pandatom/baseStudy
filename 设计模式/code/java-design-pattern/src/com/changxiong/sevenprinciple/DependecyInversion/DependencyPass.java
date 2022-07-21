package com.changxiong.sevenprinciple.DependecyInversion;

public class DependencyPass {

    public static void main(String[] args) {
        // 通过构造器进行依赖传递
        ChangHong changHong = new ChangHong();
        OpenAndClose openAndClose = new OpenAndClose(changHong);
        openAndClose.open();
    }

}

// 方式2: 通过构造方法依赖传递
interface IOpenAndClose {
    public void open(); // 抽象方法
}

interface ITV { // ITV接口
    public void play();
}

// 长虹电视：实现 ITV 接口
class ChangHong implements ITV {
    @Override
    public void play() {
        System.out.println("长虹电视机，打开");
    }
}

class OpenAndClose implements IOpenAndClose {
    public ITV tv; // 成员变量

    public OpenAndClose(ITV tv) { // 通过构造器注入实现了 ITV 接口的对象
        this.tv = tv;
    }

    public void open() {
        this.tv.play();
    }
}


