package com.zhou.zhoulib.gateway;

/**
 * 网关数据基类
 * Created by cetnavjj on 2016/3/15.
 */
public class Base {
    public String head = "CE";
    byte[] requestBytes = new byte[1];
    public Base(){
    }

    public byte[] getRequestBytes() {
        return requestBytes;
    }

    public void setRequestBytes(byte[] requestBytes) {
        this.requestBytes = requestBytes;
    }
}
