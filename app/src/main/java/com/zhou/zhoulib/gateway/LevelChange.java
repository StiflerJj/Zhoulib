package com.zhou.zhoulib.gateway;

import java.io.Serializable;

/**
 * Created by dell on 2016/9/19.
 * level状态改变通知：
 ce
 00 15
 00 18
 00 00 00 01
 00 13 7a 00 00 01 56 d3
 01
 00
 bc
 ce
 -------
 标识位 1 byte "0xCE"
 消息长度 2 bytes 标识位(含)字节长度长度
 消息ID 2 bytes 0x00 0x15
 SerialNum 4 bytes 序列号
 DeviceID 8 bytes 设备ID(IEEE)
 endpoint 1 byte
 设备状态： 1 byte 当前level值
 校验码 (从开头到校验位前一位的^)
 标识位 1 byte
 */
public class LevelChange implements Serializable {
    private static final long serialVersionUID = 3358091691922858775L;
    private String serialId;
    private String deviceId;
    private String endPoint;
    private String status;

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

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }
    @Override
    public String toString() {
        return "LevelChange{"+"serialId='"+ serialId +'\''+
                ", deviceId='"+ deviceId +'\''+
                ", endPoint='"+ endPoint +'\''+
                ", status='"+ status +'\''+
                '}';
    }
}
