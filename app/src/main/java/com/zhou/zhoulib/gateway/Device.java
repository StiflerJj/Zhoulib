package com.zhou.zhoulib.gateway;

import java.io.Serializable;
import java.util.ArrayList;

/**
 * Created by cetnavjj on 2016/3/23.
 * 0009 插座(开关) 0402门磁 0403报警
 */
public class Device implements Serializable{
    private static final long serialVersionUID = 4151488301863586046L;
    private String deviceId;
    private int deviceNameLength;
    private String deviceName;
    private int deviceTypeIdCount;
    private ArrayList<DeviceTypeIdObj> deviceTypeIds;

    public String getDeviceId() {
        return deviceId;
    }

    public void setDeviceId(String deviceId) {
        this.deviceId = deviceId;
    }

    public int getDeviceNameLength() {
        return deviceNameLength;
    }

    public void setDeviceNameLength(int deviceNameLength) {
        this.deviceNameLength = deviceNameLength;
    }

    public String getDeviceName() {
        return deviceName;
    }

    public void setDeviceName(String deviceName) {
        this.deviceName = deviceName;
    }

    public ArrayList<DeviceTypeIdObj> getDeviceTypeIds() {
        return deviceTypeIds;
    }

    public void setDeviceTypeIds(ArrayList<DeviceTypeIdObj> deviceTypeIds) {
        this.deviceTypeIds = deviceTypeIds;
    }

    public int getDeviceTypeIdCount() {
        return deviceTypeIdCount;
    }

    public void setDeviceTypeIdCount(int deviceTypeIdCount) {
        this.deviceTypeIdCount = deviceTypeIdCount;
    }

    @Override
    public String toString() {
        return "Device{" +
                "deviceId='" + deviceId + '\'' +
                ", deviceNameLength=" + deviceNameLength +
                ", deviceName='" + deviceName + '\'' +
                ", deviceTypeIdCount=" + deviceTypeIdCount +
                ", deviceTypeIds=" + deviceTypeIds +
                '}';
    }
}
