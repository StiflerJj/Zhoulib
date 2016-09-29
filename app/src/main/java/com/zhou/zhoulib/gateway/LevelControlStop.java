package com.zhou.zhoulib.gateway;

import android.util.Log;

import com.zhou.zhoulib.util.HexUtil;
import com.zhou.zhoulib.util.YHUtils;


/**
 * Created by dell on 2016/9/22.
 */
public class LevelControlStop extends Base {
    StringBuffer stringBuffer = new StringBuffer();
    public LevelControlStop(String serialId, String deviceId, String endPoint, String CommandID){
        stringBuffer.append(head);
        stringBuffer.append("00158011");
        stringBuffer.append(serialId);
        stringBuffer.append(deviceId);
        stringBuffer.append(endPoint);
        stringBuffer.append(CommandID);
        byte[] bytes = HexUtil.hexStringToBytes(stringBuffer.toString());
        byte[] jywbyte = new byte[1];
        jywbyte[0] = YHUtils.byteArrYH(bytes);
        String jyw = HexUtil.bytesToHexString(jywbyte);
        stringBuffer.append(jyw);
        stringBuffer.append(head);
        Log.e("LevelControlStop", stringBuffer.toString());
        requestBytes = HexUtil.hexStringToBytes(stringBuffer.toString());
        setRequestBytes(requestBytes);
    }
}