package com.zhou.zhoulib.gateway;

import android.util.Log;

import com.zhou.zhoulib.util.HexUtil;
import com.zhou.zhoulib.util.YHUtils;

/**
 * Created by cetnavjj on 2016/3/25.
 */
public class DeviceWarning extends Base{
    StringBuffer stringBuffer = new StringBuffer();
    public DeviceWarning(String serialId,String deviceId,String endPoint){
        stringBuffer.append(head);
        stringBuffer.append("001b800d");
        stringBuffer.append(serialId);
        stringBuffer.append(deviceId);
        stringBuffer.append(endPoint);
        stringBuffer.append("00050101010101");
        byte[] bytes = HexUtil.hexStringToBytes(stringBuffer.toString());
        byte[] jywbyte = new byte[1];
        jywbyte[0] = YHUtils.byteArrYH(bytes);
        String jyw = HexUtil.bytesToHexString(jywbyte);
        stringBuffer.append(jyw);
        stringBuffer.append(head);
        Log.e("DeviceWarning", stringBuffer.toString());
        requestBytes = HexUtil.hexStringToBytes(stringBuffer.toString());
        setRequestBytes(requestBytes);
    }
}
