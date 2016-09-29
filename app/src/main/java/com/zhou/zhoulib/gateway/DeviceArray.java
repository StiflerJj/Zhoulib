package com.zhou.zhoulib.gateway;

import java.io.Serializable;
import java.util.ArrayList;

/**
 * Created by dell on 2016/9/9.
 */
public class DeviceArray implements Serializable{
    private static final long serialVersionUID = -8744906820421898390L;

    private ArrayList<Device2> devices;

    public ArrayList<Device2> getDevices() {
        return devices;
    }

    public void setDevices(ArrayList<Device2> devices) {
        this.devices = devices;
    }
}
