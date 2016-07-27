package com.zzw.MyApp.news;

import android.os.Handler;
import android.support.v7.widget.LinearLayoutManager;
import android.view.View;

import com.jcodecraeer.xrecyclerview.ProgressStyle;
import com.jcodecraeer.xrecyclerview.XRecyclerView;
import com.zzw.MyApp.Constans;
import com.zzw.MyApp.R;
import com.zzw.MyApp.UI;
import com.zzw.MyApp.base.BaseFragment;
import com.zzw.MyApp.news.adapter.NewsAdapter;
import com.zzw.MyApp.news.model.NewsModel;
import com.zzw.MyApp.news.presenter.INewsPresenter;
import com.zzw.MyApp.news.presenter.INewsPresenterCompl;
import com.zzw.MyApp.news.view.INewsView;

import java.util.List;

/**
 * Created by zzw on 2016/6/12.
 * 描述:
 */
public class NewsFragment extends BaseFragment implements INewsView, XRecyclerView.LoadingListener {

    private INewsPresenter iNewsPresenter;
    private XRecyclerView recyclerView;
    private NewsAdapter adapter;
    private final int A_PAGE_COUNT = 10;
    private int nowPage = 1;

    public static NewsFragment newInstance() {
        return new NewsFragment();
    }

    @Override
    protected int getLayoutId() {
        return R.layout.layout_xrecy;
    }

    @Override
    protected void initView(View view) {
        iNewsPresenter = new INewsPresenterCompl(this);
        adapter = new NewsAdapter(getActivity());
        recyclerView = (XRecyclerView) view.findViewById(R.id.xrecyclerView);
        recyclerView.setLayoutManager(new LinearLayoutManager(getContext()));
        recyclerView.setRefreshProgressStyle(ProgressStyle.BallSpinFadeLoader);
        recyclerView.setLoadingMoreProgressStyle(ProgressStyle.BallRotate);
        recyclerView.setLoadingListener(this);
        recyclerView.setAdapter(adapter);
        recyclerView.setRefreshing(true);
    }

    /**
     * 下拉加载更多
     */
    @Override
    public void onRefresh() {
        nowPage = 1;
        getNews();
    }


    /**
     * 加载更多
     * 从网络获取最新数据
     */
    @Override
    public void onLoadMore() {
        getNews();
    }

    private void getNews() {
        iNewsPresenter.doRequestNews(nowPage, A_PAGE_COUNT);
        nowPage++;
    }

    @Override
    public void resultMsg(final Boolean isSuccess, final List<NewsModel> newsModelList, final String errorMsg) {
        new Handler().postDelayed(new Runnable() {
            @Override
            public void run() {
                if (isSuccess) {
                    if (newsModelList != null) {
                        if (nowPage == 2)
                            adapter.clear();
                        adapter.addItems(newsModelList);
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
