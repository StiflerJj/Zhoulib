package com.zhou.zhoulib.gateway;

import android.util.Log;

import com.zhou.zhoulib.util.HexUtil;
import com.zhou.zhoulib.util.YHUtils;


/**
 * Created by dell on 2016/9/19.
 * 发起读取布防状态命令：
 ce
 00 14
 80 1f
 00 00 00 01
 00 13 7a 00 00 01 56 d3
 01
 3c
 ce
 -------
 标识位 1 byte "0xCE"
 消息长度 2 bytes 标识位(含)字节长度长度
 消息ID 2 bytes 0x80 0x15
 SerialID 4 bytes 序列号
 DeviceID 8 bytes 设备ID(IEEE)
 endpoint 1 byte(单位：秒)
 校验码 1 byte(从开头到校验位前一位的^)
 标识位 1 byte
 */
public class GetDefenceStatus extends Base {

    StringBuffer stringBuffer = new StringBuffer();
    public GetDefenceStatus(String serialId, String deviceId, String endPoint) {
        stringBuffer.append(head);
        stringBuffer.append("0014801f");
        stringBuffer.append(serialId);
        stringBuffer.append(deviceId);
        stringBuffer.append(endPoint);
        byte[] bytes = HexUtil.hexStringToBytes(stringBuffer.toString());
        byte[] jywbyte = new byte[1];
        jywbyte[0] = YHUtils.byteArrYH(bytes);
        String jyw = HexUtil.bytesToHexString(jywbyte);
        stringBuffer.append(jyw);
        stringBuffer.append(head);
        Log.e("GetDefenceStatus", stringBuffer.toString());
        requestBytes = HexUtil.hexStringToBytes(stringBuffer.toString());
        setRequestBytes(requestBytes);
    }
}
