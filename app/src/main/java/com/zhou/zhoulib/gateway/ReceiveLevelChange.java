package com.zhou.zhoulib.gateway;

import android.util.Log;

/**
 * Created by dell on 2016/9/19.
 * level状态改变通知：
 ce
 00 15
 00 18
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
 设备状态： 1 byte 当前level值
 校验码 (从开头到校验位前一位的^)
 标识位 1 byte
 */
public class ReceiveLevelChange {
    private LevelChange levelChange;
    private static final String TAG = "ReceiveLevelChange";

    public ReceiveLevelChange(String receiveData){
        if(receiveData!=null && receiveData.length()>38){
            Log.e(TAG, receiveData);
            levelChange = new LevelChange();
            levelChange.setSerialId(receiveData.substring(10,18));
            levelChange.setDeviceId(receiveData.substring(18,34));
            levelChange.setEndPoint(receiveData.substring(34, 36));
            levelChange.setStatus(receiveData.substring(36, 38));
            setLevelChange(levelChange);
        }
    }

    public LevelChange getLevelChange() {
        return levelChange;
    }

    public void setLevelChange(LevelChange levelChange) {
        this.levelChange = levelChange;
    }
}
