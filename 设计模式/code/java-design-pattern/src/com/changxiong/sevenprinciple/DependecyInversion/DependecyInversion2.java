package com.changxiong.sevenprinciple.DependecyInversion;

public class DependecyInversion2 {

    public static void main(String[] args) {
        // 客户端无需改变
        Person2 person = new Person2();
        person.receive(new Email2());
        person.receive(new WeiXin2());
    }

}

//定义接口
interface IReceiver {
    public String getInfo();
}

class Email2 implements IReceiver {
    public String getInfo() {
        return "电子邮件信息: hello,world";
    }
}

//增加微信
class WeiXin2 implements IReceiver {
    public String getInfo() {
        return "微信信息: hello,ok";
    }
}

//方式2
class Person2 {
    // 这里我们是对接口的依赖
    public void receive(IReceiver receiver) {
        System.out.println(receiver.getInfo());
    }
}


