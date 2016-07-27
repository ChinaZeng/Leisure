package com.zzw.MyApp.luck.constellation.view;

import com.zzw.MyApp.luck.constellation.model.ConstellationModel;

/**
 * Created by zzw on 2016/6/15.
 * 描述:
 */
public interface IConLuckView {
    void getConLuckDateResult(Boolean isSuccess,ConstellationModel constellationModel,String strMsg);
}
