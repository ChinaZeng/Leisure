package com.zzw.MyApp.luck.stuff.presenter;

import com.zzw.MyApp.Constans;
import com.zzw.MyApp.luck.stuff.model.StuffHourModel;
import com.zzw.MyApp.luck.stuff.view.IStuffHourLuckView;
import com.zzw.MyApp.operate.Net.NetRequestClass;
import com.zzw.MyApp.operate.Net.OnNetWortRequestListener;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by zzw on 2016/6/15.
 * 描述:
 */
public class IStuffHourLuckPresenterCompl implements IStuffHourLuckPresenter {

    private IStuffHourLuckView iStuffHourLuckPresenter;

    public IStuffHourLuckPresenterCompl(IStuffHourLuckView iStuffHourLuckPresenter) {
        this.iStuffHourLuckPresenter = iStuffHourLuckPresenter;
    }

    @Override
    public void getStuffHourData(String date) {
        String url = "http://v.juhe.cn/laohuangli/h?date=" + date + "&&key=" + Constans.STUFF_APP_KEY;
        NetRequestClass.useRxVolleyGetUrl(url, new OnNetWortRequestListener() {
            @Override
            public void onSuccess(String url, String s) {
                iStuffHourLuckPresenter.getStuffDataResult(true, getStuffHourModeListFromJson(s), null);
            }

            @Override
            public void onFailure(String url, String strMsg) {
                iStuffHourLuckPresenter.getStuffDataResult(false, null, strMsg);
            }
        });


    }

    private List<StuffHourModel> getStuffHourModeListFromJson(String json) {

        try {
            List<StuffHourModel> models = null;
            JSONObject jsonObject = new JSONObject(json);
            int error_code = jsonObject.getInt("error_code");
            if (error_code == 0) {
                models = new ArrayList<>();
                JSONArray jsonArray = jsonObject.getJSONArray("result");
                for (int i = 0; i < jsonArray.length(); i++) {
                    JSONObject jsonObject1 = jsonArray.getJSONObject(i);
                    StuffHourModel model = new StuffHourModel();
                    model.setYangli(jsonObject1.getString("yangli"));
                    model.setYi(jsonObject1.getString("yi"));
                    model.setJi(jsonObject1.getString("ji"));
                    model.setDes(jsonObject1.getString("des"));
                    model.setHours(jsonObject1.getString("hours"));
                    models.add(model);
                }
            }
            return models;
        } catch (JSONException e) {
            e.printStackTrace();
            return null;
        }


    }
}
