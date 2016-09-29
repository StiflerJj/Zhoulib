package com.zhou.zhoulib.model;

import com.google.gson.annotations.Expose;

import java.io.Serializable;

/**
 * Created by dell on 2016/9/23.
 */
public class RefreshResponse implements Serializable {

    private static final long serialVersionUID = 856175481381606380L;
    @Expose
    private String armModel;
    @Expose
    private String armStartTimehour;
    @Expose
    private String armStartTimemin;
    @Expose
    private String armEndTimehour;
    @Expose
    private String armEndTimemin;
    @Expose
    private String result;

    public String getArmModel() {
        return armModel;
    }

    public void setArmModel(String armModel) {
        this.armModel = armModel;
    }

    public String getArmStartTimehour() {
        return armStartTimehour;
    }

    public void setArmStartTimehour(String armStartTimehour) {
        this.armStartTimehour = armStartTimehour;
    }

    public String getArmStartTimemin() {
        return armStartTimemin;
    }

    public void setArmStartTimemin(String armStartTimemin) {
        this.armStartTimemin = armStartTimemin;
    }

    public String getArmEndTimehour() {
        return armEndTimehour;
    }

    public void setArmEndTimehour(String armEndTimehour) {
        this.armEndTimehour = armEndTimehour;
    }

    public String getArmEndTimemin() {
        return armEndTimemin;
    }

    public void setArmEndTimemin(String armEndTimemin) {
        this.armEndTimemin = armEndTimemin;
    }

    public String getResult() {
        return result;
    }

    public void setResult(String result) {
        this.result = result;
    }
}
