package com.zzw.MyApp.life.TvTime;

import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.View;

import com.zzw.MyApp.R;
import com.zzw.MyApp.base.BaseFragment;

/**
 * Created by zzw on 2016/6/15.
 * 描述:
 */
public class TvTimeFragment extends BaseFragment {

    private RecyclerView recyclerView;

    @Override
    protected int getLayoutId() {
        return R.layout.layout_xrecy;
    }

    @Override
    protected void initView(View view) {
        super.initView(view);
        recyclerView = (RecyclerView) view.findViewById(R.id.xrecyclerView);
        recyclerView.setLayoutManager(new LinearLayoutManager(getContext()));
    }


    public static TvTimeFragment newInstance() {
        return new TvTimeFragment();
    }

}
