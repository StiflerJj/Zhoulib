package com.zhou.zhoulib.gateway;

import android.util.Log;

/**
 * Created by dell on 2016/9/1.
 */
public class LevelControlResponse {
    private LevelControl1 levelControl1;

    public LevelControlResponse(String deviceResponsestr){
        if(deviceResponsestr!=null && deviceResponsestr.length()>30) {
            String body = deviceResponsestr.substring(10, deviceResponsestr.length() - 4);
            Log.e("levelControlResponse", body);
            levelControl1 = new LevelControl1();
            levelControl1.setSerialId(body.substring(0, 8));
            levelControl1.setDeviceId(body.substring(8, 24));
            levelControl1.setEndPoint(body.substring(24, 26));
            levelControl1.setCommandID(body.substring(26, 28));
            levelControl1.setResult(body.substring(28, 30));
            setLevelControl1(levelControl1);
        }
    }

    public LevelControl1 getLevelControl1() {
        return levelControl1;
    }

    public void setLevelControl1(LevelControl1 levelControl1) {
        this.levelControl1 = levelControl1;
    }
}
