package com.zzw.MyApp.operate.Net;

/**
 * Created by zzw on 2016/7/5.
 * 描述:
 */
public interface OnNetWortRequestListener {
    void onSuccess(String url, String s);

    void onFailure(String url, String strMsg);
}
