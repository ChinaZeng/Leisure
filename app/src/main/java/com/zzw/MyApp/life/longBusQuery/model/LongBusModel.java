package com.zzw.MyApp.life.longBusQuery.model;

import com.zzw.MyApp.entity.BaseEntity;

import java.util.List;

/**
 * Created by zzw on 2016/7/5.
 * 描述:
 */
public class LongBusModel extends BaseEntity {


    /**
     * title : 成都到会东_汽车时刻及票价查询
     * list : [{"start":"石羊场车站","arrive":"会东","date":"10:30","price":"203元"},{"start":"石羊场车站","arrive":"会东","date":"10:40","price":"203元"}]
     */

    private String title;
    /**
     * start : 石羊场车站
     * arrive : 会东
     * date : 10:30
     * price : 203元
     */

    private List<ListBean> list;

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public List<ListBean> getList() {
        return list;
    }

    public void setList(List<ListBean> list) {
        this.list = list;
    }

    public static class ListBean {
        private String start;
        private String arrive;
        private String date;
        private String price;

        @Override
        public String toString() {
            return "ListBean{" +
                    "start='" + start + '\'' +
                    ", arrive='" + arrive + '\'' +
                    ", date='" + date + '\'' +
                    ", price='" + price + '\'' +
                    '}';
        }

        public String getStart() {
            return start;
        }


        public void setStart(String start) {
            this.start = start;
        }

        public String getArrive() {
            return arrive;
        }

        public void setArrive(String arrive) {
            this.arrive = arrive;
        }

        public String getDate() {
            return date;
        }

        public void setDate(String date) {
            this.date = date;
        }

        public String getPrice() {
            return price;
        }

        public void setPrice(String price) {
            this.price = price;
        }
    }
}
