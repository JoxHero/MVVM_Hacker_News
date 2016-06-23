package com.zyp.gank;

import android.app.AlarmManager;
import android.app.PendingIntent;
import android.content.Context;
import android.content.Intent;
import android.content.pm.PackageManager;

import com.zyp.gank.GankApp;

/**
 * Created by Henry on 2015/12/8.
 */
public class CrashCatcher implements Thread.UncaughtExceptionHandler {

    public static final String TAG = "CrashCatcher";

    private GankApp application;
    private Thread.UncaughtExceptionHandler defaultHandler;

    public CrashCatcher(GankApp application) {
        this.application = application;
        defaultHandler = Thread.getDefaultUncaughtExceptionHandler();
    }

    @Override
    public void uncaughtException(Thread thread, Throwable throwable) {
        if (throwable == null && defaultHandler != null) {
            defaultHandler.uncaughtException(thread, throwable);
        } else {
            if (!application.isInBackground()) {
//                Intent intent = new Intent(application, MainActivity.class);
//                intent.addFlags(Intent.FLAG_ACTIVITY_CLEAR_TOP);
//                intent.setAction(MainActivity.ACTION_ON_CRASH);
//
//                PendingIntent restartIntent = PendingIntent.getActivity(application,
//                        0, intent, PendingIntent.FLAG_UPDATE_CURRENT);
//                AlarmManager amGankApp = (AlarmManager) application.getSystemService(Context.ALARM_SERVICE);
//                am.set(AlarmManager.RTC, System.currentTimeMillis(), restartIntent);

                PackageManager packageManager = application.getPackageManager();
                Intent restart = packageManager.getLaunchIntentForPackage(application.getPackageName());
                restart.addFlags(Intent.FLAG_ACTIVITY_NEW_TASK | Intent.FLAG_ACTIVITY_CLEAR_TOP);

                PendingIntent pendingIntent = PendingIntent.getActivity(application,
                        0, restart, PendingIntent.FLAG_UPDATE_CURRENT);
                AlarmManager am = (AlarmManager) application.getSystemService(Context.ALARM_SERVICE);
                am.set(AlarmManager.RTC, System.currentTimeMillis() + 2000, pendingIntent);
            }
            GankApp.killCurrentProcess();
        }
    }

}
