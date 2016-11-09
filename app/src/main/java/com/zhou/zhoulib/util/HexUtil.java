package com.zhou.zhoulib.util;

import java.io.ByteArrayOutputStream;
import java.util.Arrays;

/**
 * Created by cetnavjj on 2016/3/14.
 */
    public class HexUtil {

        /**
         * @param args
         */
        public static void main(String[] args) {

            String str = "12345678";

            String hexStr = encode(str);

            System.out.println("字符串－>十六进制：" + hexStr);

            System.out.println("十六进制－>字符串：" + decode(hexStr));

            System.out.println("十六进制->byte数组：" + hexStringToBytes(hexStr));

        }

        public static String stringToHexString(String strPart) {
            String hexString = "";
            for (int i = 0; i < strPart.length(); i++) {
                int ch = (int) strPart.charAt(i);
                String strHex = Integer.toHexString(ch);
                hexString = hexString + strHex;
            }
            return hexString;
        }

        private static String hexString = "0123456789ABCDEF";

        /*
         * 将字符串编码成16进制数字,适用于所有字符（包括中文）
         */
        public static String encode(String str) {
            // 根据默认编码获取字节数组
            byte[] bytes = str.getBytes();
            StringBuilder sb = new StringBuilder(bytes.length * 2);
            // 将字节数组中每个字节拆解成2位16进制整数
            for (int i = 0; i < bytes.length; i++) {
                sb.append(hexString.charAt((bytes[i] & 0xf0) >> 4));
                sb.append(hexString.charAt((bytes[i] & 0x0f) >> 0));
            }
            return sb.toString();
        }

        /*
         * 将16进制数字解码成字符串,适用于所有字符（包括中文）
         */
        public static String decode(String bytes) {
            ByteArrayOutputStream baos = new ByteArrayOutputStream(
                    bytes.length() / 2);
            // 将每2位16进制整数组装成一个字节
            for (int i = 0; i < bytes.length(); i += 2)
                baos.write((hexString.indexOf(bytes.charAt(i)) << 4 | hexString
                        .indexOf(bytes.charAt(i + 1))));
            return new String(baos.toByteArray());
        }

        private static byte uniteBytes(byte src0, byte src1) {
            byte _b0 = Byte.decode("0x" + new String(new byte[] { src0 }))
                    .byteValue();
            _b0 = (byte) (_b0 << 4);
            byte _b1 = Byte.decode("0x" + new String(new byte[] { src1 }))
                    .byteValue();
            byte ret = (byte) (_b0 | _b1);
            return ret;
        }

    public static byte[] hexStringToBytes(String hexString) {
        if (hexString == null || hexString.equals("")) {
            return null;
        }
        hexString = hexString.toUpperCase();
        int length = hexString.length() / 2;
        char[] hexChars = hexString.toCharArray();
        byte[] d = new byte[length];
        for (int i = 0; i < length; i++) {
            int pos = i * 2;
            d[i] = (byte) (charToByte(hexChars[pos]) << 4 | charToByte(hexChars[pos + 1]));

        }
        return d;
    }

    private static byte charToByte(char c) {
        return (byte) "0123456789ABCDEF".indexOf(c);
    }
    public static String bytesToHexString(byte[] src){
        StringBuilder stringBuilder = new StringBuilder("");
        if (src == null || src.length <= 0) {
            return null;
        }
        for (int i = 0; i < src.length; i++) {
            int v = src[i] & 0xFF;
            String hv = Integer.toHexString(v);
            if (hv.length() < 2) {
                stringBuilder.append(0);
            }
            stringBuilder.append(hv);
        }
        return stringBuilder.toString();
    }

    public static String toStringHex(String s){
        byte[] baKeyword = new byte[s.length()/2];
        for(int i = 0; i < baKeyword.length; i++){
            try{
                baKeyword[i] = (byte)(0xff & Integer.parseInt(s.substring(i*2, i*2+2),16));
            }catch(Exception e){
                e.printStackTrace();
            }
        }
        try{
            s = new String(baKeyword, "UTF-8");
        }catch (Exception e1){
            e1.printStackTrace();
        }
        return s;
    }

    /**
     * 将字符串编码成16进制数字,适用于所有字符（包括中文）
     */
    public static String encodeText(String str){
        //根据默认编码获取字节数组
        byte[] bytes=str.getBytes();
        StringBuilder sb=new StringBuilder(bytes.length*2);
        //将字节数组中每个字节拆解成2位16进制整数
        for(int i=0;i<bytes.length;i++){
            sb.append(hexString.charAt((bytes[i]&0xf0)>>4));
            sb.append(hexString.charAt((bytes[i]&0x0f)>>0));
        }
        return sb.toString();
    }
    /**
     * 将16进制数字解码成字符串,适用于所有字符（包括中文）
     */
    public static String decodeText(String bytes)
    {
        ByteArrayOutputStream baos=new ByteArrayOutputStream(bytes.length()/2);
        String tranBytes = bytes.toUpperCase();
        //将每2位16进制整数组装成一个字节
        for(int i=0;i<bytes.length();i+=2) {
            baos.write((hexString.indexOf(tranBytes.charAt(i)) << 4 | hexString.indexOf(tranBytes.charAt(i + 1))));
            }
        String bb = "";
        try {
            bb = new String(baos.toByteArray(), "utf-8");
        } catch (Exception e) {
            e.printStackTrace();
        }
        return bb;
    }

    public static String addZero(int length){
        String s = String.format("%02x",length);
        return s;
    }
    public static String  padLeft(String s, int length)
    {
        byte[] bs = new byte[length];
        byte[] ss = s.getBytes();
        Arrays.fill(bs, (byte) (48 & 0xff));
        System.arraycopy(ss, 0, bs,length - ss.length, ss.length);
        return new String(bs);
    }

    }
