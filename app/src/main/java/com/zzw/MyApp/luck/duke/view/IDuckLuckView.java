package com.zzw.MyApp.luck.duke.view;

import com.zzw.MyApp.luck.duke.model.DuckLuckModel;

import java.util.List;

/**
 * Created by zzw on 2016/6/15.
 * 描述:
 */
public interface IDuckLuckView {
    void getDuckLuckModelResult(Boolean isSuccess, List<DuckLuckModel> models, String strMsg);
}
