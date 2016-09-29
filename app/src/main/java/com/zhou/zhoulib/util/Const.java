package com.zhou.zhoulib.util;

/**
 * Created by dkdh on 2016/4/19.
 */
public class Const {
    //device typeid
    public static String SwitchType = "0009";
    public static String ShadeControl="0200";
    public static String DefenceType = "0402";
    public static String WarningType = "0403";
    public static String DeviceOff = "00";
    public static String DeviceOn = "01";

    private static int serialId = 0;

    public static String getSerialId(){
        if(serialId<255){
            serialId++;
        }else {
            serialId = 0;
        }
        String s = String.format("%08d", serialId);
        return s;
    }

}
