package com.zzw.MyApp.luck.constellation;

import android.os.Handler;
import android.support.v7.widget.LinearLayoutManager;
import android.view.View;
import android.widget.AdapterView;

import com.jcodecraeer.xrecyclerview.ProgressStyle;
import com.jcodecraeer.xrecyclerview.XRecyclerView;
import com.zzw.MyApp.Constans;
import com.zzw.MyApp.R;
import com.zzw.MyApp.UI;
import com.zzw.MyApp.base.BaseFragment;
import com.zzw.MyApp.luck.constellation.adapter.ConLuckAdapter;
import com.zzw.MyApp.luck.constellation.model.ConstellationModel;
import com.zzw.MyApp.luck.constellation.presenter.IConLuckPresenter;
import com.zzw.MyApp.luck.constellation.presenter.IConLuckPresenterCompl;
import com.zzw.MyApp.luck.constellation.view.IConLuckView;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by zzw on 2016/6/15.
 * 描述:
 */
public class ConLuckFragment extends BaseFragment implements XRecyclerView.LoadingListener, IConLuckView, AdapterView.OnItemSelectedListener {

    private IConLuckPresenter iConLuckPresenterCompl;
    private XRecyclerView recyclerView;
    private ConLuckAdapter adapter;

    public static ConLuckFragment newInstance() {
        return new ConLuckFragment();
    }

    @Override
    protected int getLayoutId() {
        return R.layout.layout_xrecy;
    }


    @Override
    protected void initView(View view) {
        super.initView(view);
        iConLuckPresenterCompl = new IConLuckPresenterCompl(this);
        initSpinnerMenu();
        adapter = new ConLuckAdapter(getActivity(), initSpinnerMenu(), this);
        recyclerView = (XRecyclerView) view.findViewById(R.id.xrecyclerView);
        recyclerView.setLayoutManager(new LinearLayoutManager(getContext()));
        recyclerView.setRefreshProgressStyle(ProgressStyle.BallSpinFadeLoader);
        recyclerView.setLoadingMoreEnabled(false);
        recyclerView.setLoadingListener(this);
        recyclerView.setAdapter(adapter);
        recyclerView.setRefreshing(true);
    }


    private void getDate(String conName) {
        iConLuckPresenterCompl.getConLuckDate(conName, IConLuckPresenter.ConLuckType.TODAY);
        iConLuckPresenterCompl.getConLuckDate(conName, IConLuckPresenter.ConLuckType.TOMORROW);
        iConLuckPresenterCompl.getConLuckDate(conName, IConLuckPresenter.ConLuckType.WEEK);
        iConLuckPresenterCompl.getConLuckDate(conName, IConLuckPresenter.ConLuckType.NEXTWEEK);
        iConLuckPresenterCompl.getConLuckDate(conName, IConLuckPresenter.ConLuckType.MONTH);
        iConLuckPresenterCompl.getConLuckDate(conName, IConLuckPresenter.ConLuckType.YEAR);
    }


    private List<String> initSpinnerMenu() {
        List<String> spinnerMenu = new ArrayList<>();
        String[] conArray = getResources().getStringArray(R.array.conLuckArray);
        for (int i = 0; i < conArray.length; i++) {
            spinnerMenu.add(conArray[i]);
        }
        return spinnerMenu;
    }

    @Override
    public void onRefresh() {
        getDate(adapter.spinnerMenu.get(adapter.nowSelectIndex).substring(0, 3));
    }

    @Override
    public void onLoadMore() {
    }

    @Override
    public void onItemSelected(AdapterView<?> adapterView, View view, int i, long l) {
        adapter.nowSelectIndex = i;
        recyclerView.setRefreshing(true);
    }

    @Override
    public void onNothingSelected(AdapterView<?> adapterView) {

    }

    @Override
    public void getConLuckDateResult(final Boolean isSuccess, final ConstellationModel constellationModel, final String strMsg) {

        new Handler().postDelayed(new Runnable() {
            @Override
            public void run() {
                if (isSuccess) {
                    if (constellationModel != null) {
                        if (adapter.getItemCount() == 7)
                            adapter.clear();
                        adapter.addItem(constellationModel);
                    }
                } else {
                    UI.showToast(getContext(), strMsg);
                }
                recyclerView.refreshComplete();
            }
        }, Constans.HANDLER_POSt_TIME);
    }
}
