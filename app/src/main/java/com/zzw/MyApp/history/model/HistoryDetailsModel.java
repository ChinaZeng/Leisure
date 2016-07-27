package com.zzw.MyApp.history.model;

import com.zzw.MyApp.entity.BaseEntity;

import java.util.List;

/**
 * Created by zzw on 2016/7/1.
 * 描述:
 */
public class HistoryDetailsModel extends BaseEntity {


    /**
     * e_id : 6347
     * title : 牙买加博尔特打破了男子100米的世界纪录
     * content :     2008年5月31日 (农历四月廿七)，牙买加博尔特打破了男子100米的世界纪录。
     * 2008年5月31日晚，年仅21岁的牙买加选手博尔特在美国纽约举行的锐步田径大奖赛以9秒72的成绩打破了男子100米的世界纪录。此前的纪录为博尔特的牙买加同胞鲍威尔去年创造，这次比赛他因故缺席。图为博尔特（左一）在比赛中冲过终点的一瞬间。
     * <p>
     * <p>
     * picNo : 1
     * picUrl : [{"pic_title":"","id":1,"url":"http://images.juheapi.com/history/6347_1.jpg"}]
     */

    private String e_id;
    private String title;
    private String content;
    private String picNo;
    /**
     * pic_title :
     * id : 1
     * url : http://images.juheapi.com/history/6347_1.jpg
     */

    private List<PicUrlBean> picUrl;

    public String getE_id() {
        return e_id;
    }

    public void setE_id(String e_id) {
        this.e_id = e_id;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getContent() {
        return content;
    }

    public void setContent(String content) {
        this.content = content;
    }

    public String getPicNo() {
        return picNo;
    }

    public void setPicNo(String picNo) {
        this.picNo = picNo;
    }

    public List<PicUrlBean> getPicUrl() {
        return picUrl;
    }

    public void setPicUrl(List<PicUrlBean> picUrl) {
        this.picUrl = picUrl;
    }

    public static class PicUrlBean {
        private String pic_title;
        private int id;
        private String url;

        public String getPic_title() {
            return pic_title;
        }

        public void setPic_title(String pic_title) {
            this.pic_title = pic_title;
        }

        public int getId() {
            return id;
        }

        public void setId(int id) {
            this.id = id;
        }

        public String getUrl() {
            return url;
        }

        public void setUrl(String url) {
            this.url = url;
        }

    }
}
