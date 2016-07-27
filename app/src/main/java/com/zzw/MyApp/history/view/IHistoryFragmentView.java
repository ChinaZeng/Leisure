package com.zzw.MyApp.history.view;

import com.zzw.MyApp.history.model.HistoryModel;

import java.util.List;

/**
 * Created by zzw on 2016/6/30.
 * 描述:
 */
public interface IHistoryFragmentView {
    void historyListResult(Boolean isSuccess,List<HistoryModel> historyModelList,String strMsg);
}
