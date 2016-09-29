package com.zhou.zhoulib.gateway;

import android.util.Log;


import com.zhou.zhoulib.util.Const;
import com.zhou.zhoulib.util.HexUtil;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by dkdh on 2016/4/18.
 * 添加 设备
 ce
 00 19
 00 05
 01
 00 13 7a 00 00 01 56 d3
 02
 01 00 00
 02 04 02 00 15
 2c
 ce
 -------
 标识位 1 byte "0xCE"
 消息长度 2 bytes 标识位(含)字节长度长度
 消息ID 2 bytes 0x00 0x05
 Action 1 bytes (1 add 0 del)
 DeviceID 8 bytes 设备ID ieee
 DeviceTypeIDCount 1 byte
 EndPoint 1 byte
 DeviceTypeID1(2bytes) [zonetype 2 bytes]
 ...

 校验码 (从开头到校验位前一位的^)
 标识位 1 byte
 -------
 */
public class NewDeviceJoin {
    private static final String TAG = "NewDeviceJoin";
    private Device2 device;
    private List<Device2> device2List;

    public Device2 getDevice() {
        return device;
    }

    public void setDevice(Device2 device) {
        this.device = device;
    }

    public List<Device2> getDevice2List() {
        return device2List;
    }

    public void setDevice2List(List<Device2> device2List) {
        this.device2List = device2List;
    }

    public NewDeviceJoin(String receiveData){
        if (receiveData!=null && receiveData.length()>=32){
            Log.e(TAG, receiveData);
            device2List = new ArrayList<Device2>();
            String deviceid = receiveData.substring(12, 28);
            int deviceNameLen = Integer.parseInt(receiveData.substring(28, 30),16);
            int deviceTypeIdIndex = 30;
            String deviceName = receiveData.substring(deviceTypeIdIndex,deviceTypeIdIndex+deviceNameLen*2);
            int devicetypeidcount = Integer.parseInt(receiveData.substring(deviceTypeIdIndex+deviceNameLen*2, 2+deviceTypeIdIndex+deviceNameLen*2),16);
            for (int i=0;i<devicetypeidcount;i++){
                device = new Device2();
                String endpoint = receiveData.substring(2+deviceTypeIdIndex+deviceNameLen*2,4+deviceTypeIdIndex+deviceNameLen*2);
                String devicetypeid = receiveData.substring(4+deviceTypeIdIndex+deviceNameLen*2, 8+deviceTypeIdIndex+deviceNameLen*2);
                String zonetype = "";
                if(devicetypeid.equals(Const.DefenceType)){
                    zonetype = receiveData.substring(8+deviceTypeIdIndex+deviceNameLen*2, 12+deviceTypeIdIndex+deviceNameLen*2);
                }

                device.setDeviceId(deviceid);
                device.setDeviceTypeId(devicetypeid);
                device.setEndpoint(endpoint);
                device.setZoneType(zonetype);
                device.setDeviceName(HexUtil.decodeText(deviceName));
                device.setDeviceNameLength(deviceNameLen);

                device2List.add(device);
            }
        }
    }
}
