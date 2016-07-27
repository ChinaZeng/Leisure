package com.zzw.MyApp.common;

import android.util.Log;
import android.view.MotionEvent;
import android.view.View;
import android.webkit.WebChromeClient;
import android.webkit.WebView;
import android.webkit.WebViewClient;
import android.widget.ImageView;
import android.widget.ProgressBar;
import android.widget.TextView;

import com.zzw.MyApp.R;
import com.zzw.MyApp.UI;
import com.zzw.MyApp.base.BaseActivity;
import com.zzw.MyApp.utils.ToastUtil;

import de.hdodenhof.circleimageview.CircleImageView;

/**
 * Created by zzw on 2016/6/15.
 * 描述:
 */
public class WebActivity extends BaseActivity {

    private ProgressBar progressBar;
    public static String PATH = "path";
    private String path;
    private WebView webView;

    @Override
    protected int getLayoutId() {
        return R.layout.activity_web;
    }

    @Override
    protected void initView() {

        TextView title = (TextView) findViewById(R.id.toolbar_title);
        title.setText(R.string.details);
        CircleImageView backImage = (CircleImageView) findViewById(R.id.toolbar_left);
        backImage.setBorderWidth(0);
        backImage.setImageResource(R.mipmap.ic_go_back);
        backImage.setOnClickListener(this);

        webView = (WebView) findViewById(R.id.webView);
        progressBar = (ProgressBar) findViewById(R.id.progressBar);
        progressBar.setMax(100);
        webView.getSettings().setDefaultTextEncodingName("UTF-8");//设置字符集编码
        webView.getSettings().setJavaScriptEnabled(true);//支持javascript

        webView.setWebViewClient(new webViewClient());
        webView.setWebChromeClient(new WebChromeClient() {
            @Override
            public void onProgressChanged(WebView view, int newProgress) {
                if (newProgress == progressBar.getMax()) {
                    progressBar.setVisibility(View.GONE);
                } else {
                    if (View.GONE == progressBar.getVisibility()) {
                        progressBar.setVisibility(View.VISIBLE);
                    }
                    progressBar.setProgress(newProgress);
                }
                super.onProgressChanged(view, newProgress);
            }
        });

        path = getIntent().getStringExtra(PATH);
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
    protected void initData() {
        super.initData();

        if (path == null) {
            UI.showToast(this, R.string.url_error);
            finish();
        }
        webView.loadUrl(path);
    }

    class webViewClient extends WebViewClient {
        //重写shouldOverrideUrlLoading方法，使点击链接后不使用其他的浏览器打开。
        @Override
        public boolean shouldOverrideUrlLoading(WebView view, String url) {
            view.loadUrl(url);
            //如果不需要其他对点击链接事件的处理返回true，否则返回false
            return true;
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
