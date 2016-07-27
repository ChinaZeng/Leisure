package com.zzw.MyApp.news.presenter;


import com.zzw.MyApp.Constans;
import com.zzw.MyApp.operate.Net.NetRequestClass;
import com.zzw.MyApp.operate.Net.OnNetWortRequestListener;
import com.zzw.MyApp.news.model.NewsModel;
import com.zzw.MyApp.news.view.INewsView;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by zzw on 2016/6/12.
 * 描述:
 */
public class INewsPresenterCompl implements INewsPresenter {

    INewsView iNewsView;

    public INewsPresenterCompl(INewsView iNewsView) {
        this.iNewsView = iNewsView;
    }


    @Override
    public void doRequestNews(int pno, int ps) {
        String rootUrl = "http://v.juhe.cn/weixin/query";
        int pno1 = pno < 0 ? 1 : pno;
        int ps1 = ps < 20 || ps > 100 ? 20 : ps;
        String url = rootUrl + "?pno=" + pno1 + "&ps=" + ps1 + "&dtype=json&key=" + Constans.NEWS_APP_KEY;
        NetRequestClass.useRxVolleyGetUrl(url, new OnNetWortRequestListener() {
            @Override
            public void onSuccess(String url, String s) {
                iNewsView.resultMsg(true, getNewsModelListFromJson(s), null);
            }

            @Override
            public void onFailure(String url, String strMsg) {
                iNewsView.resultMsg(false, null, strMsg);
            }
        });
    }

    private List<NewsModel> getNewsModelListFromJson(String json) {
        try {
            JSONObject jsonObject = new JSONObject(json);
            int error_code = jsonObject.getInt("error_code");
            if (error_code == 0) {
                JSONObject jsonObject1 = jsonObject.getJSONObject("result");
                JSONArray jsonArray = jsonObject1.getJSONArray("list");
                List<NewsModel> jokeTextModelList = new ArrayList<>();
                for (int i = 0; i < jsonArray.length(); i++) {
                    JSONObject jsonObject2 = jsonArray.getJSONObject(i);
                    NewsModel newsModel = new NewsModel();
                    newsModel.setUrl(jsonObject2.getString("url"));
                    newsModel.setFirstImg(jsonObject2.getString("firstImg"));
                    newsModel.setId(jsonObject2.getString("id"));
                    newsModel.setMark(jsonObject2.getString("mark"));
                    newsModel.setSource(jsonObject2.getString("source"));
                    newsModel.setTitle(jsonObject2.getString("title"));
                    jokeTextModelList.add(newsModel);
                }
                return jokeTextModelList;
            } else {
                return null;
            }
        } catch (JSONException e) {
            e.printStackTrace();
            return null;
        }
    }
}
