package com.zzw.MyApp.history.presenter;

import android.app.Activity;

import com.zzw.MyApp.Constans;
import com.zzw.MyApp.history.adapter.HistoryActivityMidAdapter;
import com.zzw.MyApp.history.model.HistoryDetailsModel;
import com.zzw.MyApp.history.view.IHistoryActivityView;
import com.zzw.MyApp.operate.Net.NetRequestClass;
import com.zzw.MyApp.operate.Net.OnNetWortRequestListener;

import org.json.JSONArray;
import org.json.JSONObject;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by zzw on 2016/7/1.
 * 描述:
 */
public class IHistoryActivityPresentCompl implements IHistoryActivityPresent {

    private IHistoryActivityView iHistoryActivityView;

    public IHistoryActivityPresentCompl(IHistoryActivityView iHistoryActivityView) {
        this.iHistoryActivityView = iHistoryActivityView;
    }

    @Override
    public void getHistoryDetails(String e_id) {

        String url = "http://v.juhe.cn/todayOnhistory/queryDetail.php?e_id=" + e_id + "&key=" + Constans.HISTORY_APP_KEY;


        NetRequestClass.useRxVolleyGetUrl(url, new OnNetWortRequestListener() {
            @Override
            public void onSuccess(String url, String s) {
                iHistoryActivityView.detailsHistoryResult(true, getHistoryDetailsModelFromJson(s), null);
            }

            @Override
            public void onFailure(String url, String strMsg) {
                iHistoryActivityView.detailsHistoryResult(false, null, strMsg);
            }
        });
    }

    @Override
    public void addDateToRecyAdapter(Activity context, HistoryDetailsModel model) {
        HistoryActivityMidAdapter adapter = new HistoryActivityMidAdapter(model.getTitle(), context, model.getContent());
        adapter.addItems(model.getPicUrl());
        iHistoryActivityView.addDataToRecyAdapterResult(adapter);
    }


    private HistoryDetailsModel getHistoryDetailsModelFromJson(String json) {
        try {
            JSONObject jsonObject = new JSONObject(json);
            int error_code = jsonObject.getInt("error_code");
            if (error_code == 0) {
                JSONArray jsonArray = jsonObject.getJSONArray("result");
                if (jsonArray.length() > 0) {
                    JSONObject jsonObject1 = jsonArray.getJSONObject(0);
                    HistoryDetailsModel model = new HistoryDetailsModel();
                    model.setE_id(jsonObject1.getString("e_id"));
                    model.setTitle(jsonObject1.getString("title"));
                    model.setContent(jsonObject1.getString("content"));
                    model.setPicNo(jsonObject1.getString("picNo"));
                    JSONArray jsonArray1 = jsonObject1.getJSONArray("picUrl");
                    List<HistoryDetailsModel.PicUrlBean> picUrlBeans = new ArrayList<>();
                    for (int i = 0; i < jsonArray1.length(); i++) {
                        JSONObject jsonObject2 = jsonArray1.getJSONObject(i);
                        HistoryDetailsModel.PicUrlBean bean = new HistoryDetailsModel.PicUrlBean();
                        bean.setId(jsonObject2.getInt("id"));
                        bean.setPic_title(jsonObject2.getString("pic_title"));
                        bean.setUrl(jsonObject2.getString("url"));
                        picUrlBeans.add(bean);
                    }
                    model.setPicUrl(picUrlBeans);
                    return model;
                }
            }
            return null;
        } catch (Exception e) {
            return null;
        }
    }
}
