package com.zzw.MyApp.life.longBusQuery.presenter;

import com.zzw.MyApp.Constans;
import com.zzw.MyApp.life.longBusQuery.model.LongBusModel;
import com.zzw.MyApp.life.longBusQuery.view.ILongBusView;
import com.zzw.MyApp.operate.Net.NetRequestClass;
import com.zzw.MyApp.operate.Net.OnNetWortRequestListener;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import java.util.LinkedList;
import java.util.List;

/**
 * Created by zzw on 2016/6/15.
 * 描述:
 */
public class ILongBusPresenterCompl implements ILongBusPresenter {

    private ILongBusView iLongBusView;

    public ILongBusPresenterCompl(ILongBusView iLongBusView) {
        this.iLongBusView = iLongBusView;
    }

    @Override
    public void queryLongBusTime(String fromCity, String toCity) {

        String url = "http://op.juhe.cn/onebox/bus/query_ab" + "?from=" + fromCity + "&to="
                + toCity + "&key=" + Constans.LONG_BUS_APP_KEY;
        NetRequestClass.useRxVolleyGetUrl(url, new OnNetWortRequestListener() {
            @Override
            public void onSuccess(String url, String s) {
                iLongBusView.queryLongBusTimeResult(true, getLongBusModelFromJson(s), null);
            }

            @Override
            public void onFailure(String url, String strMsg) {
                iLongBusView.queryLongBusTimeResult(false, null, strMsg);
            }
        });
    }


    private LongBusModel getLongBusModelFromJson(String json) {
        LongBusModel model = null;
        try {
            JSONObject jsonObject = new JSONObject(json);
            int error_code = jsonObject.getInt("error_code");
            if (error_code == 0) {
                model = new LongBusModel();
                JSONObject result = jsonObject.getJSONObject("result");
                model.setTitle(result.getString("title"));
                JSONArray list = result.getJSONArray("list");
                List<LongBusModel.ListBean> listBeans = new LinkedList<>();
                for (int i = 0; i < list.length(); i++) {
                    JSONObject jsonObject1 = list.getJSONObject(i);
                    LongBusModel.ListBean bean = new LongBusModel.ListBean();
                    bean.setArrive(jsonObject1.getString("arrive"));
                    bean.setStart(jsonObject1.getString("start"));
                    bean.setDate(jsonObject1.getString("date"));
                    bean.setPrice(jsonObject1.getString("price"));
                    listBeans.add(bean);
                }
                model.setList(listBeans);
            } else {
                iLongBusView.queryLongBusTimeResult(false, null, jsonObject.getString("reason"));
            }
        } catch (JSONException e) {
            e.printStackTrace();
            return null;
        }

        return model;
    }
}
