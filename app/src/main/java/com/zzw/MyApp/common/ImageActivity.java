package com.zzw.MyApp.common;

import android.content.Intent;
import android.graphics.Bitmap;
import android.os.Environment;
import android.view.View;
import android.view.WindowManager;

import com.bumptech.glide.Glide;
import com.bumptech.glide.load.resource.bitmap.GlideBitmapDrawable;
import com.zzw.MyApp.Constans;
import com.zzw.MyApp.MyApplication;
import com.zzw.MyApp.R;
import com.zzw.MyApp.UI;
import com.zzw.MyApp.base.BaseActivity;
import com.zzw.MyApp.operate.Image.ImageLoadClass;
import com.zzw.MyApp.utils.BitmapUtils;
import com.zzw.MyApp.utils.StringUtils;
import com.zzw.MyApp.wedgit.photoView.PhotoView;
import com.zzw.MyApp.wedgit.photoView.PhotoViewAttacher;

import java.io.File;

/**
 * Created by zzw on 2016/6/30.
 * 描述:
 */
public class ImageActivity extends BaseActivity {

    private PhotoView photoView;
    public static final String IMAGE_PATH = "imagePath";
    private String imagePath;

    @Override
    protected int getLayoutId() {
        toggleFullscreen(true);
        return R.layout.activity_image;
    }

    @Override
    protected void initView() {
        super.initView();
        Intent intent = getIntent();
        imagePath = intent.getStringExtra(IMAGE_PATH);
        photoView = (PhotoView) findViewById(R.id.photoView);
        photoView.setOnPhotoTapListener(new PhotoViewAttacher.OnPhotoTapListener() {
            @Override
            public void onPhotoTap(View view, float x, float y) {
                ImageActivity.this.finish();
            }
        });
        findViewById(R.id.image_sava).setOnClickListener(this);
    }

    @Override
    protected void initData() {
        super.initData();
        if (imagePath == null) {
            UI.showToast(this, R.string.url_error);
            finish();
            return;
        }
        ImageLoadClass.loadImage(this, imagePath, photoView);
    }

    @Override
    public void onClick(View v) {
        super.onClick(v);

        switch (v.getId()) {
            case R.id.image_sava:
                savaImage();
                break;
        }
    }

    private void savaImage() {
        try {
            //显示dialog
            showProgressDialog(getString(R.string.savaing));
            final Bitmap bitmap = ((GlideBitmapDrawable) photoView.getDrawable()).getBitmap();

            //save Image
            new Thread(new Runnable() {
                @Override
                public void run() {
                    final String savaPath = Constans.IMAGE_SAVA_PATH;
                    final boolean saveBitmapToSD = BitmapUtils.saveBitmapToSD(bitmap, savaPath, StringUtils.getUUID() + ".jpg", true);
                    MyApplication.getHandler().post(new Runnable() {
                        @Override
                        public void run() {
                            if (saveBitmapToSD) {
                                showProgressSuccess(getString(R.string.toast_file_save_path, savaPath));
                            } else {
                                showProgressError(getString(R.string.toast_file_save_error));
                            }
                        }
                    });
                }
            }).start();
        } catch (Exception e) {
            showProgressError(getString(R.string.toast_file_save_error));
        }
    }


    public void toggleFullscreen(boolean fullScreen) {
        // fullScreen为true时全屏，否则相反
        WindowManager.LayoutParams attrs = getWindow().getAttributes();
        if (fullScreen) {
            attrs.flags |= WindowManager.LayoutParams.FLAG_FULLSCREEN;
        } else {
            attrs.flags &= WindowManager.LayoutParams.FLAG_FULLSCREEN;
        }
        getWindow().setAttributes(attrs);
    }

}
