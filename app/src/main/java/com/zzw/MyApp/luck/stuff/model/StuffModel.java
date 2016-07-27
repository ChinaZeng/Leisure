package com.zzw.MyApp.luck.stuff.model;

import com.zzw.MyApp.entity.BaseEntity;

/**
 * Created by zzw on 2016/7/7.
 * 描述:
 */
public class StuffModel extends BaseEntity {


    /**
     * id : 5722
     * yangli : 2015-07-07
     * yinli : 乙未(羊)年五月廿二
     * wuxing : 井泉水 除执位
     * chongsha : 冲虎(戊寅)煞南
     * baiji : 甲不开仓财物耗散 申不安床鬼祟入房
     * jishen : 天德 月德 阳德 相日 除神 吉期 鸣犬 不将 司命 益后
     * yi : 嫁娶 祭祀 祈福 求嗣 开光 出火 拆卸 修造 动土 进人口 开市 交易 立券 挂匾 入宅 移徙 栽种 纳畜 入殓 启钻 除服 成服
     * xiongshen : 劫煞 天贼 五虚 八风 五离
     * ji :
     */

    private String id;
    private String yangli;
    private String yinli;
    private String wuxing;
    private String chongsha;
    private String baiji;
    private String jishen;
    private String yi;
    private String xiongshen;
    private String ji;

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getYangli() {
        return yangli;
    }

    public void setYangli(String yangli) {
        this.yangli = yangli;
    }

    public String getYinli() {
        return yinli;
    }

    public void setYinli(String yinli) {
        this.yinli = yinli;
    }

    public String getWuxing() {
        return wuxing;
    }

    public void setWuxing(String wuxing) {
        this.wuxing = wuxing;
    }

    public String getChongsha() {
        return chongsha;
    }

    public void setChongsha(String chongsha) {
        this.chongsha = chongsha;
    }

    public String getBaiji() {
        return baiji;
    }

    public void setBaiji(String baiji) {
        this.baiji = baiji;
    }

    public String getJishen() {
        return jishen;
    }

    public void setJishen(String jishen) {
        this.jishen = jishen;
    }

    public String getYi() {
        return yi;
    }

    public void setYi(String yi) {
        this.yi = yi;
    }

    public String getXiongshen() {
        return xiongshen;
    }

    public void setXiongshen(String xiongshen) {
        this.xiongshen = xiongshen;
    }

    public String getJi() {
        return ji;
    }

    public void setJi(String ji) {
        this.ji = ji;
    }
}
