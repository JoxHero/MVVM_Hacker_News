package com.example.common.util;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;

/**
 * Created zyp on 2016/1/7.
 */
public class DateUtils {

    public static final int SIGN_DYNAMIC = 1;
    public static final int SIGN_TRADE = 2;
    /**
     * 英文简写（默认）如：2010-12-01
     */

    public static String FORMAT_SHORT = "yyyy-MM-dd";

    /**
     * 英文全称  如：2010-12-01 23:15:06
     */

    public static String FORMAT_LONG = "yyyy-MM-dd HH:mm:ss";

    /**
     * 精确到毫秒的完整时间    如：yyyy-MM-dd HH:mm:ss.S
     */

    public static String FORMAT_FULL = "yyyy-MM-dd HH:mm:ss.S";

    /**
     * 中文简写  如：2010年12月01日
     */

    public static String FORMAT_SHORT_CN = "yyyy年MM月dd";

    /**
     * 中文全称  如：2010年12月01日  23时15分06秒
     */

    public static String FORMAT_LONG_CN = "yyyy年MM月dd日  HH时mm分ss秒";

    /**
     * 精确到毫秒的完整中文时间
     */

    public static String FORMAT_FULL_CN = "yyyy年MM月dd日  HH时mm分ss秒SSS毫秒";


    /**
     * 获取时间戳
     */
    public static long getTimeString(String time) {
        SimpleDateFormat format = new SimpleDateFormat(FORMAT_SHORT);
        Date date = null;
        try {
            date = format.parse(time);
        } catch (ParseException e) {
            e.printStackTrace();
        }
        return date.getTime();

    }

    /**
     * 获得"yyyy-MM-dd"格式的时间
     *
     * @param timeDate
     * @return
     */
    public static String timeStampToDateChinese(long timeDate) {
        SimpleDateFormat sdf = new SimpleDateFormat(FORMAT_SHORT_CN);
        String sd = sdf.format(new Date(timeDate));
        return sd;
    }

    /**
     * 获得"年-月-日"格式的时间
     *
     * @param timeDate
     * @return
     */
    public static String timeStampToDate(long timeDate) {
        SimpleDateFormat sdf = new SimpleDateFormat(FORMAT_SHORT);
        String sd = sdf.format(new Date(timeDate));
        return sd;
    }

    /**
     * 自定义格式时间戳转换
     *
     * @param timeDate
     * @return
     */
    public static String timeStampToDate(long timeDate, String format) {
        SimpleDateFormat sdf = new SimpleDateFormat(format);
        String sd = sdf.format(new Date(timeDate));
        return sd;
    }


    /**
     * 获取日期年份
     *
     * @param date 日期
     */

    public static int getYear(Date date) {
        SimpleDateFormat sdf = new SimpleDateFormat(FORMAT_SHORT);
        return Integer.parseInt(sdf.format(date).substring(0, 4));
    }

    /**
     * 功能描述：返回月
     *
     * @param date Date 日期
     * @return 返回月份
     */

    public static int getMonth(Date date) {

        Calendar calendar = Calendar.getInstance();

        calendar.setTime(date);

        return calendar.get(Calendar.MONTH) + 1;
    }

    /**
     * 功能描述：返回日
     *
     * @param date Date 日期
     * @return 返回日份
     */

    public static int getDay(Date date) {

        Calendar calendar = Calendar.getInstance();

        calendar.setTime(date);

        return calendar.get(Calendar.DAY_OF_MONTH);
    }

    /**
     * 以友好的方式显示时间
     *
     * @param time
     * @return
     */
    public static String getFriendlyTime(long time) {
        long before = ((System.currentTimeMillis() - time) / 1000);
        if (before < 3600L) {
            return String.format("%1$d 分钟前", Math.max(before / 60, 1));
        }
        if (before >= 3600 && before < 86400) {
            return String.format("%1$d 小时前", before / 3600);
        }
        if (before >= 86400 && before < 2592000) { //86400 * 30
            long day = before / 86400;
            return (day > 1) ? String.format("%1$d 天前", day) : "昨天";
        }
        if (before >= 2592000 && before < 31104000) {//86400 * 30
            return String.format("%1$d 月前", before / 2592000);
        }

        return String.format("%1$d 年前", before / 31104000);
    }

    /**
     * 按照持仓时间格式，格式化时间
     *
     * @param time
     * @return
     */
    public static String getPositionTime(long time, int sign) {
        int month;
        int day;
        int hour;
        int minute = (int) time / 60;
        String sTime = null;
        if (time == 0) {
            return null;
        } else if (minute < 1) {
           /* if (sign == SIGN_TRADE) {
                sTime = "不足1分钟";
            } else {
                sTime = "小于1分钟";
            }*/
            sTime = "不足1分钟";
        } else if (minute >= 1 && minute < 60) {
            sTime = minute + "分钟";
        } else if (minute >= 60 && minute < 1440) {
            hour = minute / 60;
            sTime =  hour + "小时";
            //
           /* minute = minute % 60;
             if (minute > 0) {
                sTime = hour + "小时" + minute + "分钟";
            } else {
                sTime = hour + "小时";
            }*/
        } else if (minute >= 1440 && minute < 43200) {
            day = minute / 1440;
            sTime = day + "天";
           /*
            minute = minute % 1440;
           hour = minute / 60;
           if (hour > 0) {
                sTime = day + "天" + day + "小时";
            } else {
                sTime = day + "天";
            }*/
        } else if (minute >= 43200) {
            month = minute / 43200;
            sTime = month + "月";
            /*
             minute = minute % 43200;
            day = minute / 1440;
            if (day > 0) {
                sTime = month + "月" + day + "天";
            } else {
                sTime = month + "月";
            }*/
        }
        if (sign == SIGN_DYNAMIC) {
            return " ，持仓" + sTime;
        }
        return sTime;
    }

    /**
     * 按照持仓时间格式，格式化时间
     *
     * @param time
     * @return
     */
    public static String getFormatTime(float time, int sign) {

        long timeLong = Long.parseLong(String.valueOf(Math.round(time)));
        return getPositionTime(timeLong, sign);
    }

}
