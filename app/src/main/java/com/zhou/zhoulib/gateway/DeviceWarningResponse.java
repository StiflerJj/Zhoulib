package com.zhou.zhoulib.gateway;

import android.util.Log;

/**
 * Created by dell on 2016/8/30.
 */
public class DeviceWarningResponse {

    private DeviceWarning1 deviceWarning1;

    public DeviceWarningResponse(String deviceResponsestr){
        if(deviceResponsestr!=null && deviceResponsestr.length()>30) {
            String body = deviceResponsestr.substring(10, deviceResponsestr.length() - 4);
            Log.e("deviceWarningResponse", body);
            deviceWarning1 = new DeviceWarning1();
            deviceWarning1.setSerialId(body.substring(0, 8));
            deviceWarning1.setDeviceId(body.substring(8, 24));
            deviceWarning1.setEndPoint(body.substring(24, 26));
            deviceWarning1.setCommandID(body.substring(26, 28));
            deviceWarning1.setResult(body.substring(28, 30));
            setDeviceWarning1(deviceWarning1);
        }
    }
    public DeviceWarning1 getDeviceWarning1() {
        return deviceWarning1;
    }

    public void setDeviceWarning1(DeviceWarning1 deviceWarning1) {
        this.deviceWarning1 = deviceWarning1;
    }
}
