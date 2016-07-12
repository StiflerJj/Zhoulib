package com.zhou.zhoulib.gateway;

import java.io.Serializable;

/**
 * Created by cetnavjj on 2016/3/23.
 */
public class DeviceTypeIdObj implements Serializable{

    private static final long serialVersionUID = -3600586447983758139L;
    private String endPoint;
    private String deviceTypeId;
    private String zoneType;

    public String getEndPoint() {
        return endPoint;
    }

    public void setEndPoint(String endPoint) {
        this.endPoint = endPoint;
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

    @Override
    public String toString() {
        return "DeviceTypeIdObj{" +
                "endPoint='" + endPoint + '\'' +
                ", deviceTypeId='" + deviceTypeId + '\'' +
                ", zoneType='" + zoneType + '\'' +
                '}';
    }
}
