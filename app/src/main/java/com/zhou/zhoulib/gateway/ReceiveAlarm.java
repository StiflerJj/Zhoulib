package com.zhou.zhoulib.gateway;

import android.util.Log;

/**
 * Created by dkdh on 2016/4/7.
 * 报警(目前仅针对门磁)
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

public class ReceiveAlarm {
    private Alarm alarm;
    private static final String TAG = "ReceiveAlarm";
    public ReceiveAlarm(String receiveAlarmData){
        if(receiveAlarmData!=null&&receiveAlarmData.length()>56){
            Log.e(TAG, receiveAlarmData);
            alarm = new Alarm();
            alarm.setDeviceId(receiveAlarmData.substring(10,26));
            alarm.setWarnTime(receiveAlarmData.substring(26, 42));
            alarm.setEndpoint(receiveAlarmData.substring(42, 44));
            alarm.setDeviceTypeId(receiveAlarmData.substring(44, 48));
            alarm.setZoneType(receiveAlarmData.substring(48, 52));
//          alarm.setAlarm1(receiveAlarmData.substring(52, 54));
//          alarm.setAlarm2(receiveAlarmData.substring(54, 56));
            alarm.setZonestatus(receiveAlarmData.substring(55, 56));
            setAlarm(alarm);
        }
    }

    public Alarm getAlarm() {
        return alarm;
    }

    public void setAlarm(Alarm alarm) {
        this.alarm = alarm;
    }
}
