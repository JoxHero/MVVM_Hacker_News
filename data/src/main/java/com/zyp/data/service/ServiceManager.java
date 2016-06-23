package com.zyp.data.service;

import android.content.Context;

import com.example.common.Constants;
import com.squareup.okhttp.OkHttpClient;
import com.zyp.domain.executor.ThreadExecutor;

import javax.inject.Inject;
import javax.inject.Named;
import javax.inject.Singleton;

import retrofit.GsonConverterFactory;
import retrofit.Retrofit;
import retrofit.RxJavaCallAdapterFactory;

/**
 * Created by zyp on 2016/6/22.
 */
@Singleton
public class ServiceManager {

    private final Context applicationContext;
    private final OkHttpClient restClient;
    private GankInfoService gankInfoService;
    @Inject
    public ServiceManager(Context applicationContext,
                          @Named("restClient") OkHttpClient restClient) {
        this.applicationContext = applicationContext;
        this.restClient = restClient;
        gankInfoService = createRestService(Constants.EndPoint.END_POINT_GANK_IO_SERVICE, restClient, GankInfoService
                .class);
    }

    public static <T> T createRestService(String endPoint, OkHttpClient restClient, Class<T> service) {
        Retrofit serviceAdapter = new Retrofit.Builder()
                .baseUrl(endPoint)
                .addConverterFactory(
                        GsonConverterFactory.create())
                .addCallAdapterFactory(
                        RxJavaCallAdapterFactory.create())
                .client(restClient)
                .build();

        return serviceAdapter.create(service);
    }

    public GankInfoService getGankInfoService() {
        return gankInfoService;
    }
}
