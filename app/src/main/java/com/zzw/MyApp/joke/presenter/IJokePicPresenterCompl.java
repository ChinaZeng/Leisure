package com.zzw.MyApp.joke.presenter;

import com.zzw.MyApp.Constans;
import com.zzw.MyApp.operate.Net.NetRequestClass;
import com.zzw.MyApp.joke.model.JokePicModel;
import com.zzw.MyApp.joke.view.IJokePicView;
import com.zzw.MyApp.operate.Net.OnNetWortRequestListener;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by zzw on 2016/6/13.
 * 描述:
 */
public class IJokePicPresenterCompl implements IJokePicPresenter {

    private IJokePicView iJokePicView;

    public IJokePicPresenterCompl(IJokePicView iJokePicView) {
        this.iJokePicView = iJokePicView;
    }

    @Override
    public void reqJokePic(int page, int pageSize) {
        String rootUrl = "http://japi.juhe.cn/joke/img/text.from";
        int page1 = page < 1 ? 1 : page;
        int pageSize1 = pageSize < 1 || pageSize > 20 ? 1 : pageSize;
        String url = rootUrl + "?page=" + page1 + "&pagesize=" + pageSize1 + "&key=" + Constans.JOKE_APP_KEY;


        NetRequestClass.useRxVolleyGetUrl(url, new OnNetWortRequestListener() {
            @Override
            public void onSuccess(String url, String s) {
                iJokePicView.addJokePicList(true, getJokePicModelListFromJson(s), null);
            }

            @Override
            public void onFailure(String url, String strMsg) {
                iJokePicView.addJokePicList(false, null, strMsg);
            }
        });
    }

    private List<JokePicModel> getJokePicModelListFromJson(String json) {
        try {
            JSONObject jsonObject = new JSONObject(json);
            int error_code = jsonObject.getInt("error_code");
            if (error_code == 0) {
                JSONObject jsonObject1 = jsonObject.getJSONObject("result");
                JSONArray jsonArray = jsonObject1.getJSONArray("data");
                List<JokePicModel> jokePicModelList = new ArrayList<>();
                for (int i = 0; i < jsonArray.length(); i++) {
                    JSONObject jsonObject2 = jsonArray.getJSONObject(i);
                    JokePicModel jokePicModel = new JokePicModel();
                    jokePicModel.setContent(jsonObject2.getString("content"));
                    jokePicModel.setHashId(jsonObject2.getString("hashId"));
                    jokePicModel.setUnixtime(jsonObject2.getInt("unixtime"));
                    jokePicModel.setUpdatetime(jsonObject2.getString("updatetime"));
                    jokePicModel.setUrl(jsonObject2.getString("url"));
                    jokePicModelList.add(jokePicModel);
                }
                return jokePicModelList;
            } else {
                return null;
            }
        } catch (JSONException e) {
            e.printStackTrace();
            return null;
        }
    }
}
