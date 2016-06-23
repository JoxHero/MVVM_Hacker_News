package com.zyp.gank.dagger.modules;

import android.content.Context;
import android.util.Log;

import com.example.common.Constants;
import com.squareup.okhttp.OkHttpClient;
import com.squareup.okhttp.logging.HttpLoggingInterceptor;
import com.zyp.data.GankDataRepository;
import com.zyp.data.executor.JobExecutor;
import com.zyp.data.service.GankInfoService;
import com.zyp.data.service.ServiceManager;
import com.zyp.domain.GankRepository;
import com.zyp.domain.executor.PostExecutionThread;
import com.zyp.domain.executor.ThreadExecutor;
import com.zyp.gank.BuildConfig;
import com.zyp.gank.GankApp;
import com.zyp.gank.event.RxBus;

import com.zyp.gank.UIThread;
import com.zyp.gank.navigation.Navigator;

import java.util.concurrent.TimeUnit;

import javax.inject.Named;
import javax.inject.Singleton;

import dagger.Module;
import dagger.Provides;

/**
 * Dagger module that provides objects which will live during the application lifecycle.
 */
@Module
public class ApplicationModule {
    private final GankApp application;

    public ApplicationModule(GankApp application) {
        this.application = application;
    }

    @Provides
    @Singleton
    Context provideContext() {
        return this.application;
    }

    @Provides
    @Singleton
    GankApp provideTradeKingApp() {
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

    @Provides
    @Singleton
    @Named("restClient")
    OkHttpClient provideRestClient() {
        OkHttpClient client = new OkHttpClient();
        client.setConnectTimeout(Constants.Http.CONNECT_TIMEOUT, TimeUnit.MILLISECONDS);
        client.setWriteTimeout(Constants.Http.WRITE_TIMEOUT, TimeUnit.MILLISECONDS);
        client.setReadTimeout(Constants.Http.READ_TIMEOUT, TimeUnit.MILLISECONDS);
        client.setRetryOnConnectionFailure(true);
        // for test and debug
        if (BuildConfig.DEBUG) {
            HttpLoggingInterceptor logging = new HttpLoggingInterceptor(
                    new HttpLoggingInterceptor.Logger() {
                        @Override
                        public void log(String message) {
                            Log.d("RestClient", message);
                        }
                    });
            logging.setLevel(HttpLoggingInterceptor.Level.BODY);
            client.interceptors().add(logging);
        }

        return client;
    }

    @Provides
    @Singleton
    ServiceManager provideServiceManager(Context context,
                                         @Named("restClient") OkHttpClient restClient) {
        Context applicationContext = context.getApplicationContext();

        return new ServiceManager(applicationContext, restClient);
    }

    @Provides
    @Singleton
    GankRepository provideGankRepository(GankDataRepository gankDataRepository){
        return gankDataRepository;
    }


}
