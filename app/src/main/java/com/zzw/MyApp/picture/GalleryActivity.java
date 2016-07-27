package com.zzw.MyApp.picture;

import android.content.Intent;
import android.os.Handler;
import android.support.v7.widget.StaggeredGridLayoutManager;
import android.view.View;
import android.widget.TextView;

import com.jcodecraeer.xrecyclerview.ProgressStyle;
import com.jcodecraeer.xrecyclerview.XRecyclerView;
import com.zzw.MyApp.Constans;
import com.zzw.MyApp.R;
import com.zzw.MyApp.UI;
import com.zzw.MyApp.base.BaseActivity;
import com.zzw.MyApp.base.BaseFragment;
import com.zzw.MyApp.picture.adapter.GalleryAdapter;
import com.zzw.MyApp.picture.model.GalleryModel;
import com.zzw.MyApp.picture.presenter.IGalleryPresenter;
import com.zzw.MyApp.picture.presenter.IGalleryPresenterCompl;
import com.zzw.MyApp.picture.view.IGalleryView;

import java.util.List;

import de.hdodenhof.circleimageview.CircleImageView;

/**
 * Created by zzw on 2016/7/8.
 * 描述:
 */
public class GalleryActivity extends BaseActivity implements IGalleryView, XRecyclerView.LoadingListener {

    public static String TITLE_KEY = "title";
    public static String ID_KEY = "id";

    private int id;

    private IGalleryPresenter iGalleryPresenterCompl;

    private XRecyclerView recyclerView;
    private GalleryAdapter adapter;

    private int page = 1;
    private static final int PAGE_COUNT = 10;

    @Override
    protected int getLayoutId() {
        return R.layout.activity_gallery;
    }


    @Override
    protected void initView() {
        Intent intent = getIntent();
        TextView title = (TextView) findViewById(R.id.toolbar_title);
        title.setText(intent.getStringExtra(TITLE_KEY));
        CircleImageView backImage = (CircleImageView) findViewById(R.id.toolbar_left);
        backImage.setBorderWidth(0);
        backImage.setImageResource(R.mipmap.ic_go_back);
        backImage.setOnClickListener(this);
        id = intent.getIntExtra(ID_KEY, 0);

        iGalleryPresenterCompl = new IGalleryPresenterCompl(this);
        adapter = new GalleryAdapter(this);
        recyclerView = (XRecyclerView) findViewById(R.id.gallery_xrecyclerView);
        StaggeredGridLayoutManager staggeredGridLayoutManager = new StaggeredGridLayoutManager(2, StaggeredGridLayoutManager.VERTICAL);
        recyclerView.setLayoutManager(staggeredGridLayoutManager);
        recyclerView.setRefreshProgressStyle(ProgressStyle.BallSpinFadeLoader);
        recyclerView.setLoadingMoreProgressStyle(ProgressStyle.BallRotate);
        recyclerView.setLoadingListener(this);
        recyclerView.setAdapter(adapter);
        recyclerView.setRefreshing(true);
    }

    private void getDate() {
        iGalleryPresenterCompl.getGallery(id,page, PAGE_COUNT);
        page++;
    }

    @Override
    public void onClick(View v) {
        switch (v.getId()) {
            case R.id.toolbar_left:
                finish();
                break;
        }
    }

    @Override
    public void getGalleyModelListResult(final Boolean isSuccess, final List<GalleryModel> list, final String str) {
        new Handler().postDelayed(new Runnable() {
            @Override
            public void run() {
                if (isSuccess) {
                    if (list != null) {
                        if (page == 2)
                            adapter.clear();
                        adapter.addItems(list);
                    }
                } else {
                    UI.showToast(GalleryActivity.this, str);
                }
                recyclerView.loadMoreComplete();
                recyclerView.refreshComplete();
            }
        }, Constans.HANDLER_POSt_TIME);
    }

    @Override
    public void onRefresh() {
        page = 1;
        getDate();
    }

    @Override
    public void onLoadMore() {
        getDate();
    }
}
