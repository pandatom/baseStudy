package com.changxiong.Constructor;

public class HighBuilding extends HouseBuilder {

    @Override
    public void buildBasic() {
        house.setBase("高楼的打地基100米");
    }

    @Override
    public void buildWalls() {
        house.setWall("高楼的砌墙20cm");
    }

    @Override
    public void roofed() {
        house.setRoofed("高楼的透明屋顶");
    }

}

