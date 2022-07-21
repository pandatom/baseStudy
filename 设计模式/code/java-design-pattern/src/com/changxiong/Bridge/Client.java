package com.changxiong.Bridge;

public class Client {

    public static void main(String[] args) {

        // 折叠式的小米手机 (样式 + 品牌 )
        Phone phone1 = new FoldedPhone(new XiaoMi());
        phone1.open();
        phone1.call();
        phone1.close();
        System.out.println("=======================");

        // 折叠式的Vivo手机 (样式 + 品牌 )
        Phone phone2 = new FoldedPhone(new Vivo());
        phone2.open();
        phone2.call();
        phone2.close();
        System.out.println("==============");

        // 直立式的小米手机 (样式 + 品牌 )
        UpRightPhone phone3 = new UpRightPhone(new XiaoMi());
        phone3.open();
        phone3.call();
        phone3.close();
        System.out.println("==============");

        // 直立式的Vivo手机 (样式 + 品牌 )
        UpRightPhone phone4 = new UpRightPhone(new Vivo());
        phone4.open();
        phone4.call();
        phone4.close();

    }

}

