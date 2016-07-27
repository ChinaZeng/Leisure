package com.zzw.MyApp.utils;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;
import java.util.Locale;

/**
 * Created by zzw on 2016/7/1.
 * 描述:
 */
public class DateUtils {

    public final static String dateFormat = "yyyy-MM-dd";
    public final static String dateFormat2 = "yyyy-MM-dd HH:mm:ss";

    public final static String defaultFormat = dateFormat2;

    /**
     * 获取年月日
     *
     * @return
     */
    public static int[] getYMD() {
        int[] dates = new int[3];
        Calendar c = Calendar.getInstance();
        dates[0] = c.get(Calendar.YEAR);
        dates[1] = c.get(Calendar.MONTH) + 1;
        dates[2] = c.get(Calendar.DAY_OF_MONTH);
        return dates;
    }

    public static String formatDate(Date date) {
        return formatDate(date, null);
    }

    public static String formatDate(Date date, String pattern) {
        if (date == null) {
            return "";
        }
        if (pattern == null || "".equals(pattern)) {
            pattern = defaultFormat;
        }
        SimpleDateFormat simpleDateFormat = new SimpleDateFormat(pattern, Locale.CHINA);
        return simpleDateFormat.format(date);
    }

    public static Date parseDate(String date) {
        return parseDate(date, null);
    }

    public static Date parseDate(String date, String pattern) {
        if (date == null) {
            return null;
        }
        if (pattern == null || "".equals(pattern)) {
            pattern = defaultFormat;
        }
        SimpleDateFormat simpleDateFormat = new SimpleDateFormat(pattern, Locale.CHINA);
        try {
            return simpleDateFormat.parse(date);
        } catch (ParseException e) {
            return null;
        }
    }

    public static int getAge(String date) {

        String data[] = date.split("-");
        Calendar calendar = Calendar.getInstance();
        int year = calendar.get(Calendar.YEAR);

        return year - Integer.valueOf(data[0]);
    }


    /**
     * 将字符串类型时间转换为long值
     *
     * @param strTime
     * @param formatType
     * @return
     */
    public static long stringToLong(String strTime, String formatType) {

        Date date = null; // String类型转成date类型
        try {
            date = stringToDate(strTime, formatType);
        } catch (ParseException e) {
            e.printStackTrace();
        }
        if (date == null) {
            return 0;
        } else {
            long currentTime = dateToLong(date); // date类型转成long类型
            return currentTime;
        }
    }

    /**
     * 将字符串类型时间转换为Data类型时间
     *
     * @param strTime
     * @param formatType
     * @return
     * @throws ParseException
     */
    public static Date stringToDate(String strTime, String formatType) throws ParseException {
        SimpleDateFormat formatter = new SimpleDateFormat(formatType);
        Date date = formatter.parse(strTime);
        return date;
    }

    /**
     * 将data类型时间转换为long值
     *
     * @param date
     * @return
     */
    public static long dateToLong(Date date) {
        return date.getTime();
    }
}
