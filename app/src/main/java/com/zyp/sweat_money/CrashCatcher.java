package com.zyp.sweat_money;

import android.app.Application;
import android.content.Intent;
import android.content.pm.PackageManager;


/**
 * Created by Henry on 2015/12/8.
 */
public class CrashCatcher implements Thread.UncaughtExceptionHandler {

    public static final String TAG = "CrashCatcher";

    private Thread.UncaughtExceptionHandler mDefaultHandler;

    private Application application;

    public CrashCatcher(Application application) {
        mDefaultHandler = Thread.getDefaultUncaughtExceptionHandler();
        this.application = application;
    }

    private boolean handleException(Throwable ex) {
        if (ex == null) {
            return false;
        }


        return true;
    }

    @Override
    public void uncaughtException(Thread thread, Throwable e) {
        if (e == null && mDefaultHandler != null) {
            mDefaultHandler.uncaughtException(thread, e);
        } else {
            e.printStackTrace();

            PackageManager packageManager = application.getPackageManager();
            Intent intent = packageManager.getLaunchIntentForPackage(application.getPackageName());
            intent.addFlags(Intent.FLAG_ACTIVITY_CLEAR_TOP);
            intent.setAction(MainActivity.ACTION_RESTART);
            
//            PendingIntent restartIntent = PendingIntent.getActivity(application,
//                    0, intent, PendingIntent.FLAG_UPDATE_CURRENT);
//            AlarmManager am = (AlarmManager) application.getSystemService(Context.ALARM_SERVICE);
//            am.set(AlarmManager.RTC, System.currentTimeMillis(), restartIntent);

//            System.exit(0);
       }
    }
}
