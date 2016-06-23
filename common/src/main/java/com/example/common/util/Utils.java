package com.example.common.util;

import android.Manifest;
import android.annotation.SuppressLint;
import android.content.Context;
import android.content.pm.PackageInfo;
import android.content.pm.PackageManager;
import android.graphics.Bitmap;
import android.net.ConnectivityManager;
import android.net.NetworkInfo;
import android.os.Build;
import android.os.Environment;

import android.telephony.TelephonyManager;
import android.text.TextUtils;
import android.util.DisplayMetrics;
import android.util.TypedValue;
import android.view.WindowManager;


import com.example.common.Constants;

import java.io.BufferedOutputStream;
import java.io.Closeable;
import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.util.Random;

/**
 * Created by Henry on 2015/11/12.
 */
public class Utils {

    private Utils() {
    }

    static void closeQuietly(Closeable closeable) {
        if (closeable == null) return;
        try {
            closeable.close();
        } catch (IOException ignored) {
        }
    }

    public static String generateVerificationCode() {
        int max = 9999;
        int min = 1000;
        Random random = new Random();
        int randomNumber = random.nextInt(max) % (max - min) + min;

        return randomNumber + "";
    }

    public static boolean validatePhoneNumber(String phoneNumber) {
        //        String regExp = "^((13[0-9])|(15[^4,\\D])|(18[0,5-9]))\\d{8}$";
        //        Pattern p = Pattern.compile(regExp);
        //        Matcher m = p.matcher(phoneNumber);
        //
        //        return m.find();
        return phoneNumber.matches("^((13[0-9])|(15[^4,\\D])|(18[0,5-9]))\\d{8}$");
    }

    public static String getDeviceId(Context context) {
        TelephonyManager telephonyManager = (TelephonyManager) context.getSystemService(
                Context.TELEPHONY_SERVICE);
        if (telephonyManager != null) {

            return telephonyManager.getDeviceId();
        }

        return "not-found";
    }

    @SuppressLint("NewApi")
    public static boolean checkPermission(Context context, String permission) {
        boolean result = false;
        if (Build.VERSION.SDK_INT >= 23) {
            if (context.checkSelfPermission(permission) == PackageManager.PERMISSION_GRANTED) {
                result = true;
            }
        } else {
            PackageManager pm = context.getPackageManager();
            if (pm.checkPermission(permission, context.getPackageName()) == PackageManager.PERMISSION_GRANTED) {
                result = true;
            }
        }
        return result;
    }

    public static String getDeviceInfo(Context context) {
        try {
            org.json.JSONObject json = new org.json.JSONObject();
            TelephonyManager tm = (TelephonyManager) context
                    .getSystemService(Context.TELEPHONY_SERVICE);
            String device_id = null;
            if (checkPermission(context, Manifest.permission.READ_PHONE_STATE)) {
                device_id = tm.getDeviceId();
            }
            android.net.wifi.WifiManager wifi = (android.net.wifi.WifiManager) context
                    .getSystemService(Context.WIFI_SERVICE);
            String mac = wifi.getConnectionInfo().getMacAddress();
            json.put("mac", mac);
            if (TextUtils.isEmpty(device_id)) {
                device_id = mac;
            }
            if (TextUtils.isEmpty(device_id)) {
                device_id = android.provider.Settings.Secure.getString(context.getContentResolver(),
                        android.provider.Settings.Secure.ANDROID_ID);
            }
            json.put("device_id", device_id);
            return json.toString();
        } catch (Exception e) {
            e.printStackTrace();
        }
        return null;
    }

    public static String getMqttClientId(Context context, String tag) {
        StringBuilder builder = new StringBuilder();
        builder.append(getDeviceId(context)).append(System.nanoTime()).append(tag);

        return MD5.getMessageDigest(builder.toString());
    }

    public static boolean hasSDCard() {
        return Environment.MEDIA_MOUNTED.equals(Environment.getExternalStorageState());
    }

   /* public static boolean checkSelfPermissionGranted(Context context, String permission) {

        return ContextCompat.checkSelfPermission(context, permission) == PackageManager.PERMISSION_GRANTED;
    }*/

    /**
     * 拿到项目SD卡路径
     */
    public static String getAppPath() {
        if (Environment.getExternalStorageState().equals(Environment.MEDIA_MOUNTED)) {
            File sd = Environment.getExternalStorageDirectory();
            String filePath = sd.getAbsolutePath() + File.separator + "tradeking";
            File file = new File(filePath);
            if (!file.exists()) {
                file.mkdir();
            }

            return file.getPath();
        }

        return null;
    }

    public static File getAppCacheFile(Context context) {
        File cacheDir;
        if (Environment.getExternalStorageState().equals(Environment.MEDIA_MOUNTED)) {
            cacheDir = context.getApplicationContext().getExternalCacheDir();
        } else {
            cacheDir = context.getApplicationContext().getCacheDir();
        }

        return cacheDir;
    }

