package com.zzw.MyApp.utils;

import android.content.Context;
import android.widget.Toast;

/**
 * Created by zzw on 2016/6/15.
 * 描述:
 */
public class ToastUtil {
    private static Toast mToast;

    public static void showToast(Context context, String msg) {

        if (msg == null)
            return;

        if (mToast == null) {
            mToast = Toast.makeText(context, msg, Toast.LENGTH_SHORT);
        } else {
            mToast.setText(msg);
            mToast.setDuration(Toast.LENGTH_SHORT);
        }
        mToast.show();
    }

    public static void showToast(Context context, int id) {
        if (id == 0)
            return;

        showToast(context, context.getString(id));
    }


    public static void cancelToast() {
        if (mToast != null) {
            mToast.cancel();
        }
    }

}
