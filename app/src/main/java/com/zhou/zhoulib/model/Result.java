package com.zhou.zhoulib.model;

import com.google.gson.annotations.Expose;

/**
 * Created by dell on 2016/7/26.
 */
public class Result {
    @Expose
    private int code;
//    @Expose
//    private String message;

    public void setCode(int code) {
        this.code = code;
    }

//    public void setMessage(String message) {
//        this.message = message;
//    }

    public int getCode() {return code;}

//    public String getMessage() {
//        return message;
//    }
}
