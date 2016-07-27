package com.zzw.MyApp.joke.model;

import com.zzw.MyApp.entity.BaseEntity;

/**
 * Created by zzw on 2016/6/13.
 * 描述:
 */
public class JokePicModel extends BaseEntity {


    /**
     * content : 大白天见鬼了
     * hashId : A863A6BD6B8AAAA9A6BDC27A7855D689
     * unixtime : 1465882393
     * updatetime : 2016-06-14 13:33:13
     * url : http://juheimg.oss-cn-hangzhou.aliyuncs.com/joke/201606/14/A863A6BD6B8AAAA9A6BDC27A7855D689.gif
     */

    private String content;
    private String hashId;
    private int unixtime;
    private String updatetime;
    private String url;

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

    public String getUrl() {
        return url;
    }

    public void setUrl(String url) {
        this.url = url;
    }

    @Override
    public String toString() {
        return "JokePicModel{" +
                "content='" + content + '\'' +
                ", hashId='" + hashId + '\'' +
                ", unixtime=" + unixtime +
                ", updatetime='" + updatetime + '\'' +
                ", url='" + url + '\'' +
                '}';
    }
}
