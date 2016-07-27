package com.zzw.MyApp.luck.constellation.presenter;

/**
 * Created by zzw on 2016/6/15.
 * 描述:
 */
public interface IConLuckPresenter {

    interface ConLuckType {
      String TODAY = "today";
      String TOMORROW = "tomorrow";
      String WEEK = "week";
      String NEXTWEEK = "nextweek";
      String MONTH = "month";
      String YEAR = "year";
    }

      void  getConLuckDate(String consName, String type);
}
