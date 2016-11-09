package com.zhou.zhoulib.gateway;

import android.util.Log;

import com.zhou.zhoulib.util.HexUtil;
import com.zhou.zhoulib.util.YHUtils;


/**
 * Created by cetnavjj on 2016/3/25.
 */
public class DeviceDefence extends Base{

    StringBuffer stringBuffer = new StringBuffer();
    public DeviceDefence(String serialId,String deviceId,String endPoint,String armModel,String armStarttime,String armEndtime){
        stringBuffer.append(head);
        stringBuffer.append("0019800f");
        stringBuffer.append(serialId);
        stringBuffer.append(deviceId);
        stringBuffer.append(endPoint);
        stringBuffer.append(armModel);
        stringBuffer.append(armStarttime);
        stringBuffer.append(armEndtime);
        byte[] bytes = HexUtil.hexStringToBytes(stringBuffer.toString());
        byte[] jywbyte = new byte[1];
        jywbyte[0] = YHUtils.byteArrYH(bytes);
        String jyw = HexUtil.bytesToHexString(jywbyte);
        stringBuffer.append(jyw);
        stringBuffer.append(head);
        Log.e("DeviceDefence", stringBuffer.toString());
        requestBytes = HexUtil.hexStringToBytes(stringBuffer.toString());
        setRequestBytes(requestBytes);

    }
}
