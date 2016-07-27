package com.zzw.MyApp.history.presenter;

/**
 * Created by zzw on 2016/6/30.
 * 描述:
 */
public interface IHistoryFragmentPresenter {
    /**
     * @param data 日期,格式:月/日 如:1/1,/10/1,12/12 如月或者日小于10,前面无需加0
     */
    void getHistoryList(String data);
}
