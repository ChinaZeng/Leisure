package com.zzw.MyApp.life.longBusQuery.view;

import com.zzw.MyApp.life.longBusQuery.model.LongBusModel;

/**
 * Created by zzw on 2016/6/15.
 * 描述:
 */
public interface ILongBusView {

    void queryLongBusTimeResult(Boolean isSuccess, LongBusModel model, String strMsg);

}
