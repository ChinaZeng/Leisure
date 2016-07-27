package com.zzw.MyApp.picture.presenter;

import com.zzw.MyApp.operate.Net.NetRequestClass;
import com.zzw.MyApp.operate.Net.OnNetWortRequestListener;
import com.zzw.MyApp.picture.model.GalleryModel;
import com.zzw.MyApp.picture.view.IGalleryView;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by zzw on 2016/7/8.
 * 描述:
 */

public class IGalleryPresenterCompl implements IGalleryPresenter {


    private IGalleryView iGalleryView;

    public IGalleryPresenterCompl(IGalleryView iGalleryView) {
        this.iGalleryView = iGalleryView;
    }

    @Override
    public void getGallery(int id, int page, int rows) {

        if (id == 0 || page == 0 || rows == 0)
            return;
        String url = "http://www.tngou.net/tnfs/api/list?id=" + id + "&page=" + page + "&rows=" + rows;

        NetRequestClass.useRxVolleyGetUrl(url, new OnNetWortRequestListener() {
            @Override
            public void onSuccess(String url, String s) {
                iGalleryView.getGalleyModelListResult(true, getGalleryListFromJson(s), null);
            }

            @Override
            public void onFailure(String url, String strMsg) {
                iGalleryView.getGalleyModelListResult(false, null, strMsg);
            }
        });
    }


    private List<GalleryModel> getGalleryListFromJson(String json) {

        try {
            List<GalleryModel> models = null;
            JSONObject jsonObject = new JSONObject(json);

            boolean status = jsonObject.getBoolean("status");
            if (status) {
                models = new ArrayList<>();
                JSONArray jsonArray = jsonObject.getJSONArray("tngou");
                for (int i = 0; i < jsonArray.length(); i++) {
                    JSONObject jsonObject1 = jsonArray.getJSONObject(i);
                    GalleryModel model = new GalleryModel();
                    model.setTitle(jsonObject1.getString("title"));
                    model.setCount(jsonObject1.getInt("count"));
                    model.setFcount(jsonObject1.getInt("fcount"));
                    model.setGalleryclass(jsonObject1.getInt("galleryclass"));
                    model.setId(jsonObject1.getInt("id"));
                    model.setImg("http://tnfs.tngou.net/img" + jsonObject1.getString("img"));
                    model.setRcount(jsonObject1.getInt("rcount"));
                    model.setSize(jsonObject1.getInt("size"));
//                    model.setTime(jsonObject.getLong("time"));
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
