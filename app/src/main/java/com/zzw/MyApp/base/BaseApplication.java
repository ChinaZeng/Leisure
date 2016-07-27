package com.zzw.MyApp.base;

import android.app.Application;

import com.umeng.analytics.AnalyticsConfig;
import com.umeng.analytics.MobclickAgent;


/**
 * Created by zzw on 2016/6/15.
 * 描述:
 */
public class BaseApplication extends Application {

    @Override
    public void onCreate() {
        super.onCreate();
        initUmeng();
    }

    private void initUmeng() {
        //------------------友盟统计----------------------
        MobclickAgent.setScenarioType(this, MobclickAgent.EScenarioType.E_UM_NORMAL);
        //禁止默认的页面统计方式
        MobclickAgent.openActivityDurationTrack(false);
        //捕获程序崩溃日志
        MobclickAgent.setCatchUncaughtExceptions(true);
    }

}
