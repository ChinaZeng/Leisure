package com.zzw.MyApp.picture;

import android.support.v7.widget.RecyclerView;
import android.support.v7.widget.StaggeredGridLayoutManager;
import android.view.View;

import com.zzw.MyApp.R;
import com.zzw.MyApp.base.BaseFragment;
import com.zzw.MyApp.picture.adapter.GalleryClassAdapter;
import com.zzw.MyApp.picture.model.GalleryClassModel;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by zzw on 2016/7/8.
 * 描述:
 */
public class GalleryClassFragment extends BaseFragment {

    private RecyclerView recyclerView;

    private GalleryClassAdapter adapter;

    public static GalleryClassFragment newInstance() {
        return new GalleryClassFragment();
    }

    @Override
    protected int getLayoutId() {
        return R.layout.layout_recy;
    }

    @Override
    protected void initView(View view) {
        super.initView(view);
        recyclerView = (RecyclerView) view.findViewById(R.id.recy);
        StaggeredGridLayoutManager staggeredGridLayoutManager = new StaggeredGridLayoutManager(2, StaggeredGridLayoutManager.VERTICAL);
        recyclerView.setLayoutManager(staggeredGridLayoutManager);
        adapter = new GalleryClassAdapter(getActivity());
        recyclerView.setAdapter(adapter);
    }

    @Override
    protected void initData() {
        super.initData();
        List<GalleryClassModel> list = new ArrayList();
        list.add(new GalleryClassModel("性感美女", 1, R.mipmap.ic_1));
        list.add(new GalleryClassModel("韩日美女", 2, R.mipmap.ic_2));
        list.add(new GalleryClassModel("丝袜美腿", 3, R.mipmap.ic_3));
        list.add(new GalleryClassModel("美女照片", 4, R.mipmap.ic_4));
        list.add(new GalleryClassModel("美女写真", 5, R.mipmap.ic_5));
        list.add(new GalleryClassModel("清纯美女", 6, R.mipmap.ic_6));
        list.add(new GalleryClassModel("性感车模", 7, R.mipmap.ic_7));
        adapter.addItems(list);
    }


}
