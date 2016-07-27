package com.zzw.MyApp.news.model;

import com.zzw.MyApp.entity.BaseEntity;

/**
 * Created by zzw on 2016/6/15.
 * 描述:
 */
public class NewsModel extends BaseEntity{


    /**
     * firstImg :
     * id : wechat_20160615022908
     * source : 互联网思维
     * title : 京东回应“卖假鞋年销超两万双”：早已下架相关店铺商品
     * url : http://v.juhe.cn/weixin/redirect?wid=wechat_20160615022908
     * mark :
     */

    private String firstImg;
    private String id;
    private String source;
    private String title;
    private String url;
    private String mark;

    public String getFirstImg() {
        return firstImg;
    }

    public void setFirstImg(String firstImg) {
        this.firstImg = firstImg;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getSource() {
        return source;
    }

    public void setSource(String source) {
        this.source = source;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getUrl() {
        return url;
    }

    public void setUrl(String url) {
        this.url = url;
    }

    public String getMark() {
        return mark;
    }

    public void setMark(String mark) {
        this.mark = mark;
    }
}
