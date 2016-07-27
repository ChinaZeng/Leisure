package com.zzw.MyApp;

import android.annotation.TargetApi;
import android.app.Activity;
import android.app.ActivityOptions;
import android.content.Context;
import android.content.DialogInterface;
import android.content.Intent;
import android.os.Build;
import android.view.View;

import com.zzw.MyApp.about.AboutActivity;
import com.zzw.MyApp.common.ImageActivity;
import com.zzw.MyApp.common.WebActivity;
import com.zzw.MyApp.history.HistoryActivity;
import com.zzw.MyApp.luck.stuff.StuffHourLuckActivity;
import com.zzw.MyApp.picture.GalleryActivity;
import com.zzw.MyApp.utils.ToastUtil;

/**
 * Created by zzw on 2016/6/15.
 * 描述:
 */
public class UI {


    public static void showToast(Context context, String msg) {
        if (msg == null)
            return;
        ToastUtil.showToast(context, msg);
    }

    public static void showToast(Context context, int msgId) {
        if (msgId == 0)
            return;
        ToastUtil.showToast(context, msgId);
    }


    public static void showWebActivity(Activity activity, String url) {
        if (url == null)
            return;
        Intent intent = new Intent(activity, WebActivity.class);
        intent.putExtra(WebActivity.PATH, url);
        activity.startActivity(intent);
    }


    public static void showHistoryActivity(Activity activity, String e_id) {
        if (e_id == null)
            return;
        Intent intent = new Intent(activity, HistoryActivity.class);
        intent.putExtra(HistoryActivity.E_ID_KEY, e_id);
        activity.startActivity(intent);
    }


    @TargetApi(Build.VERSION_CODES.LOLLIPOP)
    public static void showImageActivity(Activity activity, String path) {
        if (path == null)
            return;
        Intent intent = new Intent(activity, ImageActivity.class);
        intent.putExtra(ImageActivity.IMAGE_PATH, path);

        activity.startActivity(intent);
    }

    public static void showStuffHourActivity(Activity activity, String date) {
        if (date == null)
            return;
        Intent intent = new Intent(activity, StuffHourLuckActivity.class);
        intent.putExtra(StuffHourLuckActivity.DATE_KEY, date);
        activity.startActivity(intent);
    }


    public static void showMainActivity(Activity activity) {
        Intent intent = new Intent(activity, MainActivity.class);
        activity.startActivity(intent);
    }

    //分享文字
    public static void shareText(Context context, String shareText) {
        if (shareText == null)
            return;
        Intent shareIntent = new Intent();
        shareIntent.setAction(Intent.ACTION_SEND);
        shareIntent.putExtra(Intent.EXTRA_TEXT, shareText);
        shareIntent.setType("text/plain");

        //设置分享列表的标题，并且每次都显示分享列表
        context.startActivity(Intent.createChooser(shareIntent, "分享到"));
    }

    public static void showGalleryActivity(Activity activity, String title, int id) {
        Intent intent = new Intent(activity, GalleryActivity.class);
        intent.putExtra(GalleryActivity.TITLE_KEY, title);
        intent.putExtra(GalleryActivity.ID_KEY, id);
        activity.startActivity(intent);
    }

    public static void showAboutActivity(Activity activity) {
        Intent intent = new Intent(activity, AboutActivity.class);
        activity.startActivity(intent);
    }


    public static void showConfirmDialog(Context context, int titleResId, int msgResId, DialogInterface.OnClickListener listener) {
        showConfirmDialog(context, context.getString(titleResId), context.getString(msgResId), listener);
    }

    public static void showConfirmDialog(Context context, String title, String msg, DialogInterface.OnClickListener listener) {
        final android.support.v7.app.AlertDialog alertDialog = new android.support.v7.app.AlertDialog.Builder(context).create();
        alertDialog.setTitle(title);
        alertDialog.setMessage(msg);
        alertDialog.setButton(android.support.v7.app.AlertDialog.BUTTON_POSITIVE, context.getString(R.string.btn_ok), listener);
        alertDialog.setButton(android.support.v7.app.AlertDialog.BUTTON_NEGATIVE, context.getString(R.string.btn_cancel), new DialogInterface.OnClickListener() {
            @Override
            public void onClick(DialogInterface dialog, int which) {
                alertDialog.dismiss();
            }
        });
        alertDialog.show();
    }
}
