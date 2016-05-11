package com.zyp.sweat_money.dagger.components;

import android.content.Context;


import com.zyp.sweat_money.SweatMoneyApp;
import com.zyp.sweat_money.base.BaseActivity;
import com.zyp.sweat_money.dagger.modules.ApplicationModule;
import com.zyp.sweat_money.event.RxBus;
import com.zyp.sweat_money.executor.PostExecutionThread;
import com.zyp.sweat_money.executor.ThreadExecutor;

import javax.inject.Singleton;

import dagger.Component;

/**
 * A component whose lifetime is the life of the application.
 */
@Singleton // Constraints this component to one-per-application or unscoped bindings.
@Component(modules = ApplicationModule.class)
public interface ApplicationComponent {

    void inject(SweatMoneyApp sweatMoneyApp);
    
    void inject(BaseActivity baseActivity);

    Context context();

    ThreadExecutor threadExecutor();
    
    PostExecutionThread postExecutionThread();

    RxBus rxBus();
}
