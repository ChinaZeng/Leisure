package com.zzw.MyApp;

import android.os.Handler;
import android.os.Looper;

import com.zzw.MyApp.base.BaseApplication;

/**
 * Created by zzw on 2016/6/15.
 * 描述:
 */
public class MyApplication extends BaseApplication {

    private static MyApplication application;
    private static Handler mHandler;

    @Override
    public void onCreate() {
        super.onCreate();
        application = this;
    }

    public static MyApplication getIntstance() {
        return application;
    }

    public static Handler getHandler() {
        if (mHandler == null) {
            mHandler = new Handler(Looper.getMainLooper());
        }
        return mHandler;
    }

}
