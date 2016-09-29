package com.zhou.zhoulib.gateway;

import android.util.Log;

/**
 * Created by dell on 2016/9/19.
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
public class DeviceDefenceResponse {
    private DeviceDefence1 deviceDefence1;

    public DeviceDefenceResponse(String deviceResponsestr) {
        if (deviceResponsestr != null && deviceResponsestr.length() > 38) {
            String body = deviceResponsestr.substring(10, deviceResponsestr.length() - 4);
            Log.e("deviceDefenceResponse", body);
            deviceDefence1 = new DeviceDefence1();
            deviceDefence1.setSerialId(body.substring(0, 8));
            deviceDefence1.setDeviceId(body.substring(8, 24));
            deviceDefence1.setEndPoint(body.substring(24, 26));
            deviceDefence1.setArmModel(body.substring(26, 28));
            deviceDefence1.setArmStartTimehour(body.substring(28, 30));
            deviceDefence1.setArmStartTimemin(body.substring(30, 32));
            deviceDefence1.setArmEndTimehour(body.substring(32, 34));
            deviceDefence1.setArmEndTimemin(body.substring(34, 36));
            deviceDefence1.setResult(body.substring(36, 38));
            setDeviceDefence1(deviceDefence1);
        }
    }
    public DeviceDefence1 getDeviceDefence1() {
        return deviceDefence1;
    }

    public void setDeviceDefence1(DeviceDefence1 deviceDefence1) {
        this.deviceDefence1 = deviceDefence1;
    }
}
