package com.zzw.MyApp.picture.model;

import com.zzw.MyApp.entity.BaseEntity;

/**
 * Created by zzw on 2016/7/8.
 * 描述:
 */
public class GalleryModel extends BaseEntity {

    /**
     * count : 55
     * fcount : 0
     * galleryclass : 5
     * id : 746
     * img : /ext/160707/ba5af19d3145a961e1b68042e5065961.jpg
     * rcount : 0
     * size : 3
     * time : 1467902286000
     * title : 眼睛美女 比基尼美女私房自拍照
     */

    private int count;//访问数
    private int fcount;//收藏数
    private int galleryclass;//分类
    private int id;//图库ID编码，
    private String img;//图片简介
    private int rcount;//评论数
    private int size;//图片多少张
    private long time;//发布时间
    private String title;//标题，信息标题

    public int getCount() {
        return count;
    }

    public void setCount(int count) {
        this.count = count;
    }

    public int getFcount() {
        return fcount;
    }

    public void setFcount(int fcount) {
        this.fcount = fcount;
    }

    public int getGalleryclass() {
        return galleryclass;
    }

    public void setGalleryclass(int galleryclass) {
        this.galleryclass = galleryclass;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getImg() {
        return img;
    }

    public void setImg(String img) {
        this.img = img;
    }

    public int getRcount() {
        return rcount;
    }

    public void setRcount(int rcount) {
        this.rcount = rcount;
    }

    public int getSize() {
        return size;
    }

    public void setSize(int size) {
        this.size = size;
    }

    public long getTime() {
        return time;
    }

    public void setTime(long time) {
        this.time = time;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }


    @Override
    public String toString() {
        return "GalleryModel{" +
                "count=" + count +
                ", fcount=" + fcount +
                ", galleryclass=" + galleryclass +
                ", id=" + id +
                ", img='" + img + '\'' +
                ", rcount=" + rcount +
                ", size=" + size +
                ", time=" + time +
                ", title='" + title + '\'' +
                '}';
    }
}
