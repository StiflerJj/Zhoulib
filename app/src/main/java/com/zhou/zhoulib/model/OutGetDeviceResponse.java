package com.zhou.zhoulib.model;

import android.util.Log;


import com.google.gson.annotations.Expose;
import com.zhou.zhoulib.gateway.Device2;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

/**
 * Created by dell on 2016/7/26.
 */
public class OutGetDeviceResponse implements Serializable{


    private static final long serialVersionUID = -8143002899879141393L;
    /**
 *  "Gatewayname":"网关",
 *  "TotalCount":6,
 *  "Devices":[{"Deviceid":"00124B00076A6511","Devicename":"","Endpoints":[{"Endpoint":1,"Devicetype":1026,"Zonetype":21}]},  {"Deviceid":"00124B00076AC093","Devicename":"","Endpoints":[{"Endpoint":1,"Devicetype":1026,"Zonetype":40}]}
 */
//    @Expose
    private String result;
    @Expose
    private String Gatewayname;
    @Expose
    private int TotalCount;
    @Expose
    private List<Devices> Devices ;


    private List<Device2> device2s;

    public List<Device2> getDevice2s() {
        device2s = new ArrayList<>();
        if(Devices!=null && Devices.size()>0){
            for (Devices devices: Devices){
                List<Endpoints> endpointses = devices.getEndpoints();
                for (Endpoints endpoints : endpointses){
                    Device2 device2 = new Device2();
                    device2.setDeviceId(devices.getDeviceid());
                    device2.setDeviceName(devices.getDevicename());
                    device2.setDeviceTypeId(endpoints.getDevicetype()+"");
                    device2.setEndpoint(endpoints.getEndpoint()+"");
                    device2.setZoneType(endpoints.getZonetype()+"");
                    device2.setStatus(endpoints.getStatus()+"");
                    Log.e("OutGetDeviceResponse","device2"+ device2);
                    device2s.add(device2);
                }
            }
        }
        return device2s;
    }
    public void setDevice2s(List<Device2> device2s) {
        this.device2s = device2s;
    }


    public String getResult() {
        return result;
    }

    public void setResult(String result) {
        this.result = result;
    }

    public void setGatewayname(String Gatewayname){

        this.Gatewayname = Gatewayname;

    }

    public String getGatewayname(){

        return this.Gatewayname;

    }

    public void setTotalCount(int TotalCount){

        this.TotalCount = TotalCount;

    }

    public int getTotalCount(){

        return this.TotalCount;

    }

    public void setDevices(List<Devices> Devices){

        this.Devices = Devices;

    }

    public List<Devices> getDevices(){

        return this.Devices;

    }


    public static class Devices {
/**
 *   "Deviceid":"00124B00076A6511",
 *   "Devicename":"",
 *   "Endpoints":[{"Endpoint":1,"Devicetype":1026,"Zonetype":21}]
 *
 */
        @Expose
        private String Deviceid;
        @Expose
        private String Devicename;
        @Expose
        private List<Endpoints> Endpoints ;


        public void setDeviceid(String Deviceid){

            this.Deviceid = Deviceid;

        }

        public String getDeviceid(){

            return this.Deviceid;

        }

        public void setDevicename(String Devicename){

            this.Devicename = Devicename;

        }

        public String getDevicename(){

            return this.Devicename;

        }

        public void setEndpoints(List<Endpoints> Endpoints){

            this.Endpoints = Endpoints;

        }

        public List<Endpoints> getEndpoints(){

            return this.Endpoints;

        }

    }

    public static class Endpoints {
/**
 *     "Endpoint":1,
 *     "Devicetype":1026,
 *     "Zonetype":21
 *     "Status":0
 *
 */
        @Expose
        private int Endpoint;
        @Expose
        private int Devicetype;
        @Expose
        private int Zonetype;
        @Expose
        private int Status;

        public int getStatus() {
            return this.Status;
        }

        public void setStatus(int status) {
            this.Status = status;
        }

        public void setEndpoint(int Endpoint){

            this.Endpoint = Endpoint;

        }

        public int getEndpoint(){

            return this.Endpoint;

        }

        public void setDevicetype(int Devicetype){

            this.Devicetype = Devicetype;

        }

        public int getDevicetype(){

            return this.Devicetype;

        }

        public void setZonetype(int Zonetype){

            this.Zonetype = Zonetype;

        }

        public int getZonetype(){

            return this.Zonetype;

        }

    }
}
