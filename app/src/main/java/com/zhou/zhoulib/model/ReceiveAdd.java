package com.zhou.zhoulib.model;

import java.util.List;

/**
 * Created by dell on 2016/8/15.
 */
public class ReceiveAdd {

    /**
     * Protocol : 1
     * Content : {"DeviceID":5482164976274326,"Endpoints":[{"Endpoint":2,"Devicetype":1,"Zonetype":0,"Status":0},{"Endpoint":2,"Devicetype":9,"Zonetype":0,"Status":0}]}
     */

    private String Protocol;
    /**
     * DeviceID : 5482164976274326
     * Endpoints : [{"Endpoint":2,"Devicetype":1,"Zonetype":0,"Status":0},{"Endpoint":2,"Devicetype":9,"Zonetype":0,"Status":0}]
     */

    private ContentBean Content;

    public String getProtocol() {
        return Protocol;
    }

    public void setProtocol(String Protocol) {
        this.Protocol = Protocol;
    }

    public ContentBean getContent() {
        return Content;
    }

    public void setContent(ContentBean Content) {
        this.Content = Content;
    }

    public static class ContentBean {
        private long DeviceID;
        /**
         * Endpoint : 2
         * Devicetype : 1
         * Zonetype : 0
         * Status : 0
         */

        private List<EndpointsBean> Endpoints;

        public long getDeviceID() {
            return DeviceID;
        }

        public void setDeviceID(long DeviceID) {
            this.DeviceID = DeviceID;
        }

        public List<EndpointsBean> getEndpoints() {
            return Endpoints;
        }

        public void setEndpoints(List<EndpointsBean> Endpoints) {
            this.Endpoints = Endpoints;
        }

        public static class EndpointsBean {
            private int Endpoint;
            private int Devicetype;
            private int Zonetype;
            private int Status;

            public int getEndpoint() {
                return Endpoint;
            }

            public void setEndpoint(int Endpoint) {
                this.Endpoint = Endpoint;
            }

            public int getDevicetype() {
                return Devicetype;
            }

            public void setDevicetype(int Devicetype) {
                this.Devicetype = Devicetype;
            }

            public int getZonetype() {
                return Zonetype;
            }

            public void setZonetype(int Zonetype) {
                this.Zonetype = Zonetype;
            }

            public int getStatus() {
                return Status;
            }

            public void setStatus(int Status) {
                this.Status = Status;
            }
        }
    }
}
