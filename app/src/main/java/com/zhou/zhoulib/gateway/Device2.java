package com.zhou.zhoulib.gateway;

import java.io.Serializable;

/**
 * Created by dkdh on 2016/4/19.
 */
public class Device2 implements Serializable{
    private static final String TAG = "Device2";
    private static final long serialVersionUID = 23525435L;
    private String deviceId;
    private String endpoint;
    private String deviceTypeId;
    private String zoneType;
    private String deviceName;
    private int deviceNameLength;
    private String Status;
    private boolean isCheck;

    public String getStatus() {return Status;}

    public void setStatus(String status) {this.Status = status;}

    public String getDeviceId() {
        return deviceId;
    }

    public void setDeviceId(String deviceId) {
        this.deviceId = deviceId;
    }

    public String getEndpoint() {
        return endpoint;
    }

    public void setEndpoint(String endpoint) {
        this.endpoint = endpoint;
    }

    public String getDeviceTypeId() {
        return deviceTypeId;
    }

    public void setDeviceTypeId(String deviceTypeId) {
        this.deviceTypeId = deviceTypeId;
    }

    public String getZoneType() {
        return zoneType;
    }

    public void setZoneType(String zoneType) {
        this.zoneType = zoneType;
    }

    public String getDeviceName() {
        return deviceName;
    }

    public void setDeviceName(String deviceName) {
        this.deviceName = deviceName;
    }

    public int getDeviceNameLength() {
        return deviceNameLength;
    }

    public void setDeviceNameLength(int deviceNameLength) {
        this.deviceNameLength = deviceNameLength;
    }

    public boolean isCheck() {
        return isCheck;
    }

    public void setCheck(boolean check) {
        isCheck = check;
    }

    public Device2() {
        this.setCheck(false);
    }

    @Override
    public String toString() {
        return "Device2{" +
                "deviceId='" + deviceId + '\'' +
                ", endpoint='" + endpoint + '\'' +
                ", deviceTypeId='" + deviceTypeId + '\'' +
                ", zoneType='" + zoneType + '\'' +
                ", status='" + Status + '\'' +
                ", deviceName='" + deviceName + '\''
                + ", deviceNameLength=" + deviceNameLength
                + '}';
    }
}
