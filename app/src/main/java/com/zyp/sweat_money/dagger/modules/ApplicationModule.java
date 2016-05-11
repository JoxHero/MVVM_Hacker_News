package com.zyp.sweat_money.dagger.modules;

import android.content.Context;

import com.zyp.sweat_money.SweatMoneyApp;
import com.zyp.sweat_money.event.RxBus;
import com.zyp.sweat_money.executor.JobExecutor;
import com.zyp.sweat_money.executor.PostExecutionThread;
import com.zyp.sweat_money.executor.ThreadExecutor;
import com.zyp.sweat_money.executor.UIThread;
import com.zyp.sweat_money.navigation.Navigator;

import javax.inject.Singleton;

import dagger.Module;
import dagger.Provides;

/**
 * Dagger module that provides objects which will live during the application lifecycle.
 */
@Module
public class ApplicationModule {
    private final SweatMoneyApp application;

    public ApplicationModule(SweatMoneyApp application) {
        this.application = application;
    }

    @Provides
    @Singleton
    Context provideContext() {
        return this.application;
    }

    @Provides
    @Singleton
    SweatMoneyApp provideTradeKingApp() {
        return this.application;
    }

    @Provides
    @Singleton
    Navigator provideNavigator() {
        return new Navigator();
    }

    @Provides
    @Singleton
    RxBus provideRxBus() {
        return new RxBus();
    }


    @Provides
    @Singleton
    ThreadExecutor provideThreadExecutor(JobExecutor jobExecutor) {
        return jobExecutor;
    }

    @Provides
    @Singleton
    PostExecutionThread providePostExecutionThread(UIThread uiThread) {
        return uiThread;
    }


}
