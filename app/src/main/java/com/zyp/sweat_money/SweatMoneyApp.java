package com.zyp.sweat_money;

import android.app.Application;

import com.squareup.leakcanary.RefWatcher;
import com.zyp.sweat_money.dagger.components.ApplicationComponent;
import com.zyp.sweat_money.dagger.components.DaggerApplicationComponent;
import com.zyp.sweat_money.dagger.modules.ApplicationModule;

/**
 * Created by zyp on 2016/5/5.
 */
public class SweatMoneyApp extends Application {
    private ApplicationComponent applicationComponent;
    private RefWatcher refWatcher;
    @Override
    public void onCreate() {
        super.onCreate();
        initialize();
    }

    public void initialize(){
        initializeInjector();
    }

    private void initializeInjector() {
        applicationComponent =
                DaggerApplicationComponent.builder().applicationModule(new ApplicationModule(this)).build();

        applicationComponent.inject(this);
    }

    public ApplicationComponent getApplicationComponent() {
        return applicationComponent;
    }
}
