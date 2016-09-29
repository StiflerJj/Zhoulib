package com.zhou.zhoulib.gateway;

/**
 * Created by dkdh on 2016/4/5.
 *  报警(目前仅针对门磁)
 ce
 00 1e
 00 06
 00 13 7a 00 00 01 56 d3
 00 00 00 00 56 eb 96 29
 02
 04 02
 00 15
 01
 00
 29
 ce
 -------
 标识位 1 byte "0xCE"
 消息长度 2 bytes 标识位(含)字节长度
 消息ID 2 bytes 0x00 0x06
 DeviceID 8 bytes 设备ID(IEEE)
 WarnTime 8 bytes // the number of seconds elapsed since January 1, 1970 UTC.
 EndPoint 1 byte
 DeviceTypeID 2 bytes  // must be 0402 for now  ---目前针对安防门窗磁
 zonetype 2bytes
// Alarm1 1 byte
// Alarm2 1 byte
 校验码 (从开头到校验位前一位的^)
 标识位 1 byte
 */
public class Alarm {
    private String deviceId;
    private String warnTime;
    private String endpoint;
    private String deviceTypeId;
    private String zoneType;
    // private String alarm1;
   //  private String alarm2;
    private String zonestatus;

    public String getDeviceId() {
        return deviceId;
    }

    public void setDeviceId(String deviceId) {
        this.deviceId = deviceId;
    }

    public String getWarnTime() {
        return warnTime;
    }

    public void setWarnTime(String warnTime) {
        this.warnTime = warnTime;
    }

    public String getEndpoint() {
        return endpoint;
    }

    public void setEndpoint(String endpoint) {
        this.endpoint = endpoint;
    }

    public String getDeviceTypeId() {
        return deviceTypeId;
    }

    public void setDeviceTypeId(String deviceTypeId) {
        this.deviceTypeId = deviceTypeId;
    }

    public String getZoneType() {
        return zoneType;
    }

    public void setZoneType(String zoneType) {
        this.zoneType = zoneType;
    }
    public String getZonestatus() {
        return zonestatus;
    }

    public void setZonestatus(String zonestatus) {
        this.zonestatus = zonestatus;
    }

//    public String getAlarm1() {
//        return alarm1;
//    }
//
//    public void setAlarm1(String alarm1) {
//        this.alarm1 = alarm1;
//    }
//
//    public String getAlarm2() {
//        return alarm2;
//    }
//
//    public void setAlarm2(String alarm2) {
//        this.alarm2 = alarm2;
//    }

    public Alarm()
    {
    }

    @Override
    public String toString() {
        return "Alarm{"+"deviceId='"+ deviceId +'\''+
                ", warnTime='"+ warnTime + '\''+
                ", endpoint='" + endpoint +'\''+
                ", deviceTypeId='"+ deviceTypeId +'\''+
                ", zoneType='"+ zoneType +'\''+
//                ", alarm1='"+ alarm1 + '\''+
//                ", alarm2='"+ alarm2 +'\''+
                ", zonestatus='"+ zonestatus +'\''+
                '}';
    }
}
