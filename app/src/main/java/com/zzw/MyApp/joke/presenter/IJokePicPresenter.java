package com.zzw.MyApp.joke.presenter;

/**
 * Created by zzw on 2016/6/13.
 * 描述:
 */
public interface IJokePicPresenter {
    /**
     * @param page     当前页数,默认1
     * @param pageSize 每次返回条数,默认1,最大20
     */
    void reqJokePic(int page, int pageSize);
}
