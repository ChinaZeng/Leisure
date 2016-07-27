package com.zzw.MyApp.luck.duke.model;

import com.zzw.MyApp.entity.BaseEntity;

import java.util.List;

/**
 * Created by zzw on 2016/7/7.
 * 描述:
 */
public class DuckLuckModel extends BaseEntity {

    /**
     * id : 2b1a12a98f719278090c9eb274f98330
     * title : 美女的穿着
     * des : 梦见穿连身的窄裙套装，你的性格可能是比较缺乏安全感，所以你潜意识中的美人模样，就是一副很能干、成熟稳重的样子。这可能和你从小对母亲印象的反射有关，或许你的母亲很能干，或许你的母爱不够，曾经在你的童年经验中，留下这种缺陷和不足，因为不足，所以会有需求的渴望，你的潜意识中才会梦到这种女人来给你安全感。
     * list : ["梦见穿连身的窄裙套装，你的性格可能是比较缺乏安全感，所以你潜意识中的美人模样，就是一副很能干、成熟稳重的样子。这可能和你从小对母亲印象的反射有关，或许你的母亲很能干，或许你的母爱不够，曾经在你的童年经验中，留下这种缺陷和不足，因为不足，所以会有需求的渴望，你的潜意识中才会梦到这种女人来给你安全感。","梦见穿长裙和长袖衣服，你喜欢的女孩是属于文静、有气质型的，这也暗示你在现实世界经常得不到这类女孩子的青睐，这点是让你很难过的。你可能在个性上有点大男人主义，不然就是喜欢保护弱小，有英雄的形象渴望。可能"]
     */

    private String id;
    private String title;
    private String des;
    private List<String> list;

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getDes() {
        return des;
    }

    public void setDes(String des) {
        this.des = des;
    }

    public List<String> getList() {
        return list;
    }

    public void setList(List<String> list) {
        this.list = list;
    }
}
