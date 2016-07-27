package com.zzw.MyApp.news.presenter;

/**
 * Created by zzw on 2016/6/12.
 * 描述:
 */
public interface INewsPresenter {
    /**
     * @param pno 当前页数，默认1
     * @param ps  每页返回条数，最大100，默认20
     */
    void doRequestNews(int pno, int ps);
}
