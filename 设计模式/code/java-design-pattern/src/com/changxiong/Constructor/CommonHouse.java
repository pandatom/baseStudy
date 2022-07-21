package com.changxiong.Constructor;

public class CommonHouse extends HouseBuilder {

    @Override
    public void buildBasic() {
        house.setBase("普通房子打地基5米");
    }

    @Override
    public void buildWalls() {
        house.setWall("普通房子砌墙10cm");
    }

    @Override
    public void roofed() {
        house.setRoofed("普通房子屋顶");
    }

}

