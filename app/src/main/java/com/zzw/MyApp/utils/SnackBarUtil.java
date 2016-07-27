package com.zzw.MyApp.utils;

import android.support.design.widget.Snackbar;
import android.view.View;

/**
 * Created by zzw on 2016/6/12.
 * 描述:
 */
public class SnackBarUtil {

    public static void showSnackBar(View view, String msg) {
        if (msg == null)
            return;
        Snackbar.make(view, msg, Snackbar.LENGTH_SHORT).show();
    }

    public static void showSnackBar(View view, int resId) {
        if (resId == 0)
            return;
        showSnackBar(view, view.getContext().getResources().getString(resId));
    }


    public static void showSnackBar(View view, String msg, String actionName, View.OnClickListener listener) {
        if (msg == null)
            return;
        Snackbar.make(view, msg, Snackbar.LENGTH_SHORT).setAction(actionName, listener).show();
    }


    public static void showSnackBar(View view, int resId, int actionId, View.OnClickListener listener) {
        if (resId == 0)
            return;
        showSnackBar(view, view.getContext().getResources().getString(resId), view.getContext()
                .getResources().getString(actionId), listener);
    }

}
