package com.example.common.util;

import java.math.BigDecimal;
import java.text.NumberFormat;
import java.text.SimpleDateFormat;
import java.util.Date;

/**
 * Created by zyp on 2016/3/31.
 */
public class FormatUtils {
    private NumberFormat mFormat;
    private NumberFormat dFormat;
    private NumberFormat iFormat;
    private SimpleDateFormat timeFormatter;
    private SimpleDateFormat dateFormatter;
    private SimpleDateFormat dateAndTimeFormatter;
    private volatile static FormatUtils singleton;

    private FormatUtils() {
        mFormat = NumberFormat.getInstance();
        mFormat.setMaximumFractionDigits(2);
        mFormat.setMinimumFractionDigits(2);
        dFormat = NumberFormat.getPercentInstance();
        dFormat.setMaximumFractionDigits(2);
        dFormat.setMinimumFractionDigits(2);
        iFormat = NumberFormat.getIntegerInstance();
        timeFormatter = new SimpleDateFormat("HH:mm:ss");
        dateFormatter = new SimpleDateFormat("yyyy-MM-dd");
        dateAndTimeFormatter = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
    }

    public static FormatUtils getInstance() {
        if (singleton == null) {
            synchronized (FormatUtils.class) {
                if (singleton == null) {
                    singleton = new FormatUtils();
                }
            }
        }
        return singleton;
    }

    public NumberFormat getFormat() {
        return mFormat;
    }

    public String formatSimpleNumber(float num) {
        String numString;
        if (num > 10000 || num < -10000) {
            numString = mFormat.format(num / 10000) + "万";
        } else {
            if (num == 0) {
                return "0";
            } else {
                numString = mFormat.format(num);
            }
        }

        return numString;
    }

    public String formatNumberShowWithNum(float num) {
        String numString;
        if (num == 0) {
            return "0.00";
        } else {
            numString = mFormat.format(num);
        }
        return numString;
    }

    public String formatNumberAbsTotal(float num) {
        num = Math.abs(num);
        return mFormat.format(num);
    }

    public String formatNumberTotal(float num) {
        return mFormat.format(num);
    }

    public String formatNumberPercent(float num) {
        if (num > 10000 || num < -10000) {
            return mFormat.format(num / 10000) + "万%";
        }
        return dFormat.format(num);
    }


    public String formatAbsoluteNumber(float num) {
        String numString;
        num = Math.abs(num);
        if (num > 10000 || num < 10000) {
            numString = mFormat.format(num / 10000) + "万";
        } else {
            if (num == 0) {
                return "0";
            } else {
                numString = mFormat.format(num);
            }
        }

        return numString;
    }

    public String formatNumberInteger(float num) {
        return iFormat.format(num);
    }

    public String formatTime(long time) {
        return timeFormatter.format(new Date(time));
    }
    public String formatTime(Date date) {
        return timeFormatter.format(date);
    }

    public String formatDate(Date date){
        return dateFormatter.format(date);
    }

    public String formatDateAndTime(Date date){
        return dateAndTimeFormatter.format(date);
    }


    /**
     * 将指定的字符串转换成制定小数点位数的String字符串
     *
     * @param d
     * @param scales
     * @return
     */
    public String formatChange(float d, float scales) {
        String dStr = String.valueOf(d);
        String scalesStr = String.valueOf(scales);
        if(Math.floor(scales) == scales){
            scalesStr = "0";
        }
        BigDecimal bd1 = new BigDecimal(dStr);
        BigDecimal bd2 = new BigDecimal(scalesStr);
        bd1 = bd1.setScale(bd2.scale(), BigDecimal.ROUND_HALF_UP);

        return bd1.toString();
    }

    /**
     * 将指定的字符串转换成制定小数点位数的String字符串
     *
     * @param d
     * @param scales
     * @return
     */
    public String formatChange(String d, String scales) {
        BigDecimal bd1 = new BigDecimal(d);
        BigDecimal bd2 = new BigDecimal(scales);
        bd1 = bd1.setScale(bd2.scale(), BigDecimal.ROUND_HALF_UP);
        return subZeroAndDot(bd1.toString());
    }

    /**
     * 使用java正则表达式去掉多余的.与0
     *
     * @param s
     * @return
     */
    public static String subZeroAndDot(String s) {
        if (s.indexOf(".") > 0) {
            s = s.replaceAll("0+?$", "");//去掉多余的0
            s = s.replaceAll("[.]$", "");//如最后一位是.则去掉
        }
        return s;
    }

    public String formatNNameOrTel(String nname){
        if(Utils.validatePhoneNumber(nname)){
            StringBuffer formatPhoneNumber = new StringBuffer(nname);
            formatPhoneNumber = formatPhoneNumber.replace(3,7,"****");
            return formatPhoneNumber.toString();
        }else{
            return nname;
        }
    }
}
