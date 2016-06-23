package com.example.common.util;

import android.content.Context;
import android.content.SharedPreferences;
import android.content.SharedPreferences.Editor;

public class PreferenceUtils {
    public static final String DEFAULT_PREF_NAME = "pref";

    public static String getPrefString(Context context, String key,
                                       final String defaultValue) {
        final SharedPreferences settings = context.getSharedPreferences(
                DEFAULT_PREF_NAME, Context.MODE_PRIVATE);
        return settings.getString(key, defaultValue);
    }

    public static void setPrefString(Context context, final String key,
                                     final String value) {
        final SharedPreferences settings = context.getSharedPreferences(
                DEFAULT_PREF_NAME, Context.MODE_PRIVATE);
        Editor editor = settings.edit();
        editor.putString(key, value);
        editor.commit();
    }

    public static String[] getPrefStrings(Context context, String key) {
        String regularEx = "#";
        String[] str = null;
        SharedPreferences sp = context.getSharedPreferences(DEFAULT_PREF_NAME, Context.MODE_PRIVATE);
        String values;
        values = sp.getString(key, "");
        str = values.split(regularEx);
        return str;
    }

    public static void setPrefStrings(Context context, String key, String[] values) {
        String regularEx = "#";
        String str = "";
        SharedPreferences sp = context.getSharedPreferences(DEFAULT_PREF_NAME, Context.MODE_PRIVATE);
        if (values != null && values.length > 0) {
            for (String value : values) {
                str += value;
                str += regularEx;
            }
            Editor et = sp.edit();
            et.putString(key, str);
            et.commit();
        }
    }

    public static boolean getPrefBoolean(Context context, final String key,
                                         final boolean defaultValue) {
        final SharedPreferences settings = context.getSharedPreferences(
                DEFAULT_PREF_NAME, Context.MODE_PRIVATE);
        return settings.getBoolean(key, defaultValue);
    }

    public static boolean hasKey(Context context, final String key) {
        return context.getSharedPreferences(
                DEFAULT_PREF_NAME, Context.MODE_PRIVATE)
                .contains(key);
    }

    public static void setPrefBoolean(Context context, final String key,
                                      final boolean value) {
        final SharedPreferences settings = context.getSharedPreferences(
                DEFAULT_PREF_NAME, Context.MODE_PRIVATE);
        Editor editor = settings.edit();
        editor.putBoolean(key, value);
        editor.commit();
    }

    public static void setPrefInt(Context context, final String key,
                                  final int value) {
        final SharedPreferences settings = context.getSharedPreferences(
                DEFAULT_PREF_NAME, Context.MODE_PRIVATE);
        Editor editor = settings.edit();
        editor.putInt(key, value);
        editor.commit();
    }

    public static int getPrefInt(Context context, final String key,
                                 final int defaultValue) {
        final SharedPreferences settings = context.getSharedPreferences(
                DEFAULT_PREF_NAME, Context.MODE_PRIVATE);
        return settings.getInt(key, defaultValue);
    }

    public static void setPrefFloat(Context context, final String key,
                                    final float value) {
        final SharedPreferences settings = context.getSharedPreferences(
                DEFAULT_PREF_NAME, Context.MODE_PRIVATE);
        Editor editor = settings.edit();
        editor.putFloat(key, value);
        editor.commit();
    }

    public static float getPrefFloat(Context context, final String key,
                                     final float defaultValue) {
        final SharedPreferences settings = context.getSharedPreferences(
                DEFAULT_PREF_NAME, Context.MODE_PRIVATE);
        return settings.getFloat(key, defaultValue);
    }

    public static void setSettingLong(Context context, final String key,
                                      final long value) {
        final SharedPreferences settings = context.getSharedPreferences(
                DEFAULT_PREF_NAME, Context.MODE_PRIVATE);
        Editor editor = settings.edit();
        editor.putLong(key, value);
        editor.commit();
    }

    public static long getPrefLong(Context context, final String key,
                                   final long defaultValue) {
        final SharedPreferences settings = context.getSharedPreferences(
                DEFAULT_PREF_NAME, Context.MODE_PRIVATE);
        return settings.getLong(key, defaultValue);
    }

    public static void clearPreference(Context context,
                                       final SharedPreferences p) {
        final Editor editor = p.edit();
        editor.clear();
        editor.commit();
    }

}
