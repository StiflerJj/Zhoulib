package com.zhou.zhoulib.model;

import com.google.gson.annotations.Expose;


public class ReceiveWarning {

    /**
     * protocol : 3
     * content : {"deviceid":"33EEFF2211DD","endpoint":"2","warntime":"12333","zonetype":"ffff","zonestatus":"ffff"}
     */
    @Expose
    private String Protocol;
    /**
     * deviceid : 33EEFF2211DD
     * endpoint : 2
     * warntime : 12333
     * zonetype : ffff
     * zonestatus : ffff
     */
    @Expose
    private ContentBean Content;

    public String getProtocol() {return Protocol;}

    public void setProtocol(String protocol) {
        this.Protocol = protocol;
    }

    public ContentBean getContent() {
        return Content;
    }

    public void setContent(ContentBean content) {
        this.Content = content;
    }

    public static class ContentBean {
        @Expose
        private String Deviceid;
        @Expose
        private String Endpoint;
        @Expose
        private String Warntime;
        @Expose
        private String Zonetype;
        @Expose
        private String Zonestatus;

        public String getDeviceid() {
            return Deviceid;
        }

        public void setDeviceid(String deviceid) {
            this.Deviceid = deviceid;
        }

        public String getEndpoint() {return Endpoint;}

        public void setEndpoint(String endpoint) {
            this.Endpoint = endpoint;
        }

        public String getWarntime() {
            return Warntime;
        }

        public void setWarntime(String warntime) {
            this.Warntime = warntime;
        }

        public String getZonetype() {
            return Zonetype;
        }

        public void setZonetype(String zonetype) {
            this.Zonetype = zonetype;
        }

        public String getZonestatus() {
            return Zonestatus;
        }

        public void setZonestatus(String zonestatus) {
            this.Zonestatus = zonestatus;
        }
    }
}
