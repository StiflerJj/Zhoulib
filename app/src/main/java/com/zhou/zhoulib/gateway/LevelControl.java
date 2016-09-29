package com.zhou.zhoulib.gateway;

import android.util.Log;

import com.zhou.zhoulib.util.HexUtil;
import com.zhou.zhoulib.util.YHUtils;


/**
 * Created by dell on 2016/9/1.
 */
public class LevelControl extends Base {
    StringBuffer stringBuffer = new StringBuffer();
    public LevelControl(String serialId, String deviceId, String endPoint, String CommandID, String level, String transactionTime){
        stringBuffer.append(head);
        stringBuffer.append("00188011");
        stringBuffer.append(serialId);
        stringBuffer.append(deviceId);
        stringBuffer.append(endPoint);
        stringBuffer.append(CommandID);
        stringBuffer.append(level);
        stringBuffer.append(transactionTime);
        byte[] bytes = HexUtil.hexStringToBytes(stringBuffer.toString());
        byte[] jywbyte = new byte[1];
        jywbyte[0] = YHUtils.byteArrYH(bytes);
        String jyw = HexUtil.bytesToHexString(jywbyte);
        stringBuffer.append(jyw);
        stringBuffer.append(head);
        Log.e("LevelControl", stringBuffer.toString());
        requestBytes = HexUtil.hexStringToBytes(stringBuffer.toString());
        setRequestBytes(requestBytes);

    }
}
