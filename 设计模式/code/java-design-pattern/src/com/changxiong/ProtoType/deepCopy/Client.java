package com.changxiong.ProtoType.deepCopy;

public class Client {

    public static void main(String[] args) throws Exception {
        DeepProtoType p = new DeepProtoType();
        p.setId("宋江");
        DeepCloneableTarget deepCloneableTarget = new DeepCloneableTarget("大牛", "小牛");
        p.setDeepCloneableTarget(deepCloneableTarget);

        // 方式1 完成深拷贝
        System.out.println("p.name=" + p.id + "；p.deepCloneableTarget.hashCode=" + p.deepCloneableTarget.hashCode());
        DeepProtoType p2 = (DeepProtoType) p.clone();
        System.out.println("p2.name=" + p2.id + "；p2.deepCloneableTarget.hashCode=" + p2.deepCloneableTarget.hashCode());

        // 方式2 完成深拷贝
//		DeepProtoType p2 = (DeepProtoType) p.deepClone();
//		System.out.println("p.name=" + p.name + "；p.deepCloneableTarget.hashCode=" + p.deepCloneableTarget.hashCode());
//		System.out.println("p2.name=" + p2.name + "；p2.deepCloneableTarget.hashCode=" + p2.deepCloneableTarget.hashCode());
    }

}

