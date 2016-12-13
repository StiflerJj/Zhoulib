package com.zhou.zhoulib.gateway;

import java.io.Serializable;

/**
 * Created by dell on 2016/12/7.
 * 设备在离线状态改变通知：
 ce
 00 14
 00 20
 00 00 00 01
 00 13 7a 00 00 01 56 d3
 01
 bc
 ce
 -------
 标识位 1 byte "0xCE"
 消息长度 2 bytes 标识位(含)字节长度长度
 消息ID 2 bytes 0x00 0x20
 SerialNum 4 bytes 序列号
 DeviceID 8 bytes 设备ID(IEEE)
 在离线状态： 1 byte 1：在线， 0：离线
 校验码 (从开头到校验位前一位的^)
 标识位 1 byte
 -------
 */
public class OnlineChange implements Serializable {

    private static final long serialVersionUID = -6130576452500748231L;
    private String serialId;
    private String deviceId;
    private String online;

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

    public String getOnline() {
        return online;
    }

    public void setOnline(String online) {
        this.online = online;
    }

    @Override
    public String toString() {
        return "OnOffChange{"+"serialId='"+ serialId +'\''+
                ", deviceId='"+ deviceId +'\''+
                ", online='"+ online +'\''+
                '}';
    }
}
