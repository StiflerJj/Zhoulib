package com.zhou.zhoulib.gateway;

import android.util.Log;

/**
 * ce001e000b
 * 00090001
 * 00137a000001d1d4
 * 01
 * 0104
 * 00
 * 00
 * 00
 * 00
 * 00
 * 00
 * 00
 * 00
 * bace
 * Created by cetnavjj on 2016/3/23.
 */
public class GetDeviceInfoResponse {
    private DeviceInfo deviceInfo;

    public GetDeviceInfoResponse(String deviceResponsestr){
        if(deviceResponsestr!=null && deviceResponsestr.length()>50){
            String body = deviceResponsestr.substring(10,deviceResponsestr.length()-4);
            Log.e("deviceInfoStr",body);
            deviceInfo = new DeviceInfo();
            deviceInfo.setSerialId(body.substring(0, 8));
            deviceInfo.setDeviceId(body.substring(8, 24));
            deviceInfo.setEndPoint(body.substring(24, 26));
            deviceInfo.setShoraddr(body.substring(26, 30));
            deviceInfo.setProfileId(body.substring(30, 34));
            deviceInfo.setZclVersion(body.substring(34, 36));
            deviceInfo.setApplicationVersion(body.substring(36, 38));
            deviceInfo.setStackVersion(body.substring(38, 40));
            deviceInfo.setHwVersion(body.substring(40, 42));
            int manufacturenamelen = Integer.parseInt(body.substring(42, 44),16);
            deviceInfo.setManufacturernamelen(manufacturenamelen);
            if(manufacturenamelen>0)
                deviceInfo.setManufacturername(body.substring(44,44+manufacturenamelen*2));
            int modelidentifierlen = Integer.parseInt(body.substring(44+manufacturenamelen*2,46+manufacturenamelen*2),16);
            deviceInfo.setModelidentifierlen(modelidentifierlen);
            if(modelidentifierlen>0)
                deviceInfo.setModelidentifier(body.substring(46+manufacturenamelen*2,46+manufacturenamelen*2+modelidentifierlen*2));
            int datecodelen = Integer.parseInt(body.substring(46+manufacturenamelen*2+modelidentifierlen*2,48+manufacturenamelen*2+modelidentifierlen*2),16);
            deviceInfo.setDatecodelen(datecodelen);
            deviceInfo.setDatecode(body.substring(48 + manufacturenamelen*2 + modelidentifierlen*2, 48 + manufacturenamelen*2 + modelidentifierlen*2 + datecodelen*2));
            deviceInfo.setPowersource(body.substring(48+manufacturenamelen*2+modelidentifierlen*2+datecodelen*2,50+manufacturenamelen*2+modelidentifierlen*2+datecodelen*2));
            setDeviceInfo(deviceInfo);

        }

    }

    public DeviceInfo getDeviceInfo() {
        return deviceInfo;
    }

    public void setDeviceInfo(DeviceInfo deviceInfo) {
        this.deviceInfo = deviceInfo;
    }
}
