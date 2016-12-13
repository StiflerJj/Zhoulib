package com.zhou.zhoulib.gateway;

import android.util.Log;

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
public class ReceiveOnlineChange {
    private OnlineChange onlineChange;
    private static final String TAG = "ReceiveOnlineChange";

    public ReceiveOnlineChange(String receiveData){
        if( receiveData!=null ){
            Log.e(TAG, receiveData);
            onlineChange = new OnlineChange();
            onlineChange.setSerialId(receiveData.substring(10,18));
            onlineChange.setDeviceId(receiveData.substring(18,34));
            onlineChange.setOnline(receiveData.substring(34,36));
            setOnlineChange(onlineChange);
        }
    }

    public OnlineChange getOnlineChange() {
        return onlineChange;
    }

    public void setOnlineChange(OnlineChange onlineChange) {
        this.onlineChange = onlineChange;
    }
}
