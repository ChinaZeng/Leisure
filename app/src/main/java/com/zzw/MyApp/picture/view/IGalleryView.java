package com.zzw.MyApp.picture.view;

import com.zzw.MyApp.picture.model.GalleryModel;

import java.util.List;

/**
 * Created by zzw on 2016/7/8.
 * 描述:
 */
public interface IGalleryView {

    void getGalleyModelListResult(Boolean isSuccess, List<GalleryModel> list, String str);

}
