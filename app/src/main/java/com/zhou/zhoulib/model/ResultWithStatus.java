package com.zhou.zhoulib.model;

import com.google.gson.annotations.Expose;

/**
 * Created by dell on 2016/8/17.
 */
public class ResultWithStatus {
    /**
     * result : 0
     * status : 64
     */
    @Expose
    private int result;
    @Expose
    private int status;

    public int getResult() {
        return result;
    }

    public void setResult(int result) {
        this.result = result;
    }

    public int getStatus() {
        return status;
    }

    public void setStatus(int status) {
        this.status = status;
    }
}
