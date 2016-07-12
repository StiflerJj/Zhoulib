package com.zhou.zhoulib;

import java.util.ArrayList;

/**
 * Created by zhangkai on 2016/2/1.
 */
public class Devices {
    private String Name;
    private ArrayList<Device> Devices;

    public void setName(String Name){
        this.Name = Name;
    }

    public String getName(){
        return this.Name;
    }

    public ArrayList<Device> getDevices(){
        return this.Devices;
    }

    public void  setDevices(ArrayList<Device> Devices){
        this.Devices = Devices;
    }
}
