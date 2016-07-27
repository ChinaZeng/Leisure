package com.zzw.MyApp.operate.Net;


import com.kymjs.rxvolley.RxVolley;
import com.kymjs.rxvolley.client.HttpCallback;

/**
 * Created by zzw on 2016/7/5.
 * 描述:
 */
public class NetRequestClass {

    public static void useRxVolleyGetUrl(final String url, final OnNetWortRequestListener listener) {
        if (url == null || listener == null)
            return;
        RxVolley.get(url, new HttpCallback() {
            @Override
            public void onSuccess(String t) {
                super.onSuccess(t);
                listener.onSuccess(url, t);
            }

            @Override
            public void onFailure(int errorNo, String strMsg) {
                listener.onFailure(url, strMsg);
            }
        });
    }
}
