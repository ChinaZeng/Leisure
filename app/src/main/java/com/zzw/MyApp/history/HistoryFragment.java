package com.zzw.MyApp.history;

import android.os.Handler;
import android.support.v7.widget.LinearLayoutManager;
import android.view.View;

import com.jcodecraeer.xrecyclerview.ProgressStyle;
import com.jcodecraeer.xrecyclerview.XRecyclerView;
import com.zzw.MyApp.Constans;
import com.zzw.MyApp.R;
import com.zzw.MyApp.UI;
import com.zzw.MyApp.base.BaseFragment;
import com.zzw.MyApp.history.adapter.HistoryFragmentAdapter;
import com.zzw.MyApp.history.model.HistoryModel;
import com.zzw.MyApp.history.presenter.IHistoryFragmentPresenter;
import com.zzw.MyApp.history.presenter.IHistoryFragmentPresenterCompl;
import com.zzw.MyApp.history.view.IHistoryFragmentView;
import com.zzw.MyApp.utils.DateUtils;

import java.util.List;

/**
 * Created by zzw on 2016/6/30.
 * 描述:
 */
public class HistoryFragment extends BaseFragment implements IHistoryFragmentView, XRecyclerView.LoadingListener {

    private XRecyclerView recyclerView;
    private HistoryFragmentAdapter adapter;
    private IHistoryFragmentPresenter iHistoryFragmentPresenterCompl;

    public static HistoryFragment newInstance() {
        return new HistoryFragment();
    }

    @Override
    protected int getLayoutId() {
        return R.layout.layout_xrecy;
    }

    @Override
    protected void initView(View view) {
        super.initView(view);
        iHistoryFragmentPresenterCompl = new IHistoryFragmentPresenterCompl(this);
        adapter = new HistoryFragmentAdapter(getActivity());
        recyclerView = (XRecyclerView) view.findViewById(R.id.xrecyclerView);
        recyclerView.setLayoutManager(new LinearLayoutManager(getContext()));
        recyclerView.setRefreshProgressStyle(ProgressStyle.BallSpinFadeLoader);
        recyclerView.setLoadingMoreEnabled(false);
        recyclerView.setLoadingListener(this);
        recyclerView.setRefreshing(true);
        recyclerView.setAdapter(adapter);
    }

    private void getTodayHis() {
        int[] dates = DateUtils.getYMD();
        String date = dates[1] + "/" + dates[2];
        iHistoryFragmentPresenterCompl.getHistoryList(date);
    }

    @Override
    public void onRefresh() {
        getTodayHis();
    }

    @Override
    public void onLoadMore() {

    }

    @Override
    public void historyListResult(final Boolean isSuccess, final List<HistoryModel> historyModelList, final String strMsg) {
        new Handler().postDelayed(new Runnable() {
            @Override
            public void run() {
                if (isSuccess) {
                    if (historyModelList.size() > 0) {
                        adapter.clear();
                        adapter.addItems(historyModelList);
                    }
                    recyclerView.refreshComplete();
                } else {
                    UI.showToast(getContext(), strMsg);
                }
                recyclerView.loadMoreComplete();
                recyclerView.refreshComplete();
            }
        }, Constans.HANDLER_POSt_TIME);

    }
}
