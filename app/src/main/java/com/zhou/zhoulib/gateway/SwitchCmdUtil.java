package com.zhou.zhoulib.gateway;

/**
 * Created by cetnavjj on 2016/3/22.
 */
public class SwitchCmdUtil {
    public static String LoginResponse = "0001";
    public static String HeartBeat = "0002";
    public static String DeviceInfo = "000b";
    public static String DeviceOnOff = "0010";
    public static String DeviceDefence = "000f";
    public static String Warning = "0006";
    public static String APPWarning = "000d";
    public static String DeviceAddDel = "0005";
    public static String DeviceDelResponse = "000a";
    public static String LevelControl = "0011";

    public static String DeviceDelFromApp = "800a"; //删除设备
    public static String DeviceCallFromApp = "800c"; //设备点名
    public static String DeviceWarnFromApp = "800d"; //设备报警
    public static String DeviceDefenseFromApp = "800f"; //设备布防/撤防
    public static String DeviceOnOffFromApp = "8010"; //设备开关
    public static String DeviceNameChangeFromApp = "8008"; //设备改名



    public static String switchCmd(String cmdStr){
        String cmd = "";
        if(cmdStr!=null && cmdStr.length()>11){
            cmd = cmdStr.substring(6,10);
        }
        return cmd;
    }
}
