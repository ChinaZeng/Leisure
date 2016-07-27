package com.zzw.MyApp.luck.duke.presenter;

import com.zzw.MyApp.Constans;
import com.zzw.MyApp.luck.duke.model.DuckLuckModel;
import com.zzw.MyApp.luck.duke.view.IDuckLuckView;
import com.zzw.MyApp.operate.Net.NetRequestClass;
import com.zzw.MyApp.operate.Net.OnNetWortRequestListener;
import com.zzw.MyApp.utils.StringUtils;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by zzw on 2016/6/15.
 * 描述:
 */
public class IDuckLuckPresenterCompl implements IDuckLuckPresenter {


    private IDuckLuckView iDuckLuckView;

    public IDuckLuckPresenterCompl(IDuckLuckView iDuckLuckView) {
        this.iDuckLuckView = iDuckLuckView;
    }

    @Override
    public void getDuckLuckModel(String str) {
        if (str == null)
            return;
        String url = "http://v.juhe.cn/dream/query?q=" + StringUtils.getUtf_8String(str)
                + "&cid=&full=1&key=" + Constans.DUCK_APP_KEY;

        NetRequestClass.useRxVolleyGetUrl(url, new OnNetWortRequestListener() {
            @Override
            public void onSuccess(String url, String s) {
                iDuckLuckView.getDuckLuckModelResult(true, getDuckModelFromJson(s), null);
            }

            @Override
            public void onFailure(String url, String strMsg) {
                iDuckLuckView.getDuckLuckModelResult(false, null, strMsg);
            }
        });
    }


    private List<DuckLuckModel> getDuckModelFromJson(String json) {
        try {
            List<DuckLuckModel> modes = null;
            JSONObject jsonObject = new JSONObject(json);
            int error_code = jsonObject.getInt("error_code");
            if (error_code == 0) {
                modes = new ArrayList<>();
                JSONArray jsonArray = jsonObject.getJSONArray("result");
                for (int i = 0; i < jsonArray.length(); i++) {
                    DuckLuckModel model = new DuckLuckModel();
                    JSONObject jsonObject1 = jsonArray.getJSONObject(i);
                    model.setId(jsonObject1.getString("id"));
                    model.setTitle(jsonObject1.getString("title"));
                    model.setDes(jsonObject1.getString("des"));
                    JSONArray jsonArray1 = jsonObject1.getJSONArray("list");
                    List<String> list = new ArrayList<>();
                    for (int j = 0; j < jsonArray1.length(); j++) {
                        list.add(jsonArray1.getString(j));
                    }
                    if (list.size() > 0) {
                        model.setList(list);
                        modes.add(model);
                    }
                }
            }
            return modes;

        } catch (JSONException e) {
            e.printStackTrace();
            return null;
        }
    }
}
