package com.changxiong.Adapter;

//适配器类
public class VoltageAdapter extends Voltage220V implements IVoltage5V {
    @Override
    public int output5V() {
        int srcV = output220V(); // 获取到220V电压
        int dstV = srcV / 44; // 降压转成 5v
        return dstV;
    }
}

