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
import com.zzw.MyApp.joke.adapter.JokeTextRecyAdapter;
import com.zzw.MyApp.joke.model.JokeTextModel;
import com.zzw.MyApp.joke.presenter.IJokeTextPresenter;
import com.zzw.MyApp.joke.presenter.IJokeTextPresenterCompl;
import com.zzw.MyApp.joke.view.IJokeTextView;

import java.util.List;

/**
 * Created by zzw on 2016/6/13.
 * 描述:
 */
public class JokeTextFragment extends BaseFragment implements IJokeTextView, XRecyclerView.LoadingListener {

    private JokeTextRecyAdapter adapter;
    private XRecyclerView recyclerView;
    private IJokeTextPresenter iJokeTextPresenter;

    private final int A_PAGE_COUNT = 10;
    private int nowPage = 1;

    public static JokeTextFragment newInstance() {
        return new JokeTextFragment();
    }

    @Override
    protected int getLayoutId() {
        return R.layout.layout_xrecy;
    }

    @Override
    protected void initView(View view) {
        iJokeTextPresenter = new IJokeTextPresenterCompl(this);
        adapter = new JokeTextRecyAdapter(getActivity());
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
        getJokeText();
    }

    @Override
    public void onLoadMore() {
        getJokeText();
    }

    private void getJokeText() {
        iJokeTextPresenter.reqJokeText(nowPage, A_PAGE_COUNT);
        nowPage++;
    }

    @Override
    public void addJokeTextList(final Boolean isSuccess, final List<JokeTextModel> list, final String strMsg) {
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
                    UI.showToast(getContext(), strMsg);
                }
                recyclerView.loadMoreComplete();
                recyclerView.refreshComplete();
            }
        }, Constans.HANDLER_POSt_TIME);
    }
}
