package com.zzw.MyApp.picture.presenter;

/**
 * Created by zzw on 2016/7/8.
 * 描述:
 */
public interface IGalleryPresenter {
    /**
     * @param id 分类id
     * @param page 页
     * @param rows 每页多少
     */
    void getGallery(int id,int page, int rows);
}
