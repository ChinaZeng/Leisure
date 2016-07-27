package com.zzw.MyApp.joke.view;

import com.zzw.MyApp.joke.model.JokeTextModel;

import java.util.List;

/**
 * Created by zzw on 2016/6/13.
 * 描述:
 */
public interface IJokeTextView {
    void addJokeTextList(Boolean isSuccess,List<JokeTextModel> list,String strMsg);
}
