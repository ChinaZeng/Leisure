package com.zzw.MyApp.luck.stuff.view;

import com.zzw.MyApp.luck.stuff.model.StuffHourModel;
import com.zzw.MyApp.luck.stuff.model.StuffModel;

import java.util.List;

/**
 * Created by zzw on 2016/6/15.
 * 描述:
 */
public interface IStuffHourLuckView {

    void getStuffDataResult(Boolean isSuccess, List<StuffHourModel> list, String strMsg);

}
