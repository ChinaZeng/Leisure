package com.zzw.MyApp.luck.stuff;

import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.MotionEvent;
import android.view.View;
import android.widget.TextView;

import com.zzw.MyApp.R;
import com.zzw.MyApp.UI;
import com.zzw.MyApp.base.BaseActivity;
import com.zzw.MyApp.luck.stuff.adapter.StuffHourAdapter;
import com.zzw.MyApp.luck.stuff.model.StuffHourModel;
import com.zzw.MyApp.luck.stuff.presenter.IStuffHourLuckPresenter;
import com.zzw.MyApp.luck.stuff.presenter.IStuffHourLuckPresenterCompl;
import com.zzw.MyApp.luck.stuff.view.IStuffHourLuckView;

import java.util.List;

import de.hdodenhof.circleimageview.CircleImageView;

/**
 * Created by zzw on 2016/7/7.
 * 描述:
 */
public class StuffHourLuckActivity extends BaseActivity implements IStuffHourLuckView {


    public static final String DATE_KEY = "date";

    private IStuffHourLuckPresenter iStuffHourLuckPresenterCompl;
    private RecyclerView recyclerView;
    private StuffHourAdapter adapter;

    private String date;

    @Override
    protected int getLayoutId() {
        return R.layout.layout_tollbar_recy;
    }

    @Override
    protected void initView() {
        super.initView();
        date = getIntent().getStringExtra(DATE_KEY);
        iStuffHourLuckPresenterCompl = new IStuffHourLuckPresenterCompl(this);

        TextView title = (TextView) findViewById(R.id.toolbar_title);
        title.setText(R.string.stuff_hour_luck);
        CircleImageView backImage = (CircleImageView) findViewById(R.id.toolbar_left);
        backImage.setBorderWidth(0);
        backImage.setImageResource(R.mipmap.ic_go_back);
        backImage.setOnClickListener(this);

        adapter = new StuffHourAdapter(this);
        recyclerView = (RecyclerView) findViewById(R.id.layout_toolbar_recy_recy);
        recyclerView.setLayoutManager(new LinearLayoutManager(this));
        recyclerView.setAdapter(adapter);
    }

    @Override
    protected void initData() {
        super.initData();
        iStuffHourLuckPresenterCompl.getStuffHourData(date);
    }

    @Override
    public void getStuffDataResult(Boolean isSuccess, List<StuffHourModel> list, String strMsg) {

        if (isSuccess) {
            if (list != null) {
                adapter.clear();
                adapter.addItems(list);
            }
        } else {
            UI.showToast(this, strMsg);
        }
    }


    @Override
    public void onClick(View v) {
        super.onClick(v);

        switch (v.getId()) {
            case R.id.toolbar_left:
                finish();
                break;
        }
    }


    float downX = 0;
    float downY = 0;

    @Override
    public boolean dispatchTouchEvent(MotionEvent ev) {
        switch (ev.getAction()) {
            case MotionEvent.ACTION_DOWN:
                downX = ev.getX();
                downY = ev.getY();
                break;

            case MotionEvent.ACTION_UP:
                float upX = ev.getX();
                float upY = ev.getY();
                if (upX - downX > 300 && Math.abs(upY - downY) < 100) {
                    this.finish();
                }
                break;
        }
        return super.dispatchTouchEvent(ev);
    }

}
