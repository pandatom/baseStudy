package com.changxiong.ProtoType.deepCopy;

import java.io.Serializable;

public class DeepCloneableTarget implements Serializable,Cloneable {

    String name;
    String classname;

    public DeepCloneableTarget(String name, String classname) {
        this.name = name;
        this.classname = classname;
    }

    @Override
    protected Object clone() throws CloneNotSupportedException {
        return super.clone();
    }
}
