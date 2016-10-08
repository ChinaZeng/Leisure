package com.zzw.MyApp.base;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.view.Window;

import com.bigkoo.svprogresshud.SVProgressHUD;
import com.umeng.analytics.MobclickAgent;

/**
 * Created by zzw on 2016/6/13.
 * 描述:
 */
public abstract class BaseActivity extends AppCompatActivity implements View.OnClickListener {


    private SVProgressHUD mSVProgressHUD;

    private void initDialog() {
        mSVProgressHUD = new SVProgressHUD(this);
    }

    public void showProgressDialog(String message) {
        dissmissProgressDialog();
        mSVProgressHUD.showWithStatus(message, SVProgressHUD.SVProgressHUDMaskType.BlackCancel);
    }

    public void showProgressSuccess(String message) {
        dissmissProgressDialog();
        mSVProgressHUD.showSuccessWithStatus(message, SVProgressHUD.SVProgressHUDMaskType.BlackCancel);
    }

    public void showProgressError(String message) {
        dissmissProgressDialog();
        mSVProgressHUD.showErrorWithStatus(message, SVProgressHUD.SVProgressHUDMaskType.BlackCancel);
    }

    public void dissmissProgressDialog() {
        if (mSVProgressHUD.isShowing()) {
            mSVProgressHUD.dismiss();
        }
    }


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        if (getLayoutId() != 0) {
            setContentView(getLayoutId());
        }
        initView();
        init(savedInstanceState);
        initDialog();
        initData();
    }

    /**
     * 返回资源id
     *
     * @return
     */
    protected abstract int getLayoutId();


    /**
     * 初始化状态
     *
     * @param savedInstanceState
     */
    protected void init(Bundle savedInstanceState) {
    }

    /**
     * 初始化控件
     */
    protected void initView() {
    }

    /**
     * 初始化数据
     */
    protected void initData() {
    }


    @Override
    public void onClick(View v) {

    }

    @Override
    protected void onPause() {
        super.onPause();
        MobclickAgent.onPause(this);
    }

    @Override
    protected void onResume() {
        super.onResume();
        MobclickAgent.onResume(this);
    }
}
