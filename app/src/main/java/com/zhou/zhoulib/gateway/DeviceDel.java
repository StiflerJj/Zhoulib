package com.zhou.zhoulib.gateway;

import android.util.Log;

import com.zhou.zhoulib.util.HexUtil;
import com.zhou.zhoulib.util.YHUtils;


/**
 * Created by cetnavjj on 2016/3/25.
 */
public class DeviceDel extends Base{
    StringBuffer stringBuffer = new StringBuffer();
    public DeviceDel(String serialId,String deviceId){
        stringBuffer.append(head);
        stringBuffer.append("0013800a");
        stringBuffer.append(serialId);
        stringBuffer.append(deviceId);
        byte[] bytes = HexUtil.hexStringToBytes(stringBuffer.toString());
        byte[] jywbyte = new byte[1];
        jywbyte[0] = YHUtils.byteArrYH(bytes);
        String jyw = HexUtil.bytesToHexString(jywbyte);
        stringBuffer.append(jyw);
        stringBuffer.append(head);
        Log.e("DeviceDel", stringBuffer.toString());
        requestBytes = HexUtil.hexStringToBytes(stringBuffer.toString());
        setRequestBytes(requestBytes);

    }
}
