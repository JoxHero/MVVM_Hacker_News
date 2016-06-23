package com.zyp.gank;

import android.app.Activity;
import android.app.Application;
import android.content.Context;
import android.content.SharedPreferences;
import android.net.Uri;
import android.os.Bundle;
import android.util.Log;

import com.example.common.util.Utils;
import com.squareup.leakcanary.LeakCanary;
import com.squareup.leakcanary.RefWatcher;
import com.squareup.leakcanary.analyzer.BuildConfig;
import com.squareup.picasso.OkHttpDownloader;
import com.squareup.picasso.Picasso;
import com.zyp.domain.executor.PostExecutionThread;
import com.zyp.domain.executor.ThreadExecutor;
import com.zyp.gank.dagger.components.ApplicationComponent;

import com.zyp.gank.dagger.components.DaggerApplicationComponent;
import com.zyp.gank.dagger.modules.ApplicationModule;


import java.util.concurrent.CountDownLatch;

import javax.inject.Inject;

/**
 * Created by zyp on 2016/5/5.
 */
public class GankApp extends Application {
    public static final String TAG = "GankApp";
    public static final String PREFERENCES_NAME = "com.zyp.gank";
    public static final String LAST_CRASH_TIME = "last_crash_time";
    public static final String IS_FIRST = "is_first";
    @Inject
    ThreadExecutor threadExecutor;
    @Inject
    PostExecutionThread postExecutionThread;

    private Picasso picasso;

/*    private SharedPreferences preferences;
    private SharedPreferences.Editor editor;*/
    private ApplicationComponent applicationComponent;
   /* private CountDownLatch initLatch = new CountDownLatch(4);
    private RefWatcher refWatcher;*/
   private boolean inBackground = false;

    /**
     * method that kills the current process.
     * It is used after restarting or killing the app.
     */
    public static void killCurrentProcess() {
        android.os.Process.killProcess(android.os.Process.myPid());
        System.exit(10);
    }

    @Override
    public void onCreate() {
        super.onCreate();
        /*preferences = getSharedPreferences(PREFERENCES_NAME, Context.MODE_PRIVATE);
        editor = preferences.edit();*/
        registerCallbacks();
        initialize();


        if (!BuildConfig.DEBUG) {
           CrashCatcher crashCatcher = new CrashCatcher(this);
            Thread.setDefaultUncaughtExceptionHandler(crashCatcher);
        }

        initializeLeakDetection();
    }

    private void registerCallbacks() {
        registerActivityLifecycleCallbacks(new ActivityLifecycleCallbacks() {
            int currentlyStartedActivities = 0;

            @Override
            public void onActivityCreated(Activity activity, Bundle savedInstanceState) {
            }

            @Override
            public void onActivityStarted(Activity activity) {
                currentlyStartedActivities++;
                inBackground = (currentlyStartedActivities == 0);
            }

            @Override
            public void onActivityResumed(Activity activity) {
            }

            @Override
            public void onActivityPaused(Activity activity) {
            }

            @Override
            public void onActivityStopped(Activity activity) {
                currentlyStartedActivities--;
                inBackground = (currentlyStartedActivities == 0);
            }

            @Override
            public void onActivitySaveInstanceState(Activity activity, Bundle outState) {
            }

            @Override
            public void onActivityDestroyed(Activity activity) {
            }
        });
    }

    public void initialize() {
        initializeInjector();
        initializeImageDownloader();
    }

    private void initializeInjector() {
        applicationComponent =
                DaggerApplicationComponent.builder().applicationModule(new ApplicationModule(this)).build();

        applicationComponent.inject(this);
    }

    private void initializeLeakDetection() {
        if (BuildConfig.DEBUG) {
            LeakCanary.install(this);
        }
    }

    public ApplicationComponent getApplicationComponent() {
        return applicationComponent;
    }

    public boolean isInBackground() {
        return inBackground;
    }

    private void initializeImageDownloader() {
        Context applicationContext = getApplicationContext();
        picasso = new Picasso.Builder(applicationContext)
                .downloader(new OkHttpDownloader(Utils.getImageCacheFile(applicationContext)))
                .listener(new Picasso.Listener() {
                    @Override
                    public void onImageLoadFailed(Picasso picasso, Uri uri, Exception e) {
                        Log.e("TradeKingApp", "Failed to load image:" + uri);
                    }
                })
                .build();
    }

    public Picasso getImageLoader() {
        if (picasso == null) {
            initializeImageDownloader();
        }

        return picasso;
    }

    public void resetImageLoader() {
        if (picasso != null) {
            picasso.shutdown();
            picasso = null;
        }
    }
}
