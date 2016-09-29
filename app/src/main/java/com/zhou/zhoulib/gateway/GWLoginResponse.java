package com.zhou.zhoulib.gateway;

import android.util.Log;

import com.zhou.zhoulib.util.Const;
import com.zhou.zhoulib.util.HexUtil;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

/**
 * Created by cetnavjj on 2016/3/21.
 */
public class GWLoginResponse implements Serializable{
    private static final String TAG = "GWLoginResponse";
    private static final long serialVersionUID = 942522314804402970L;
    private String mac;
    private int nameLength;
    private String name;
    private String boxVersion,protocolVer;
    private int deviceCount;
    private ArrayList<Device> devices;

    private List<Device2> device2List;

    /**
     * ce00440001000c29a5264806e7bd91e585b301010003   设备前的串
     * 00137a000001d1d4  设备1 deviceid
     * 00                 设备名字的长度 为0则后边没有 为1 则长度为1*2
     * 01                设备devicetypeidcount
     * 01                设备endpoint
     * 0009              设备devicetypeid 如果此处为0402后边有zonetype
     * 00137a000002cb8e  设备2 deviceid
     * 00
     * 01
     * 01
     * 0200
     * 00137a00000156d3   设备3 deviceid
     * 00
     * 02
     * 01
     * 0000
     * 02
     * 0402
     * 0000              设备zonetype
     * dace
     * @param responseStr
     */
    public GWLoginResponse(String responseStr){
        if(responseStr!=null && responseStr.length()>32){
            Log.e("responseStr",responseStr);
            devices = new ArrayList<>();
            device2List = new ArrayList<Device2>();
            mac = responseStr.substring(10, 22);
            nameLength = Integer.parseInt(responseStr.substring(22, 24));
            int nameEnd = 23+nameLength*2+1;
            name = responseStr.substring(24, nameEnd);
            Log.e("name", HexUtil.decodeText(name));
            boxVersion = responseStr.substring(nameEnd, nameEnd + 2);
            protocolVer = responseStr.substring(nameEnd + 2, nameEnd + 4);
            int countEnd = nameEnd+8;
            deviceCount = Integer.parseInt(responseStr.substring(nameEnd+4,countEnd),16);
            String deviceListStr = responseStr.substring(countEnd,responseStr.length());
            Log.e("deviceListStr",deviceListStr);

            if(deviceCount>0){
                int deviceendIndex = 0;
                for(int i=0;i<deviceCount;i++){
                    if(deviceendIndex>deviceListStr.length()-4)
                        return;
                    String deviceId = deviceListStr.substring(deviceendIndex, deviceendIndex + 16);
                    deviceendIndex += 16;
                    int deviceNameLength = Integer.parseInt(deviceListStr.substring(deviceendIndex, deviceendIndex + 2), 16);
                    deviceendIndex += 2;
                    String deviceName = deviceListStr.substring(deviceendIndex,deviceendIndex+deviceNameLength*2);
                    Log.e("deviceName",deviceName);
                    deviceendIndex = deviceendIndex + deviceNameLength*2;
                    int deviceTypeIdCount = Integer.parseInt(deviceListStr.substring(deviceendIndex, deviceendIndex+2));
                    deviceendIndex += 2;

                    for (int j=0; j<deviceTypeIdCount;j++){
                        Device2 device2 = new Device2();
                        String endpoint = deviceListStr.substring(deviceendIndex, deviceendIndex+2);
                        deviceendIndex += 2;
                        String deviceTypeId = deviceListStr.substring(deviceendIndex, deviceendIndex+4);
                        deviceendIndex += 4;
                        String zoneType = "";
                        if(deviceTypeId.equals(Const.DefenceType)){
                            zoneType = deviceListStr.substring(deviceendIndex, deviceendIndex+4);
                            deviceendIndex += 4;
                        }
                        String status = "";
                        if(deviceTypeId.equals(Const.SwitchType)||deviceTypeId.equals(Const.ShadeControl)){
                            status = deviceListStr.substring(deviceendIndex, deviceendIndex+2);
                            deviceendIndex += 2;
                        }
                        device2.setDeviceNameLength(deviceNameLength);
                        String deviceName1= HexUtil.decodeText(deviceName);
                        Log.e("deviceName1",deviceName1);
                        device2.setDeviceName(deviceName1);
                        device2.setZoneType(zoneType);
                        device2.setStatus(status);
                        device2.setDeviceTypeId(deviceTypeId);
                        device2.setDeviceId(deviceId);
                        device2.setEndpoint(endpoint);
                        device2List.add(device2);
                        Log.e(TAG, "device "+j+device2.toString());
                    }

//                    Device device = new Device();
//
//                    device.setDeviceId(deviceListStr.substring(deviceendIndex,deviceendIndex+16));
//                    Log.e("setDeviceId", device.getDeviceId());
//                    deviceendIndex = deviceendIndex+16;
//                    device.setDeviceNameLength(Integer.parseInt(deviceListStr.substring(deviceendIndex, deviceendIndex+2)));
//                    deviceendIndex = deviceendIndex+2;
//                    device.setDeviceName(responseStr.substring(deviceendIndex, deviceendIndex+device.getDeviceNameLength()*2));
//                    deviceendIndex = deviceendIndex+device.getDeviceNameLength()*2;
//                    device.setDeviceTypeIdCount(Integer.parseInt(deviceListStr.substring(deviceendIndex, deviceendIndex + 2)));
//                    deviceendIndex = deviceendIndex+2;
//                    ArrayList<DeviceTypeIdObj> typeIdObjs = new ArrayList<>();
//                    for(int j=0;j<device.getDeviceTypeIdCount();j++){
//                        DeviceTypeIdObj deviceTypeIdObj = new DeviceTypeIdObj();
//                        deviceTypeIdObj.setEndPoint(deviceListStr.substring(deviceendIndex,deviceendIndex+2));
//                        deviceendIndex = deviceendIndex+2;
//                        if(deviceListStr!=null){
//                            String deviceTypeId = deviceListStr.substring(deviceendIndex,deviceendIndex+4);
//                            deviceendIndex = deviceendIndex+4;
//                            deviceTypeIdObj.setDeviceTypeId(deviceTypeId);
//                            if(deviceTypeId.equals(Const.DefenceType)){
//                                deviceTypeIdObj.setZoneType(deviceListStr.substring(deviceendIndex,deviceendIndex+4));
//                                deviceendIndex = deviceendIndex+4;
//                            }
//                        }
//                        typeIdObjs.add(deviceTypeIdObj);
//                    }
//                    device.setDeviceTypeIds(typeIdObjs);
//                    devices.add(device);
//                    Log.e("device"+i,device.toString());
                }
            }else{
                Log.e("LoginResponse","暂无设备");
            }

        }

    }


    public ArrayList<Device> getDevices() {
        return devices;
    }

    public String getProtocolVer() {
        return protocolVer;
    }

    public String getBoxVersion() {
        return boxVersion;
    }

    public String getName() {
        return name;
    }

    public String getMac() {
        return mac;
    }

    public int getNameLength() {
        return nameLength;
    }

    public int getDeviceCount() {
        return deviceCount;
    }

    public List<Device2> getDevice2List() {
        return device2List;
    }
}
