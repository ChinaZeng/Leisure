package com.zzw.MyApp.history.view;

import android.support.v7.widget.RecyclerView;
import android.view.View;

import com.zzw.MyApp.base.BaseRecyAdapter;
import com.zzw.MyApp.history.model.HistoryDetailsModel;

/**
 * Created by zzw on 2016/7/1.
 * 描述:
 */
public interface IHistoryActivityView {
    void detailsHistoryResult(Boolean isSuccess, HistoryDetailsModel model, String strMsg);

    void addDataToRecyAdapterResult(RecyclerView.Adapter adapter);
}
