package com.zzw.MyApp.common;

import android.content.Intent;
import android.util.Log;
import android.view.View;
import android.view.WindowManager;

import com.zzw.MyApp.Constans;
import com.zzw.MyApp.MyApplication;
import com.zzw.MyApp.R;
import com.zzw.MyApp.UI;
import com.zzw.MyApp.base.BaseActivity;
import com.zzw.MyApp.operate.Image.ImageLoadClass;
import com.zzw.MyApp.utils.FileUtils;
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
            //save Image
            new Thread(new Runnable() {
                @Override
                public void run() {
                    File srcFile = ImageLoadClass.getGlideFile(ImageActivity.this, imagePath);
                    String savaPath = null;
                    if (imagePath.endsWith("gif")) {
                        savaPath = Constans.IMAGE_SAVA_PATH + File.separator
                                + StringUtils.getUUID() + ".gif";
                    } else {
                        savaPath = Constans.IMAGE_SAVA_PATH + File.separator
                                + StringUtils.getUUID() + ".jpeg";
                    }
                    File savaFile = new File(savaPath);
                    final boolean isSava = FileUtils.copyfile(srcFile, savaFile, true);
                    final String finalSavaPath = savaPath;
                    MyApplication.getHandler().post(new Runnable() {
                        @Override
                        public void run() {
                            if (isSava) {
                                showProgressSuccess(getString(R.string.toast_file_save_path, finalSavaPath));
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
