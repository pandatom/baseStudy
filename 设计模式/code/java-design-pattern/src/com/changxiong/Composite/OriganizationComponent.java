package com.changxiong.Composite;

public abstract class OriganizationComponent {
    private String name;
    private String des;

    protected void add(OriganizationComponent origanizationComponent){
        throw new UnsupportedOperationException();
    }

    protected  void remove(OriganizationComponent origanizationComponent){
        throw new UnsupportedOperationException();
    }

    public OriganizationComponent(String name, String des) {
        this.name=name;
        this.des = des;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getDes() {
        return des;
    }

    public void setDes(String des) {
        this.des = des;
    }

    protected abstract void print();
}
