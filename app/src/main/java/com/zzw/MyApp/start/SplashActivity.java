package com.zzw.MyApp.start;

import android.os.Handler;
import android.view.View;
import android.view.WindowManager;
import android.view.animation.Animation;
import android.view.animation.AnimationUtils;

import com.zzw.MyApp.R;
import com.zzw.MyApp.UI;
import com.zzw.MyApp.base.BaseActivity;
import com.zzw.MyApp.wedgit.matchView.MatchTextView;

/**
 * Created by zzw on 2016/7/7.
 * 描述:
 */
public class SplashActivity extends BaseActivity {

    private MatchTextView splash_text;

    @Override
    protected int getLayoutId() {
        toggleFullscreen(true);
        return R.layout.activity_splash;
    }


    @Override
    protected void initView() {
        super.initView();
        View view = findViewById(R.id.splash_root_view);
        splash_text = (MatchTextView) findViewById(R.id.splash_text);
        Animation animation = AnimationUtils.loadAnimation(this, R.anim.splash_anim);

        animation.setAnimationListener(new Animation.AnimationListener() {
            @Override
            public void onAnimationStart(Animation arg0) {
            }

            @Override
            public void onAnimationRepeat(Animation arg0) {
            }

            @Override
            public void onAnimationEnd(Animation arg0) {
                new Handler().postDelayed(new Runnable() {
                    @Override
                    public void run() {
                        UI.showMainActivity(SplashActivity.this);
                        SplashActivity.this.finish();
                    }
                }, 2000);
            }
        });
        view.startAnimation(animation);
    }

    public void toggleFullscreen(boolean fullScreen) {
        // fullScreen为true时全屏，否则相反

        WindowManager.LayoutParams attrs = getWindow().getAttributes();

        if (fullScreen) {
            attrs.flags |= WindowManager.LayoutParams.FLAG_FULLSCREEN;
        } else {
            attrs.flags &= ~WindowManager.LayoutParams.FLAG_FULLSCREEN;
        }

        getWindow().setAttributes(attrs);
    }


    @Override
    protected void onDestroy() {
        if (splash_text.isInLoading()) {
            splash_text.lightFinish();
        }
        super.onDestroy();

    }
}
