package com.changxiong.Constructor;

public class Client {
    public static void main(String[] args) {
        // 盖普通房子
        CommonHouse commonHouse = new CommonHouse();
        // 准备创建房子的指挥者
        HouseDirector houseDirector = new HouseDirector(commonHouse);
        // 完成盖房子，返回产品(普通房子)
        House house = houseDirector.constructHouse();
        // 查看建造的普通房子
        System.out.println(house.getBase());

        System.out.println("--------------------------");
        // 盖高楼
        HighBuilding highBuilding = new HighBuilding();
        // 重置建造者
        houseDirector.setHouseBuilder(highBuilding);
        // 完成盖房子，返回产品(高楼)
        house = houseDirector.constructHouse();
        // 查看建造的高楼
        System.out.println(house.getBase());
    }
}

