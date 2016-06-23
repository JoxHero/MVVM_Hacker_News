package com.zyp.data;


import com.example.common.util.DateUtils;
import com.zyp.data.service.ServiceManager;
import com.zyp.domain.model.CategoryDataResult;
import com.zyp.domain.model.EveryDayDataResult;
import com.zyp.domain.model.RandomDataResult;
import com.zyp.domain.model.SearchDataResult;
import com.zyp.domain.model.SpecificDateDataResult;

import java.util.Date;

import javax.inject.Inject;
import javax.inject.Singleton;

import rx.Observable;

/**
 * Created by zyp on 2016/6/22.
 */
@Singleton
public class GankCloudDs {
    private ServiceManager serviceManager;


    @Inject
    public GankCloudDs(ServiceManager serviceManager) {
       this.serviceManager = serviceManager;
    }

    /**
     * 分类数据
     * @param category
     * @param number
     * @param page
     * @return
     */
    public Observable<CategoryDataResult>getCategoryData(String category,int number,int page){
        return serviceManager.getGankInfoService().getCategoryData(category,number,page);
    }

    /**
     * 每日数据
     * @return
     */
    public Observable<EveryDayDataResult>getEveryDayData(){
        long time = System.currentTimeMillis();
        Date date = new Date(time);
        int year = DateUtils.getYear(date);
        int month = DateUtils.getMonth(date);
        int day = DateUtils.getDay(date)-1;
        return serviceManager.getGankInfoService().getEveryDayData(year,month,day);
    }

    /**
     * 随机数据
     * url http://gank.io/api/random/data/Android/20
     * @param category
     * @param number
     * @return
     */
    public Observable<RandomDataResult>getRandomData(String category,int number){
        return serviceManager.getGankInfoService().getRandomData(category,number);
    }

    /**
     * 获取特定日期网站数据
     * url http://gank.io/api/history/content/day/2016/05/11
     * @param year
     * @param month
     * @param day
     * @return
     */
    public Observable<SpecificDateDataResult>getSpecificDateData(int year, int month, int day){
        return serviceManager.getGankInfoService().getSpecificDateData(year,month,day);
    }

    /**
     * 搜索API
     * @param content
     * @param category
     * @param count
     * @param page
     * @return
     */
    public Observable<SearchDataResult>getSearchData(String content,String category,int count,int page){
        return serviceManager.getGankInfoService().getSearchData(content,category,count,page);
    }




}
