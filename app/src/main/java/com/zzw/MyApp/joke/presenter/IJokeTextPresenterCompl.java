package com.zzw.MyApp.joke.presenter;

import com.zzw.MyApp.Constans;
import com.zzw.MyApp.operate.Net.NetRequestClass;
import com.zzw.MyApp.joke.model.JokeTextModel;
import com.zzw.MyApp.joke.view.IJokeTextView;
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
public class IJokeTextPresenterCompl implements IJokeTextPresenter {

    private IJokeTextView iJokeTextView;


    public IJokeTextPresenterCompl(IJokeTextView iJokeTextView) {
        this.iJokeTextView = iJokeTextView;
    }

    @Override
    public void reqJokeText(int page, int pageSize) {
        String rootUrl = "http://japi.juhe.cn/joke/content/text.from";
        int page1 = page < 1 ? 1 : page;
        int pageSize1 = pageSize < 1 || pageSize > 20 ? 1 : pageSize;
        String url = rootUrl + "?page=" + page1 + "&pagesize=" + pageSize1 + "&key=" + Constans.JOKE_APP_KEY;

        NetRequestClass.useRxVolleyGetUrl(url, new OnNetWortRequestListener() {
            @Override
            public void onSuccess(String url, String s) {
                iJokeTextView.addJokeTextList(true, getJokeTextModelListFromJson(s), null);
            }

            @Override
            public void onFailure(String url, String strMsg) {
                iJokeTextView.addJokeTextList(false, null, strMsg);
            }
        });
    }


    private List<JokeTextModel> getJokeTextModelListFromJson(String json) {
        try {
            JSONObject jsonObject = new JSONObject(json);
            int error_code = jsonObject.getInt("error_code");
            if (error_code == 0) {
                JSONObject jsonObject1 = jsonObject.getJSONObject("result");
                JSONArray jsonArray = jsonObject1.getJSONArray("data");
                List<JokeTextModel> jokeTextModelList = new ArrayList<>();
                for (int i = 0; i < jsonArray.length(); i++) {
                    JSONObject jsonObject2 = jsonArray.getJSONObject(i);
                    JokeTextModel jokeTextModel = new JokeTextModel();
                    jokeTextModel.setContent(jsonObject2.getString("content"));
                    jokeTextModel.setHashId(jsonObject2.getString("hashId"));
                    jokeTextModel.setUnixtime(jsonObject2.getInt("unixtime"));
                    jokeTextModel.setUpdatetime(jsonObject2.getString("updatetime"));
                    jokeTextModelList.add(jokeTextModel);
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
