package com.zhou.zhoulib.gateway;

/**
 * Created by cetnavjj on 2016/3/22.
 */
public class SwitchCmdUtil {
    public static String LoginResponse = "0001";
    public static String HeartBeat = "0002";
    public static String DeviceInfo = "000b";


    public static String switchCmd(String cmdStr){
        String cmd = "";
        if(cmdStr!=null && cmdStr.length()>11){
            cmd = cmdStr.substring(6,10);
        }

        return cmd;
    }


}
