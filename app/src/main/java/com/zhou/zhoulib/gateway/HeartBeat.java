package com.zhou.zhoulib.gateway;

import android.util.Log;

import com.zhou.zhoulib.util.HexUtil;
import com.zhou.zhoulib.util.YHUtils;

/**
 * Created by cetnavjj on 2016/3/21.
 */
public class HeartBeat extends Base{
    StringBuffer stringBuffer = new StringBuffer();
    public HeartBeat(String heartBeat){
        if(heartBeat!=null && heartBeat.length()>22){
            heartBeat = heartBeat.substring(10,22);
        }
        stringBuffer.append(head);
        stringBuffer.append("000b8002");
        stringBuffer.append(heartBeat);
        byte[] bytes = HexUtil.hexStringToBytes(stringBuffer.toString());
        byte[] jywbyte = new byte[1];
        jywbyte[0] = YHUtils.byteArrYH(bytes);
        String jyw = HexUtil.bytesToHexString(jywbyte);
        stringBuffer.append(jyw);
        stringBuffer.append(head);
        Log.e("HeartBeat", stringBuffer.toString());
        requestBytes = HexUtil.hexStringToBytes(stringBuffer.toString());
        setRequestBytes(requestBytes);
    }

}
