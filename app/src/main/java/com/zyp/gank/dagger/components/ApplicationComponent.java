package com.zyp.gank.dagger.components;

import android.content.Context;


import com.zyp.data.service.ServiceManager;
import com.zyp.domain.GankRepository;
import com.zyp.domain.executor.PostExecutionThread;
import com.zyp.domain.executor.ThreadExecutor;
import com.zyp.gank.GankApp;
import com.zyp.gank.base.BaseActivity;
import com.zyp.gank.dagger.modules.ApplicationModule;
import com.zyp.gank.event.RxBus;

import javax.inject.Singleton;

import dagger.Component;

/**
 * A component whose lifetime is the life of the application.
 */
@Singleton // Constraints this component to one-per-application or unscoped bindings.
@Component(modules = ApplicationModule.class)
public interface ApplicationComponent {

    void inject(GankApp sweatMoneyApp);
    
    void inject(BaseActivity baseActivity);

    Context context();

    ThreadExecutor threadExecutor();
    
    PostExecutionThread postExecutionThread();

    RxBus rxBus();

    ServiceManager serviceManager();

    GankRepository gankRepository();
}
