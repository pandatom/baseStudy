package com.changxiong.Composite;

import java.util.ArrayList;
import java.util.List;

public class University extends OriganizationComponent{
    List<OriganizationComponent> list= new ArrayList<OriganizationComponent>();


    public University(String name, String des) {
        super(name, des);
    }

    @Override
    protected void add(OriganizationComponent origanizationComponent) {
        list.add(origanizationComponent);
    }

    @Override
    protected void remove(OriganizationComponent origanizationComponent) {
        list.remove(origanizationComponent);
    }

    @Override
    public String getName() {
        return super.getName();
    }

    @Override
    public String getDes() {
        return super.getDes();
    }

    @Override
    protected void print() {
        System.out.println("----" + getName() + "-----");

        for (OriganizationComponent origanizationComponent : list) {
            origanizationComponent.print();
        }
    }
}
