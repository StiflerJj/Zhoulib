package com.zhou.zhoulib.model;

import com.google.gson.annotations.Expose;

/**
 * Created by dell on 2016/7/27.
 */
public class OutGetDeviceInfoResponse {

    /**
 *  "shortaddr":"04ef",
 *  "profileid":0401,
 *  "zclversionst":1,
 *  "applicationversion":1,
 *  "stackversion":1,
 *  "hwversion":1,
 *  "manufacturename":"电科导航",
 *  "modelidentifier":"未知",
 *  "datecode":"20160526",
 *  "powersource":0
 */
    @Expose
    private String Shortaddr;
    @Expose
    private String Profileid;
    @Expose
    private String Zclversionst;
    @Expose
    private int Applicationversion;
    @Expose
    private int Stackversion;
    @Expose
    private int Hwversion;
    @Expose
    private String Manufacturename;
    @Expose
    private String Modelidentifier;
    @Expose
    private String Datecode;
    @Expose
    private String Powersource;


    public String getShortaddr() {
        return Shortaddr;
    }

    public void setShortaddr(String shortaddr) {
        Shortaddr = shortaddr;
    }


    public String getProfileid() {
        return Profileid;
    }

    public void setProfileid(String profileid) {
        Profileid = profileid;
    }

    public String getZclversionst() {
        return Zclversionst;
    }

    public void setZclversionst(String zclversionst) {
        Zclversionst = zclversionst;
    }

    public void setApplicationversion(int Applicationversion){

        this.Applicationversion = Applicationversion;

    }

    public int getApplicationversion(){

        return this.Applicationversion;

    }

    public void setStackversion(int Stackversion){

        this.Stackversion = Stackversion;

    }

    public int getStackversion(){

        return this.Stackversion;

    }

    public void setHwversion(int Hwversion){

        this.Hwversion = Hwversion;

    }

    public int getHwversion(){

        return this.Hwversion;

    }

    public void setManufacturename(String Manufacturename){

        this.Manufacturename = Manufacturename;

    }

    public String getManufacturename(){

        return this.Manufacturename;

    }

    public void setModelidentifier(String Modelidentifier){

        this.Modelidentifier = Modelidentifier;

    }

    public String getModelidentifier(){

        return this.Modelidentifier;

    }

    public void setDatecode(String Datecode){

        this.Datecode = Datecode;

    }

    public String getDatecode(){

        return this.Datecode;

    }
    public String getPowersource() {
        return Powersource;
    }

    public void setPowersource(String powersource) {
        Powersource = powersource;
    }

}
