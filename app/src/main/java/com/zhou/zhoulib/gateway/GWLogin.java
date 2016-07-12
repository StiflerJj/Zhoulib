package com.zhou.zhoulib.gateway;

import android.util.Log;

import com.zhou.zhoulib.util.HexUtil;
import com.zhou.zhoulib.util.YHUtils;


/**
 * 登陆内网
 * CE 00 0D 80 0E 00 0C 29 A5 26 48 A3 CE
 * Created by cetnavjj on 2016/3/15.
 */
public class GWLogin extends Base{
    StringBuffer stringBuffer = new StringBuffer();

    public GWLogin(String mac){
        stringBuffer.append(head);
        stringBuffer.append("000D800E");
        stringBuffer.append(mac);
        byte[] bytes = HexUtil.hexStringToBytes(stringBuffer.toString());
        byte[] jywbyte = new byte[1];
        jywbyte[0] = YHUtils.byteArrYH(bytes);
        String jyw = HexUtil.bytesToHexString(jywbyte);
        stringBuffer.append(jyw);
        stringBuffer.append(head);
        Log.e("GWLOGIN", stringBuffer.toString());
        requestBytes = HexUtil.hexStringToBytes(stringBuffer.toString());
        setRequestBytes(requestBytes);
    }
}
