package com.zhou.zhoulib.gateway;

import java.io.Serializable;

/**
 * Created by cetnavjj on 2016/3/24.
 */
public class DeviceInfo implements Serializable{

    private static final long serialVersionUID = -1499033438087923161L;
    private String serialId;
    private String deviceId;
    private String endPoint;
    private String shoraddr;
    private String profileId;
    private String zclVersion;
    private String applicationVersion;
    private String stackVersion;
    private String hwVersion;
    private int  manufacturernamelen;
    private String manufacturername;
    private int modelidentifierlen;
    private String modelidentifier;
    private int datecodelen;
    private String datecode;
    private String powersource;

    public String getSerialId() {
        return serialId;
    }

    public void setSerialId(String serialId) {
        this.serialId = serialId;
    }

    public String getDeviceId() {
        return deviceId;
    }

    public void setDeviceId(String deviceId) {
        this.deviceId = deviceId;
    }

    public String getEndPoint() {
        return endPoint;
    }

    public void setEndPoint(String endPoint) {
        this.endPoint = endPoint;
    }

    public String getShoraddr() {return shoraddr;}
    public void setShoraddr(String shoraddr) {this.shoraddr = shoraddr;}

    public String getProfileId() {
        return profileId;
    }

    public void setProfileId(String profileId) {
        this.profileId = profileId;
    }

    public String getZclVersion() {
        return zclVersion;
    }

    public void setZclVersion(String zclVersion) {
        this.zclVersion = zclVersion;
    }

    public String getApplicationVersion() {
        return applicationVersion;
    }

    public void setApplicationVersion(String applicationVersion) {
        this.applicationVersion = applicationVersion;
    }

    public String getStackVersion() {
        return stackVersion;
    }

    public void setStackVersion(String stackVersion) {
        this.stackVersion = stackVersion;
    }

    public String getHwVersion() {
        return hwVersion;
    }

    public void setHwVersion(String hwVersion) {
        this.hwVersion = hwVersion;
    }

    public int getManufacturernamelen() {
        return manufacturernamelen;
    }

    public void setManufacturernamelen(int manufacturernamelen) {
        this.manufacturernamelen = manufacturernamelen;
    }

    public String getManufacturername() {
        return manufacturername;
    }

    public void setManufacturername(String manufacturername) {
        this.manufacturername = manufacturername;
    }

    public int getModelidentifierlen() {
        return modelidentifierlen;
    }

    public void setModelidentifierlen(int modelidentifierlen) {
        this.modelidentifierlen = modelidentifierlen;
    }

    public String getModelidentifier() {
        return modelidentifier;
    }

    public void setModelidentifier(String modelidentifier) {
        this.modelidentifier = modelidentifier;
    }

    public int getDatecodelen() {
        return datecodelen;
    }

    public void setDatecodelen(int datecodelen) {
        this.datecodelen = datecodelen;
    }

    public String getDatecode() {
        return datecode;
    }

    public void setDatecode(String datecode) {
        this.datecode = datecode;
    }

    public String getPowersource() {
        return powersource;
    }

    public void setPowersource(String powersource) {
        this.powersource = powersource;
    }

    @Override
    public String toString() {
        return "DeviceInfo{" +
                "serialId='" + serialId + '\'' +
                ", deviceId='" + deviceId + '\'' +
                ", endPoint='" + endPoint + '\'' +
                ", shoraddr='" + shoraddr + '\'' +
                ", profileId='" + profileId + '\'' +
                ", zclVersion='" + zclVersion + '\'' +
                ", applicationVersion='" + applicationVersion + '\'' +
                ", stackVersion='" + stackVersion + '\'' +
                ", hwVersion='" + hwVersion + '\'' +
                ", manufacturernamelen=" + manufacturernamelen +
                ", manufacturername='" + manufacturername + '\'' +
                ", modelidentifierlen=" + modelidentifierlen +
                ", modelidentifier='" + modelidentifier + '\'' +
                ", datecodelen=" + datecodelen +
                ", datecode='" + datecode + '\'' +
                ", powersource='" + powersource + '\'' +
                '}';
    }
}
