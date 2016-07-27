package com.zzw.MyApp.news.view;

import com.zzw.MyApp.news.model.NewsModel;

import java.util.List;

/**
 * Created by zzw on 2016/6/12.
 * 描述:
 */
public interface INewsView {
    void resultMsg(Boolean isSuccess, List<NewsModel> newsModelList, String errorMsg);
}
