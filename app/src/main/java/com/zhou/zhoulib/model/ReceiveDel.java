package com.zhou.zhoulib.model;

import com.google.gson.annotations.Expose;

/**
 * Created by dell on 2016/8/15.
 */
public class ReceiveDel {
    /**
     * protocol : 2
     * content : {"deviceid":"ieee"}
     */
    @Expose
    private String Protocol;
    /**
     * deviceid : ieee
     */
    @Expose
    private ContentBean Content;

    public String getProtocol() {
        return Protocol;
    }

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
        private String deviceid;

        public String getDeviceid() {
            return deviceid;
        }

        public void setDeviceid(String deviceid) {
            this.deviceid = deviceid;
        }
    }
}
