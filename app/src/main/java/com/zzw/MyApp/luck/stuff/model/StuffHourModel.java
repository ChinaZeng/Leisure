package com.zzw.MyApp.luck.stuff.model;

import com.zzw.MyApp.entity.BaseEntity;

/**
 * Created by zzw on 2016/7/7.
 * 描述:
 */
public class StuffHourModel extends BaseEntity {


    /**
     * yangli : 2014-09-09
     * hours : 1-3
     * des : 冲猴 煞北 时冲戊申 天贼 进贵 福德 金匮
     * yi : 日时相冲 诸事不宜
     * ji :
     */

    private String yangli;
    private String hours;
    private String des;
    private String yi;
    private String ji;

    public String getYangli() {
        return yangli;
    }

    public void setYangli(String yangli) {
        this.yangli = yangli;
    }

    public String getHours() {
        return hours;
    }

    public void setHours(String hours) {
        this.hours = hours;
    }

    public String getDes() {
        return des;
    }

    public void setDes(String des) {
        this.des = des;
    }

    public String getYi() {
        return yi;
    }

    public void setYi(String yi) {
        this.yi = yi;
    }

    public String getJi() {
        return ji;
    }

    public void setJi(String ji) {
        this.ji = ji;
    }
}
