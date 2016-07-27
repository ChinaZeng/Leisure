package com.zzw.MyApp.luck.constellation.presenter;

import com.zzw.MyApp.Constans;
import com.zzw.MyApp.luck.constellation.model.ConstellationModel;
import com.zzw.MyApp.luck.constellation.view.IConLuckView;
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
public class IConLuckPresenterCompl implements IConLuckPresenter {

    private IConLuckView iConLuckView;

    public IConLuckPresenterCompl(IConLuckView iConLuckView) {
        this.iConLuckView = iConLuckView;
    }

    @Override
    public synchronized void getConLuckDate(String consName, final String type) {

        if (consName == null || type == null)
            return;

        String url = "http://web.juhe.cn:8080/constellation/getAll?consName="
                + StringUtils.getUtf_8String(consName) + "&type="
                + type + "&key=" + Constans.CONSTELLATION_APP_KEY;

        NetRequestClass.useRxVolleyGetUrl(url, new OnNetWortRequestListener() {
            @Override
            public void onSuccess(String url, String s) {
                iConLuckView.getConLuckDateResult(true, getConstellationModelFromJson(type, s), null);
            }

            @Override
            public void onFailure(String url, String strMsg) {
                iConLuckView.getConLuckDateResult(false, null, strMsg);
            }
        });

    }

    private ConstellationModel getConstellationModelFromJson(String type, String json) {

        if (json == null || type == null)
            return null;

        ConstellationModel model = null;
        switch (type) {
            case ConLuckType.TODAY:
            case ConLuckType.TOMORROW:
                model = getDayConstellationModelFromJson(json);
                break;
            case ConLuckType.WEEK:
            case ConLuckType.NEXTWEEK:
                model = getWeekConstellationModelFromJson(json);
                break;
            case ConLuckType.MONTH:
                model = getMonthConstellationModelFromJson(json);
                break;
            case ConLuckType.YEAR:
                model = getYearConstellationModelFromJson(json);
                break;
        }
        if (model != null) {
            model.setType(type);
        }
        return model;
    }

    private ConstellationModel getDayConstellationModelFromJson(String json) {
        try {
            JSONObject jsonObject = new JSONObject(json);
            int error_code = jsonObject.getInt("error_code");
            if (error_code == 0) {
                ConstellationModel model = new ConstellationModel();
                model.setDate(jsonObject.getInt("date") + "");
                model.setName(jsonObject.getString("name"));
                model.setDatetime(jsonObject.getString("datetime"));
                model.setAll(jsonObject.getString("all"));
                model.setColor(jsonObject.getString("color"));
                model.setHealth(jsonObject.getString("health"));
                model.setLove(jsonObject.getString("love"));
                model.setMoney(jsonObject.getString("money"));
                model.setNumber(jsonObject.getInt("number"));
                model.setQFriend(jsonObject.getString("QFriend"));
                model.setSummary(jsonObject.getString("summary"));
                model.setWork(jsonObject.getString("work"));
                model.setResultcode(jsonObject.getString("resultcode"));
                return model;
            } else {
                return null;
            }
        } catch (JSONException e) {
            e.printStackTrace();
            return null;
        }
    }

    private ConstellationModel getWeekConstellationModelFromJson(String json) {
        try {
            JSONObject jsonObject = new JSONObject(json);
            int error_code = jsonObject.getInt("error_code");
            if (error_code == 0) {
                ConstellationModel model = new ConstellationModel();
                model.setDate(jsonObject.getString("date"));
                model.setName(jsonObject.getString("name"));
                model.setHealth(jsonObject.getString("health"));
                model.setJob(jsonObject.getString("job"));
                model.setLove(jsonObject.getString("love"));
                model.setMoney(jsonObject.getString("money"));
                model.setWeekth(jsonObject.getInt("weekth"));
                model.setWork(jsonObject.getString("work"));
                model.setResultcode(jsonObject.getString("resultcode"));
                return model;
            } else {
                return null;
            }
        } catch (JSONException e) {
            e.printStackTrace();
            return null;
        }
    }

    private ConstellationModel getMonthConstellationModelFromJson(String json) {
        try {
            JSONObject jsonObject = new JSONObject(json);
            int error_code = jsonObject.getInt("error_code");
            if (error_code == 0) {
                ConstellationModel model = new ConstellationModel();
                model.setDate(jsonObject.getString("date"));
                model.setName(jsonObject.getString("name"));
                model.setAll(jsonObject.getString("all"));
                model.setHappyMagic(jsonObject.getString("happyMagic"));
                model.setHealth(jsonObject.getString("health"));
                model.setLove(jsonObject.getString("love"));
                model.setMoney(jsonObject.getString("money"));
                model.setMonth(jsonObject.getInt("month"));
                model.setWork(jsonObject.getString("work"));
                model.setResultcode(jsonObject.getString("resultcode"));
                return model;
            } else {
                return null;
            }
        } catch (JSONException e) {
            e.printStackTrace();
            return null;
        }
    }

    private ConstellationModel getYearConstellationModelFromJson(String json) {
        try {
            JSONObject jsonObject = new JSONObject(json);
            int error_code = jsonObject.getInt("error_code");
            if (error_code == 0) {
                ConstellationModel model = new ConstellationModel();
                model.setDate(jsonObject.getString("date"));
                model.setName(jsonObject.getString("name"));
                model.setResultcode(jsonObject.getString("resultcode"));
                model.setYear(jsonObject.getInt("year"));

                JSONObject jsonObject1 = jsonObject.getJSONObject("mima");
                ConstellationModel.MimaBean mimaBean = new ConstellationModel.MimaBean();
                mimaBean.setInfo(jsonObject1.getString("info"));
                JSONArray jsonArray = jsonObject1.getJSONArray("text");
                List<String> texts = new ArrayList<>();
                for (int i = 0; i < jsonArray.length(); i++) {
                    texts.add(jsonArray.getString(i));
                }
                mimaBean.setText(texts);
                model.setMima(mimaBean);

                JSONArray jsonArray1 = jsonObject.getJSONArray("career");
                List<String> careers = new ArrayList<>();
                for (int i = 0; i < jsonArray1.length(); i++) {
                    careers.add(jsonArray1.getString(i));
                }
                model.setCareer(careers);

                JSONArray jsonArray2 = jsonObject.getJSONArray("love");
                model.setLove(jsonArray2.getString(0));

                JSONArray jsonArray3 = jsonObject.getJSONArray("health");
                model.setHealth(jsonArray3.getString(0));

                JSONArray jsonArray4 = jsonObject.getJSONArray("finance");
                List<String> finances = new ArrayList<>();
                for (int i = 0; i < jsonArray1.length(); i++) {
                    finances.add(jsonArray4.getString(i));
                }
                model.setFinance(finances);

                model.setLuckyStone(jsonObject.getString("luckyStone"));
                return model;
            } else {
                return null;
            }
        } catch (JSONException e) {
            e.printStackTrace();
            return null;
        }
    }
}
