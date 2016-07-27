package com.zzw.MyApp.picture.model;

import com.zzw.MyApp.entity.BaseEntity;

/**
 * Created by zzw on 2016/7/8.
 * 描述:
 */
public class GalleryClassModel extends BaseEntity {


    private String title;
    private int id;
    private int srcId;


    public GalleryClassModel(String title, int id, int srcId) {
        this.title = title;
        this.id = id;
        this.srcId = srcId;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public int getSrcId() {
        return srcId;
    }

    public void setSrcId(int srcId) {
        this.srcId = srcId;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }
}
