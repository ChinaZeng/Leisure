package com.zzw.MyApp.history.model;

import com.zzw.MyApp.entity.BaseEntity;

/**
 * Created by zzw on 2016/6/30.
 * 描述:
 */
public class HistoryModel extends BaseEntity {


    /**
     * day : 5/1
     * date : 560年05月01日
     * title : 高长恭受封兰陵王
     * e_id : 5179
     */

    private String day;
    private String date;
    private String title;
    private String e_id;

    public String getDay() {
        return day;
    }

    public void setDay(String day) {
        this.day = day;
    }

    public String getDate() {
        return date;
    }

    public void setDate(String date) {
        this.date = date;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getE_id() {
        return e_id;
    }

    public void setE_id(String e_id) {
        this.e_id = e_id;
    }

    @Override
    public String toString() {
        return "HistoryModel{" +
                "day='" + day + '\'' +
                ", date='" + date + '\'' +
                ", title='" + title + '\'' +
                ", e_id='" + e_id + '\'' +
                '}';
    }
}
