package com.zhou.zhoulib.gateway;

import android.util.Log;

/**
 * Created by dell on 2016/8/30.
 */
public class DeviceOnOffResponse {

    private DeviceOnOff1 deviceOnOff1;

    public DeviceOnOffResponse(String deviceResponsestr){
        if(deviceResponsestr!=null && deviceResponsestr.length()>34) {
            String body = deviceResponsestr.substring(10, deviceResponsestr.length() - 4);
            Log.e("deviceOnOffResponse", body);
            deviceOnOff1 = new DeviceOnOff1();
            deviceOnOff1.setSerialId(body.substring(0, 8));
            deviceOnOff1.setDeviceId(body.substring(8, 24));
            deviceOnOff1.setEndPoint(body.substring(24, 26));
            deviceOnOff1.setStatus(body.substring(26, 28));
            deviceOnOff1.setResult(body.substring(28, 30));
            setDeviceOnOff1(deviceOnOff1);
        }
    }

    public DeviceOnOff1 getDeviceOnOff1() {
        return deviceOnOff1;
    }

    public void setDeviceOnOff1(DeviceOnOff1 deviceOnOff1) {
        this.deviceOnOff1 = deviceOnOff1;
    }
}
