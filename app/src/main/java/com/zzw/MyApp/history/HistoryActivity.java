package com.zzw.MyApp.history;

import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.MotionEvent;
import android.view.View;
import android.widget.TextView;

import com.zzw.MyApp.R;
import com.zzw.MyApp.UI;
import com.zzw.MyApp.base.BaseActivity;
import com.zzw.MyApp.history.model.HistoryDetailsModel;
import com.zzw.MyApp.history.presenter.IHistoryActivityPresent;
import com.zzw.MyApp.history.presenter.IHistoryActivityPresentCompl;
import com.zzw.MyApp.history.view.IHistoryActivityView;

import de.hdodenhof.circleimageview.CircleImageView;

/**
 * Created by zzw on 2016/7/1.
 * 描述:
 */
public class HistoryActivity extends BaseActivity implements IHistoryActivityView {

    public static final String E_ID_KEY = "e_id";

    private String e_id;
    private IHistoryActivityPresent iHistoryActivityPresentCompl;
    private RecyclerView recyclerView;

    @Override
    protected int getLayoutId() {
        return R.layout.layout_tollbar_recy;
    }

    @Override
    protected void initView() {
        super.initView();
        e_id = getIntent().getStringExtra(E_ID_KEY);
        iHistoryActivityPresentCompl = new IHistoryActivityPresentCompl(this);
        TextView title = (TextView) findViewById(R.id.toolbar_title);
        title.setText(R.string.details);
        CircleImageView backImage = (CircleImageView) findViewById(R.id.toolbar_left);
        backImage.setBorderWidth(0);
        backImage.setImageResource(R.mipmap.ic_go_back);
        backImage.setOnClickListener(this);
        recyclerView = (RecyclerView) findViewById(R.id.layout_toolbar_recy_recy);
        recyclerView.setLayoutManager(new LinearLayoutManager(this));
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


    @Override
    protected void initData() {
        super.initData();
        if (e_id == null) {
            UI.showToast(this, R.string.url_error);
            this.finish();
            return;
        }
        iHistoryActivityPresentCompl.getHistoryDetails(e_id);
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


    @Override
    public void detailsHistoryResult(Boolean isSuccess, HistoryDetailsModel model, String strMsg) {

        if (isSuccess) {
            if (model == null)
                return;
            iHistoryActivityPresentCompl.addDateToRecyAdapter(this, model);
        } else {
            UI.showToast(this, strMsg);
            this.finish();
        }

    }

    @Override
    public void addDataToRecyAdapterResult(RecyclerView.Adapter adapter) {
        recyclerView.setAdapter(adapter);
    }


}
