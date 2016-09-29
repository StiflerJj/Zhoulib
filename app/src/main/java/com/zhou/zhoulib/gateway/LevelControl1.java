package com.zhou.zhoulib.gateway;

import java.io.Serializable;

/**
 * Created by dell on 2016/9/1.
 */
public class LevelControl1 implements Serializable {
    private static final long serialVersionUID = -1499033438087923161L;
    private String serialId;
    private String deviceId;
    private String endPoint;
    private String commandID;
    private String result;

    public String getSerialId() {
        return serialId;
    }

    public void setSerialId(String serialId) {
        this.serialId = serialId;
    }

    public String getDeviceId() {
        return deviceId;
    }

    public void setDeviceId(String deviceId) {
        this.deviceId = deviceId;
    }

    public String getEndPoint() {
        return endPoint;
    }

    public void setEndPoint(String endPoint) {
        this.endPoint = endPoint;
    }

    public String getCommandID() {
        return commandID;
    }

    public void setCommandID(String commandID) {
        this.commandID = commandID;
    }

    public String getResult() {
        return result;
    }

    public void setResult(String result) {
        this.result = result;
    }
    @Override
    public String toString() {
        return "LevelControl1{" +
                "serialId='" + serialId + '\'' +
                ", deviceId='" + deviceId + '\'' +
                ", endPoint='" + endPoint + '\'' +
                ", commandID='" + commandID + '\'' +
                ", result='" + result + '\'' +
                '}';
    }
}
