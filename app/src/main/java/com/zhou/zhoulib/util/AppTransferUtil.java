package com.zhou.zhoulib.util;

import android.content.ComponentName;
import android.content.Context;
import android.content.Intent;
import android.os.Bundle;

/**
 * Created by cetnavjj on 2016/4/8.
 */
public class AppTransferUtil {

    /**
     * 应用间传递数据
     */
    public static void transferAppData(Context context,String pkg,String ac,Bundle bundle){
        Intent intent = new Intent();
        ComponentName cn = new ComponentName(pkg,
                ac);
        if (cn != null) {
            intent.setComponent(cn);
            intent.putExtras(bundle);
            context.startActivity(intent);
        }

    }
}
