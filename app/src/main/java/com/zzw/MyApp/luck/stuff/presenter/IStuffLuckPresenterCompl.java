package com.zzw.MyApp.luck.stuff.presenter;

import com.zzw.MyApp.Constans;
import com.zzw.MyApp.luck.stuff.model.StuffModel;
import com.zzw.MyApp.luck.stuff.view.IStuffLuckView;
import com.zzw.MyApp.operate.Net.NetRequestClass;
import com.zzw.MyApp.operate.Net.OnNetWortRequestListener;

import org.json.JSONException;
import org.json.JSONObject;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by zzw on 2016/6/15.
 * 描述:
 */
public class IStuffLuckPresenterCompl implements IStuffLuckPresenter {

    private IStuffLuckView iStuffLuckView;

    public IStuffLuckPresenterCompl(IStuffLuckView iStuffLuckView) {
        this.iStuffLuckView = iStuffLuckView;
    }

    @Override
    public void getStuffData(String date) {
        String url = "http://v.juhe.cn/laohuangli/d?date=" + date + "&&key=" + Constans.STUFF_APP_KEY;

        NetRequestClass.useRxVolleyGetUrl(url, new OnNetWortRequestListener() {
            @Override
            public void onSuccess(String url, String s) {
                iStuffLuckView.getStuffDataResult(true, getStuffModeListFromJson(s), null);
            }

            @Override
            public void onFailure(String url, String strMsg) {
                iStuffLuckView.getStuffDataResult(false, null, strMsg);
            }
        });


    }

    private List<StuffModel> getStuffModeListFromJson(String json) {

        try {
            List<StuffModel> models = null;
            JSONObject jsonObject = new JSONObject(json);
            int error_code = jsonObject.getInt("error_code");
            if (error_code == 0) {
                models = new ArrayList<>();
                JSONObject jsonObject1 = jsonObject.getJSONObject("result");
                StuffModel model = new StuffModel();
                model.setId(jsonObject1.getString("id"));
                model.setYangli(jsonObject1.getString("yangli"));
                model.setYinli(jsonObject1.getString("yinli"));
                model.setWuxing(jsonObject1.getString("wuxing"));
                model.setChongsha(jsonObject1.getString("chongsha"));
                model.setBaiji(jsonObject1.getString("baiji"));
                model.setJishen(jsonObject1.getString("jishen"));
                model.setYi(jsonObject1.getString("yi"));
                model.setXiongshen(jsonObject1.getString("xiongshen"));
                model.setJi(jsonObject1.getString("ji"));
                models.add(model);
            }
            return models;
        } catch (JSONException e) {
            e.printStackTrace();
            return null;
        }


    }
}