    public static String getAppCachePath(Context context) {

        return getAppCacheFile(context).getPath();
    }

    public static File getImageCacheFile(Context context) {
        File cache = new File(getAppCacheFile(context), Constants.DEFAULT_IMAGE_CACHE);
        if (!cache.exists()) {
            cache.mkdirs();
        }

        return cache;
    }

    public static String getAvatarUrlByUid(long uid) {

        return String.format(Constants.Url.AVATAR, uid);
    }

    /**
     * 拿到项目二维码路径
     */
    public static File getQRCodeFile(Context context, long uid) {

        return new File(getAppCacheFile(context), getORCodeFileNameByUid(uid));
    }

    public static String getORCodeFileNameByUid(long uid) {

        return new StringBuilder("qrcode").append('_').append(uid).append(".jpg").toString();
    }
    
    /*public static String getQRCodeFile(String uid, Context context) {

        String filePath = getAppCachePath(context);
        File file = new File(filePath + File.separator+  "qrcode" + uid +
        ".jpg");
        if (!file.exists()) {
            file.mkdirs();
        }
        return filePath;

    }*/

    public static boolean saveAvToSDCard(Bitmap bitmap, String fileName, Context context) {
        if (hasSDCard()) {
            BufferedOutputStream bos = null;
            // 获取私有的Cache缓存目录
            File file = new File(getAppCachePath(context));
            /*if (!file.exists()) {
                file.mkdirs();
            }else{
                file.delete();
                file.mkdirs();
            }*/
            try {
                bos = new BufferedOutputStream(new FileOutputStream(new File(file, fileName)));
                if (fileName != null && (fileName.contains(".png") || fileName.contains(".PNG") ||
                        fileName.contains((".jpg")))) {
                    bitmap.compress(Bitmap.CompressFormat.PNG, 90, bos);
                } else {
                    bitmap.compress(Bitmap.CompressFormat.JPEG, 90, bos);
                }
                bos.flush();
            } catch (Exception e) {
                e.printStackTrace();
            } finally {
                if (bos != null) {
                    try {
                        bos.close();
                    } catch (IOException e) {
                        e.printStackTrace();
                    }
                }
            }
            return true;
        } else {
            return false;
        }
    }

    /**
     * dp转px
     *
     * @param context
     * @param dp
     * @return
     */
    public static int dp2px(Context context, float dp) {
        return (int) TypedValue.applyDimension(TypedValue.COMPLEX_UNIT_DIP,
                dp, context.getResources().getDisplayMetrics());
    }

//    /**
//     * 获得屏幕宽度
//     *
//     * @param context
//     * @return
//     */
//    public static int getScreenWidth(Context context) {
//        WindowManager wm = (WindowManager) context
//                .getSystemService(Context.WINDOW_SERVICE);
//        DisplayMetrics outMetrics = new DisplayMetrics();
//        wm.getDefaultDisplay().getMetrics(outMetrics);
//        return outMetrics.widthPixels;
//    }

    /**
     * 获取版本名
     *
     * @param context
     * @return
     */
    public static String getVersionName(Context context) {
        return getPackageInfo(context).versionName;
    }

    /**
     * 获取版本号
     *
     * @param context
     * @return
     */
    public static int getVersionCode(Context context) {
        return getPackageInfo(context).versionCode;
    }

    private static PackageInfo getPackageInfo(Context context) {
        PackageInfo pi = null;

        try {
            PackageManager pm = context.getPackageManager();
            pi = pm.getPackageInfo(context.getPackageName(),
                    PackageManager.GET_CONFIGURATIONS);

            return pi;
        } catch (Exception e) {
            e.printStackTrace();
        }

        return pi;
    }

    private static int width, height;

    public static void getWidthAndHeight(Context context) {
        WindowManager wm = (WindowManager) context
                .getSystemService(Context.WINDOW_SERVICE);
        DisplayMetrics dm = new DisplayMetrics();
        wm.getDefaultDisplay().getMetrics(dm);

        width = dm.widthPixels;
        height = dm.heightPixels;
    }

    public static int getScreenWidth(Context context) {
        if (width <= 0) {
            getWidthAndHeight(context);
        }
        return width;
    }

    public static int getScreenHeight(Context context) {
        if (height <= 0) {
            getWidthAndHeight(context);
        }
        return height;
    }

    /**
     * 判断是否联网
     * @param ctx
     * @return
     */
    public static boolean isNetworkAvailable(Context ctx) {
        ConnectivityManager cm = (ConnectivityManager) ctx
                .getSystemService(Context.CONNECTIVITY_SERVICE);
        NetworkInfo info = cm.getActiveNetworkInfo();
        return (info != null && info.isConnected());
    }

}
