package com.zzw.MyApp.history.presenter;

import android.app.Activity;
import android.content.Context;

import com.zzw.MyApp.history.model.HistoryDetailsModel;

/**
 * Created by zzw on 2016/7/1.
 * 描述:
 */
public interface IHistoryActivityPresent {
    /**
     * 根据ID得到历史细节
     *
     * @param e_id
     */
    void getHistoryDetails(String e_id);


    void addDateToRecyAdapter(Activity context, HistoryDetailsModel model);

}
