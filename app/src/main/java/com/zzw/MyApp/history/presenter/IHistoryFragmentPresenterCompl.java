package com.zzw.MyApp.history.presenter;

import com.zzw.MyApp.Constans;
import com.zzw.MyApp.history.model.HistoryModel;
import com.zzw.MyApp.history.view.IHistoryFragmentView;
import com.zzw.MyApp.operate.Net.NetRequestClass;
import com.zzw.MyApp.operate.Net.OnNetWortRequestListener;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by zzw on 2016/6/30.
 * 描述:
 */
public class IHistoryFragmentPresenterCompl implements IHistoryFragmentPresenter {

    private IHistoryFragmentView iHistoryFragmentView;

    public IHistoryFragmentPresenterCompl(IHistoryFragmentView iHistoryFragmentView) {
        this.iHistoryFragmentView = iHistoryFragmentView;
    }

    @Override
    public void getHistoryList(String date) {
        if (date == null)
            return;

        String[] s = date.split("/");
        if (s.length < 2)
            return;
        String rootUrl = "http://v.juhe.cn/todayOnhistory/queryEvent.php";
        String url = rootUrl + "?date=" + s[0] + "%2F" + s[1] + "&key=" + Constans.HISTORY_APP_KEY;

        NetRequestClass.useRxVolleyGetUrl(url, new OnNetWortRequestListener() {
            @Override
            public void onSuccess(String url, String s) {
                iHistoryFragmentView.historyListResult(true, getHistoryModelListFromJson(s), null);
            }

            @Override
            public void onFailure(String url, String strMsg) {
                iHistoryFragmentView.historyListResult(false, null, strMsg);

            }
        });
    }

    private List<HistoryModel> getHistoryModelListFromJson(String json) {
        List<HistoryModel> historyModels = null;

        try {
            JSONObject jsonObject = new JSONObject(json);
            int error_code = jsonObject.getInt("error_code");
            if (error_code == 0) {
                historyModels = new ArrayList<>();
                JSONArray jsonArray = jsonObject.getJSONArray("result");
                for (int i = 0; i < jsonArray.length(); i++) {
                    JSONObject jsonObject1 = jsonArray.getJSONObject(i);
                    HistoryModel model = new HistoryModel();
                    model.setTitle(jsonObject1.getString("title"));
                    model.setDate(jsonObject1.getString("date"));
                    model.setDay(jsonObject1.getString("day"));
                    model.setE_id(jsonObject1.getString("e_id"));
                    historyModels.add(0, model);
                }
                return historyModels;
            } else {
                return null;
            }

        } catch (JSONException e) {
            e.printStackTrace();
            return null;
        }
    }
}
