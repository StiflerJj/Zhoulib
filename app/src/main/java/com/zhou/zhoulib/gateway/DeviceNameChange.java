package com.zhou.zhoulib.gateway;

import android.util.Log;

import com.zhou.zhoulib.util.HexUtil;
import com.zhou.zhoulib.util.YHUtils;


/**
 * Created by cetnavjj on 2016/3/25.
 */
public class DeviceNameChange extends Base{
    StringBuffer stringBufferOld = new StringBuffer();
    StringBuffer stringBuffer = new StringBuffer();
    public DeviceNameChange(String serialId,String deviceId,String newName){
        stringBufferOld.append(head);
        stringBufferOld.append("001a8008");
        stringBufferOld.append(serialId);
        stringBufferOld.append(deviceId);
        byte[] nameBytesOld = HexUtil.hexStringToBytes(HexUtil.encodeText(newName));
        Log.e("renamehex", " HexUtil.encode" + HexUtil.encodeText(newName));
        String nameLengthOld = HexUtil.addZero(nameBytesOld.length);
        Log.e("renamehexbytelength"," HexUtil.length"+nameLengthOld);
        stringBufferOld.append(nameLengthOld);
        stringBufferOld.append(HexUtil.encode(newName));
        byte[] bytesOld = HexUtil.hexStringToBytes(stringBufferOld.toString());
        byte[] jywbyteOld = new byte[1];
        jywbyteOld[0] = YHUtils.byteArrYH(bytesOld);
        String jywOld = HexUtil.bytesToHexString(jywbyteOld);
        stringBufferOld.append(jywOld);
        stringBufferOld.append(head);
        int allLength = HexUtil.hexStringToBytes(stringBufferOld.toString()).length;
        String addLength = HexUtil.padLeft(Integer.toHexString(allLength),4);
        //以上只为求出长度。。。
        Log.e("Devicelength = ", addLength);
        stringBuffer.append(head);
        stringBuffer.append(addLength);
        stringBuffer.append("8008");
        stringBuffer.append(serialId);
        stringBuffer.append(deviceId);
        byte[] nameBytes = HexUtil.hexStringToBytes(HexUtil.encodeText(newName));
        Log.e("renamehex", " HexUtil.encode" + HexUtil.encodeText(newName));
        String nameLength = HexUtil.addZero(nameBytes.length);
        Log.e("renamehexbytelength"," HexUtil.length"+nameLength);
        stringBuffer.append(nameLength);
        stringBuffer.append(HexUtil.encode(newName));
        byte[] bytes = HexUtil.hexStringToBytes(stringBuffer.toString());
        byte[] jywbyte = new byte[1];
        jywbyte[0] = YHUtils.byteArrYH(bytes);
        String jyw = HexUtil.bytesToHexString(jywbyte);
        stringBuffer.append(jyw);
        stringBuffer.append(head);
        Log.e("DeviceNameChange", stringBuffer.toString());
        requestBytes = HexUtil.hexStringToBytes(stringBuffer.toString());
        setRequestBytes(requestBytes);
    }
}
