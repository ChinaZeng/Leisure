package com.zzw.MyApp.luck.stuff;

import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.View;

import com.zzw.MyApp.R;
import com.zzw.MyApp.UI;
import com.zzw.MyApp.base.BaseFragment;
import com.zzw.MyApp.luck.stuff.adapter.StuffDayAdapter;
import com.zzw.MyApp.luck.stuff.model.StuffModel;
import com.zzw.MyApp.luck.stuff.presenter.IStuffLuckPresenter;
import com.zzw.MyApp.luck.stuff.presenter.IStuffLuckPresenterCompl;
import com.zzw.MyApp.luck.stuff.view.IStuffLuckView;
import com.zzw.MyApp.utils.DateUtils;

import java.util.Date;
import java.util.List;

/**
 * Created by zzw on 2016/6/15.
 * 描述:
 */
public class StuffLuckFragment extends BaseFragment implements IStuffLuckView {

    private RecyclerView recyclerView;
    private IStuffLuckPresenter iStuffLuckPresenterCompl;
    private StuffDayAdapter adapter;

    @Override
    protected int getLayoutId() {
        return R.layout.fragment_stuff;
    }

    @Override
    protected void initView(View view) {
        super.initView(view);
        iStuffLuckPresenterCompl = new IStuffLuckPresenterCompl(this);
        adapter = new StuffDayAdapter(getActivity());
        recyclerView = (RecyclerView) view.findViewById(R.id.xrecyclerView);
        recyclerView.setLayoutManager(new LinearLayoutManager(getContext()));
        recyclerView.setAdapter(adapter);

        view.findViewById(R.id.fragment_stuff_bt).setOnClickListener(this);
    }

    @Override
    public void onClick(View v) {
        super.onClick(v);
        switch (v.getId()) {
            case R.id.fragment_stuff_bt:

                break;
        }
    }

    @Override
    protected void initData() {
        getStuffLuck(DateUtils.formatDate(new Date(), DateUtils.dateFormat));
    }

    private void getStuffLuck(String date) {
        iStuffLuckPresenterCompl.getStuffData(date);
    }

    public static StuffLuckFragment newInstance() {
        return new StuffLuckFragment();
    }

    @Override
    public void getStuffDataResult(Boolean isSuccess, List<StuffModel> list, String strMsg) {
        if (isSuccess) {
            if (list != null) {
                adapter.clear();
                adapter.addItems(list);
            }
        } else {
            UI.showToast(getContext(), strMsg);
        }
    }
}
