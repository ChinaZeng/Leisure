package com.zzw.MyApp.about;

import android.view.View;
import android.view.animation.Animation;
import android.view.animation.AnimationUtils;
import android.widget.TextView;

import com.zzw.MyApp.R;
import com.zzw.MyApp.base.BaseActivity;
import com.zzw.MyApp.wedgit.matchView.MatchTextView;

import de.hdodenhof.circleimageview.CircleImageView;

/**
 * Created by zzw on 2016/7/8.
 * 描述:
 */
public class AboutActivity extends BaseActivity {

    private View about_logo;
    private MatchTextView text1, text2;

    @Override
    protected int getLayoutId() {
        return R.layout.avtivity_about;
    }

    @Override
    protected void initView() {
        super.initView();
        TextView title = (TextView) findViewById(R.id.toolbar_title);
        title.setText(R.string.about);
        CircleImageView backImage = (CircleImageView) findViewById(R.id.toolbar_left);
        backImage.setBorderWidth(0);
        backImage.setImageResource(R.mipmap.ic_go_back);
        backImage.setOnClickListener(this);
        about_logo = findViewById(R.id.about_logo);
        text1 = (MatchTextView) findViewById(R.id.about_text1);
        text2 = (MatchTextView) findViewById(R.id.about_text2);
    }


    @Override
    protected void initData() {
        super.initData();
        Animation animation = AnimationUtils.loadAnimation(this, R.anim.splash_anim);
        about_logo.startAnimation(animation);
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
    protected void onDestroy() {
        if (text1.isInLoading()) {
            text1.lightFinish();
        }
        if (text2.isInLoading()) {
            text2.lightFinish();
        }
        super.onDestroy();
    }
}
