package com.zzw.MyApp.base;

import android.annotation.SuppressLint;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

/**
 * Created by zzw on 2016/6/13.
 * 描述:
 */
public abstract class BaseFragment extends Fragment implements View.OnClickListener {

    @Nullable
    @Override
    public final View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        if (getLayoutId() == 0) {
            return null;
        }
        return inflater.inflate(getLayoutId(), container, false);
    }

    @SuppressLint("LongLogTag")
    @Override
    public void onViewCreated(View view, @Nullable Bundle savedInstanceState) {

        if (view != null) {
            initView(view);
            initData();
        }

        super.onViewCreated(view, savedInstanceState);
    }

    /**
     * 返回资源id
     *
     * @return
     */
    protected abstract int getLayoutId();

    /**
     * 初始化控件
     *
     * @param view
     */
    protected void initView(View view) {
    }

    /**
     * 初始化数据
     */
    protected void initData() {
    }


    @Override
    public void onClick(View v) {

    }

}
