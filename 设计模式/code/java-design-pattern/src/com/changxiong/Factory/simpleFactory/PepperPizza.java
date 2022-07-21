package com.changxiong.Factory.simpleFactory;


/**
 * 优点是比较好理解，简单易操作。
 * 缺点是违反了设计模式的ocp原则，即对扩展开放(提供方)，对修改关闭(使用方)。即当我们给类增加新功能的时候，尽量不修改代码，
 * 或者尽可能少修改代码.
 * 比如我们这时要新增加一个Pizza的种类(Pepper披萨)，我们需要在使用方 OderPizza 中添加新的判断条件，违反开闭原则
 */
public class PepperPizza extends Pizza {
    @Override
    public void prepare() {
        System.out.println("给胡椒披萨准备原材料 ");
    }
}
