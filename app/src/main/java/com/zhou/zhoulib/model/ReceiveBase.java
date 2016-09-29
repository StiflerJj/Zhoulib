package com.zhou.zhoulib.model;

/**
 * Created by dell on 2016/8/16.
 */
public class ReceiveBase {
    /**
     * Protocol : 3
     * Content : {"Deviceid":5482164976178344,"Endpoint":1,"Warntime":1471530409,"Zonetype":277,"Zonestatus":25618}
     */

    private String Protocol;
    /**
     * Deviceid : 5482164976178344
     * Endpoint : 1
     * Warntime : 1471530409
     * Zonetype : 277
     * Zonestatus : 25618
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
        private long Deviceid;
        private int Endpoint;
        private int Warntime;
        private int Zonetype;
        private int Zonestatus;

        public long getDeviceid() {
            return Deviceid;
        }

        public void setDeviceid(long Deviceid) {
            this.Deviceid = Deviceid;
        }

        public int getEndpoint() {
            return Endpoint;
        }

        public void setEndpoint(int Endpoint) {
            this.Endpoint = Endpoint;
        }

        public int getWarntime() {
            return Warntime;
        }

        public void setWarntime(int Warntime) {
            this.Warntime = Warntime;
        }

        public int getZonetype() {
            return Zonetype;
        }

        public void setZonetype(int Zonetype) {
            this.Zonetype = Zonetype;
        }

        public int getZonestatus() {
            return Zonestatus;
        }

        public void setZonestatus(int Zonestatus) {
            this.Zonestatus = Zonestatus;
        }
    }


//    @Expose
//    private String Protocol;
//    @Expose
//    private String Content;
//
//    public String getProtocol() {
//        return Protocol;
//    }
//
//    public void setProtocol(String protocol) {
//        Protocol = protocol;
//    }
//
//    public String getContent() {
//        return Content;
//    }
//
//    public void setContent(String content) {
//        this.Content = content;
//    }



}
