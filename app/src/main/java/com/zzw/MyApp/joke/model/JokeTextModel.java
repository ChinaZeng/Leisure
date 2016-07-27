package com.zzw.MyApp.joke.model;

import com.zzw.MyApp.entity.BaseEntity;

/**
 * Created by zzw on 2016/6/13.
 * 描述:
 */
public class JokeTextModel extends BaseEntity {


    /**
     * content : 载女神出去玩，走到一个荒无人烟的地方，
     女神:“我...我想尿尿，”
     我:“这里没有厕所呀。”
     女神:“你想办法，快！”
     我:“要不这样吧，我把车停下，你去车后面尿，
     我不下车，这里又没有别人。”　啪，我的脸。
     女神:“你个流氓，你是想用倒车影像偷看吧？”
     囧，“我。。。我一个破电动三轮，连倒档都没有，哪来的倒车影像？”
     * hashId : ef596cc9b44c413ff9f129fcccb5c9c0
     * unixtime : 1418814836
     * updatetime : 2014-12-17 19:13:56
     */

    private String content;
    private String hashId;
    private int unixtime;
    private String updatetime;

    public String getContent() {
        return content;
    }

    public void setContent(String content) {
        this.content = content;
    }

    public String getHashId() {
        return hashId;
    }

    public void setHashId(String hashId) {
        this.hashId = hashId;
    }

    public int getUnixtime() {
        return unixtime;
    }

    public void setUnixtime(int unixtime) {
        this.unixtime = unixtime;
    }

    public String getUpdatetime() {
        return updatetime;
    }

    public void setUpdatetime(String updatetime) {
        this.updatetime = updatetime;
    }
}
