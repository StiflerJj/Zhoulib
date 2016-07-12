package com.zhou.zhoulib;

/**
 * Created by zhangkai on 2016/2/1.
 */
public class Device {
    private Long IEEE;
    private String Name;

    public String getName(){
        return this.Name;
    }

    public void setName(String Name){
        this.Name = Name;
    }

    public Long getIEEE(){
        return this.IEEE;
    }

    public void setIEEE(Long IEEE){
        this.IEEE = IEEE;
    }
}
