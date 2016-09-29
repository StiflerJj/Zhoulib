package com.zhou.zhoulib.gateway;

import java.util.ArrayList;

/**
 * Created by dell on 2016/9/8.
 */
public class DeviceShow {
    private String deviceId;
    private ArrayList<Device2> devices;
    private String deviceName;

    public String getDeviceId() {
        return deviceId;
    }

    public void setDeviceId(String deviceId) {
        this.deviceId = deviceId;
    }

    public ArrayList<Device2> getDevices() {
        return devices;
    }

    public void setDevices(ArrayList<Device2> devices) {
        this.devices = devices;
    }

    public String getDeviceName() {
        return deviceName;
    }

    public void setDeviceName(String deviceName) {
        this.deviceName = deviceName;
    }
}
