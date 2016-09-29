package com.zhou.zhoulib.gateway;

import java.io.Serializable;

/**
 * * Created by dell on 2016/9/19.
 ** 设备布防/撤防 状态反馈
 ce
 00 1a
 00 0f
 00 00 00 01
 00 13 7a 00 00 01 56 d3
 01
 02
 01 02
 03 04
 01
 3d
 ce
 -------
 标识位 1 byte "0xCE"
 消息长度 2 bytes 标识位(含)字节长度长度
 消息ID 2 bytes 0x00 0x0F
 SerialNum 4 bytes 序列号
 DeviceID 8 bytes  设备ID
 EndPoint 1 byte
 ArmModel 1 byte 0 arm 1 disarm 2 armtime
 ArmStartTime 2 bytes eg. 22:00
 ArmEndTime 2 bytes eg. 6:00
 Result 1 byte 0 success 1 fail
 校验码 (从开头到校验位前一位的^)
 标识位 1 byte
 */
public class DeviceDefence1 implements Serializable {
    private static final long serialVersionUID = -1499033438087923161L;
    private String serialId;
    private String deviceId;
    private String endPoint;
    private String armModel;
    private String armStartTimehour;
    private String armStartTimemin;
    private String armEndTimehour;
    private String armEndTimemin;
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

    public String getArmModel() {
        return armModel;
    }

    public void setArmModel(String armModel) {
        this.armModel = armModel;
    }

    public String getArmStartTimehour() {return armStartTimehour;}

    public void setArmStartTimehour(String armStartTimehour) {this.armStartTimehour = armStartTimehour;}

    public String getArmStartTimemin() {return armStartTimemin;}

    public void setArmStartTimemin(String armStartTimemin) {this.armStartTimemin = armStartTimemin;}

    public String getArmEndTimehour() {return armEndTimehour;}

    public void setArmEndTimehour(String armEndTimehour) {this.armEndTimehour = armEndTimehour;}

    public String getArmEndTimemin() {return armEndTimemin;}

    public void setArmEndTimemin(String armEndTimemin) {this.armEndTimemin = armEndTimemin;}

    public String getResult() {
        return result;
    }

    public void setResult(String result) {
        this.result = result;
    }
    @Override
    public String toString() {
        return "DeviceDefence1{" +
                "serialId='" + serialId + '\'' +
                ", deviceId='" + deviceId + '\'' +
                ", endPoint='" + endPoint + '\'' +
                ", armModel='" + armModel + '\'' +
                ", armStartTimehour='" + armStartTimehour + '\'' +
                ", armStartTimemin='" + armStartTimemin + '\'' +
                ", armEndTimehour='" + armEndTimehour + '\'' +
                ", armEndTimemin='" + armEndTimemin + '\'' +
                ", result='" + result + '\'' +
                '}';
    }
}
