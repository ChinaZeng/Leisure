package com.zzw.MyApp.joke.view;

import com.zzw.MyApp.joke.model.JokePicModel;

import java.util.List;

/**
 * Created by zzw on 2016/6/13.
 * 描述:
 */
public interface IJokePicView {
    void addJokePicList(boolean isSuccess, List<JokePicModel> list, String errorMsg);
}
