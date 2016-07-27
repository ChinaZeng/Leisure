package com.zzw.MyApp.utils;

import android.content.Context;

import com.zzw.MyApp.R;

import java.io.UnsupportedEncodingException;
import java.util.List;
import java.util.UUID;

/**
 * Created by zzw on 2016/7/7.
 * 描述:
 */
public class StringUtils {


    public static String getUtf_8String(String s) {

        if (s == null)
            return null;

        try {
            return new String(s.getBytes("utf-8"), "utf-8");
        } catch (UnsupportedEncodingException e) {
            e.printStackTrace();
            return null;
        }
    }


    public static String getUUID() {
        String s = UUID.randomUUID().toString();
        return s.substring(0, 8) + s.substring(9, 13) + s.substring(14, 18) + s.substring(19, 23) + s.substring(24);//去掉“-”符号
    }

    public static String getStringFromList(Context context, List<String> datas) {
        StringBuffer buffer = new StringBuffer();

        for (int i = 0; i < datas.size(); i++) {
            if (datas.get(i).endsWith("。"))
                buffer.append(context.getString(R.string.text_, datas.get(i)) + "\n");
        }
        return buffer.toString();
    }
}
