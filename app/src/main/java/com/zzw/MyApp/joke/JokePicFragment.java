package com.zzw.MyApp.joke;

import android.os.Handler;
import android.support.v7.widget.LinearLayoutManager;
import android.view.View;

import com.jcodecraeer.xrecyclerview.ProgressStyle;
import com.jcodecraeer.xrecyclerview.XRecyclerView;
import com.zzw.MyApp.Constans;
import com.zzw.MyApp.R;
import com.zzw.MyApp.UI;
import com.zzw.MyApp.base.BaseFragment;
import com.zzw.MyApp.joke.adapter.JokePicRecyAdapter;
import com.zzw.MyApp.joke.model.JokePicModel;
import com.zzw.MyApp.joke.presenter.IJokePicPresenter;
import com.zzw.MyApp.joke.presenter.IJokePicPresenterCompl;
import com.zzw.MyApp.joke.view.IJokePicView;

import java.util.List;

/**
 * Created by zzw on 2016/6/13.
 * 描述:
 */
public class JokePicFragment extends BaseFragment implements IJokePicView, XRecyclerView.LoadingListener {

    private XRecyclerView recyclerView;
    private JokePicRecyAdapter adapter;
    private IJokePicPresenter jokePicPresenter;
    private final int A_PAGE_COUNT = 10;
    private int nowPage = 1;

    public static JokePicFragment newInstance() {
        return new JokePicFragment();
    }

    @Override
    protected int getLayoutId() {
        return R.layout.layout_xrecy;
    }

    @Override
    protected void initView(View view) {
        jokePicPresenter = new IJokePicPresenterCompl(this);
        adapter = new JokePicRecyAdapter(getActivity());
        recyclerView = (XRecyclerView) view.findViewById(R.id.xrecyclerView);
        recyclerView.setLayoutManager(new LinearLayoutManager(getContext()));
        recyclerView.setRefreshProgressStyle(ProgressStyle.BallSpinFadeLoader);
        recyclerView.setLoadingMoreProgressStyle(ProgressStyle.BallRotate);
        recyclerView.setLoadingListener(this);
        recyclerView.setRefreshing(true);
        recyclerView.setAdapter(adapter);

    }


    @Override
    public void onRefresh() {
        nowPage = 1;
        getJokePic();
    }

    @Override
    public void onLoadMore() {
        getJokePic();
    }

    private void getJokePic() {
        jokePicPresenter.reqJokePic(nowPage, A_PAGE_COUNT);
        nowPage++;
    }

    @Override
    public void addJokePicList(final boolean isSuccess, final List<JokePicModel> list, final String errorMsg) {
        new Handler().postDelayed(new Runnable() {
            @Override
            public void run() {
                if (isSuccess) {
                    if (list != null) {
                        if (nowPage == 2)
                            adapter.clear();
                        adapter.addItems(list);
                    }
                } else {
                    UI.showToast(getContext(), errorMsg);
                }
                recyclerView.loadMoreComplete();
                recyclerView.refreshComplete();
            }
        }, Constans.HANDLER_POSt_TIME);
    }
}
