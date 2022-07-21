package com.changxiong.ProtoType.deepCopy;

import java.io.*;

public class DeepProtoType implements Serializable,Cloneable {
    String id;
    DeepCloneableTarget deepCloneableTarget;

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public DeepCloneableTarget getDeepCloneableTarget() {
        return deepCloneableTarget;
    }

    public void setDeepCloneableTarget(DeepCloneableTarget deepCloneableTarget) {
        this.deepCloneableTarget = deepCloneableTarget;
    }

    public DeepProtoType() {
        super();
    }

    //1.方式一：重写clone方法

    @Override
    protected Object clone() throws CloneNotSupportedException {
        Object deep=null;
        // 这里完成对基本数据类型(属性)和String的克隆
        deep = super.clone();
        DeepProtoType deepProtoType= (DeepProtoType) deep;

        deepProtoType.deepCloneableTarget= (DeepCloneableTarget) deepCloneableTarget.clone();
        return deepProtoType;
    }

    //2.方式二： 通过对象序列化来实现
    public Object deepClone(){
        ByteArrayOutputStream bos=null;
        ObjectOutputStream oos=null;
        ByteArrayInputStream bin=null;
        ObjectInputStream oin=null;

        try {

            bos = new ByteArrayOutputStream();
            oos=new ObjectOutputStream(bos);
            oos.writeObject(this);

            bin=new ByteArrayInputStream(bos.toByteArray());
            oin = new ObjectInputStream(bin);
            DeepProtoType deepProtoType= (DeepProtoType) oin.readObject();



        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            // 关闭流
            try {
                bos.close();
                oos.close();
                bin.close();
                oin.close();
            } catch (Exception e2) {
                System.out.println(e2.getMessage());
            }
        }


        return null;
    }

}
