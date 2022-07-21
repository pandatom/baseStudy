package com.changxiong.sevenprinciple.DependecyInversion;

    public class DependencySet {

        public static void main(String[] args) {
            // 通过setter方法进行依赖传递
            ITV2 changHong = new ChangHong2();
            OpenAndClose2 openAndClose2 = new OpenAndClose2();
            openAndClose2.setTv(changHong);
            openAndClose2.open();
        }

    }

    // 方式3 , 通过setter方法传递
    interface IOpenAndClose2 {
        public void open(); // 抽象方法
        public void setTv(ITV2 tv); // 通过 setter 方法注入
    }

    interface ITV2 { // ITV接口
        public void play();
    }

    // 长虹电视：实现 ITV 接口
    class ChangHong2 implements ITV2 {
        @Override
        public void play() {
            System.out.println("长虹电视机，打开");
        }
    }

    class OpenAndClose2 implements IOpenAndClose2 {
        private ITV2 tv;

        // 通过 setYv() 方法注入实现了 ITV 接口的对象实例
        public void setTv(ITV2 tv) {
            this.tv = tv;
        }

        public void open() {
            this.tv.play();
        }
    }


