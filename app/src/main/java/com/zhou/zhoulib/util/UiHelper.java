package com.zhou.zhoulib.util;

import android.app.AlertDialog.Builder;
import android.content.Context;
import android.content.DialogInterface;
import android.content.DialogInterface.OnClickListener;
import android.view.ViewGroup.LayoutParams;
import android.widget.LinearLayout;
import android.widget.TextView;


/**
 * Created by cetnavjj on 2016/3/25.
 */
public class UiHelper {
    /**
     * 提问框的 Listener
     *
     * @author Lei
     */
    // 因为本类不是activity所以通过继承接口的方法获取到点击的事件
    public interface OnClickYesListener {
        abstract void onClickYes();
    }

    /**
     * 提问框的 Listener
     *
     */
    public interface OnClickNoListener {
        abstract void onClickNo();
    }

    public static void showQuestionDialog(Context context, String title,
                                          String text, final OnClickYesListener listenerYes,
                                          final OnClickNoListener listenerNo) {

        Builder builder = new Builder(context);

        if (!isBlank(text)) {
            // 此方法为dialog写布局
            final TextView textView = new TextView(context);
            textView.setText(text);
            LinearLayout layout = new LinearLayout(context);
            layout.setPadding(10, 0, 10, 0);
            layout.addView(textView, new LayoutParams(LayoutParams.FILL_PARENT,
                    LayoutParams.WRAP_CONTENT));
            builder.setView(layout);
        }
        // 设置title
        builder.setTitle(title);
        // 设置确定按钮，固定用法声明一个按钮用这个setPositiveButton
        builder.setPositiveButton("ok",
                new OnClickListener() {
                    public void onClick(DialogInterface dialog, int which) {
                        // 如果确定被电击
                        if (listenerYes != null) {
                            listenerYes.onClickYes();
                        }
                    }
                });
        // 设置取消按钮，固定用法声明第二个按钮要用setNegativeButton
        builder.setNegativeButton("cancel",
                new OnClickListener() {
                    public void onClick(DialogInterface dialog, int which) {
                        // 如果取消被点击
                        if (listenerNo != null) {
                            listenerNo.onClickNo();
                        }
                    }
                });

        // 控制这个dialog可不可以按返回键，true为可以，false为不可以
        builder.setCancelable(false);
        // 显示dialog
        builder.create().show();

    }

    /**
     * 处理字符的方法
     *
     * @param str
     * @return
     */
    public static boolean isBlank(String str) {
        int strLen;
        if (str == null || (strLen = str.length()) == 0) {
            return true;
        }
        for (int i = 0; i < strLen; i++) {
            if ((Character.isWhitespace(str.charAt(i)) == false)) {
                return false;
            }
        }
        return true;
    }
}
