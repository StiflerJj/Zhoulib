package com.zhou.zhoulib.gateway;

import android.util.Log;

/**
 * Created by dell on 2016/9/19.
 * OnOff状态改变通知：
 ce
 00 15
 00 16
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
 设备状态： 1 byte (0:off 1:on)
 校验码 (从开头到校验位前一位的^)
 标识位 1 byte
 */
public class ReceiveOnOffChange {

    private OnOffChange onOffChange;
    private static final String TAG = "ReceiveOnOffChange";

    public ReceiveOnOffChange(String receiveData){
        if(receiveData!=null && receiveData.length()>38){
            Log.e(TAG, receiveData);
            onOffChange = new OnOffChange();
            onOffChange.setSerialId(receiveData.substring(10,18));
            onOffChange.setDeviceId(receiveData.substring(18,34));
            onOffChange.setEndPoint(receiveData.substring(34, 36));
            onOffChange.setStatus(receiveData.substring(36, 38));
            setOnOffChange(onOffChange);
        }
    }

    public OnOffChange getOnOffChange() {
        return onOffChange;
    }

    public void setOnOffChange(OnOffChange onOffChange) {
        this.onOffChange = onOffChange;
    }
}
