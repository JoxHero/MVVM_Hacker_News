package com.zyp.data;

import com.zyp.domain.GankRepository;
import com.zyp.domain.model.CategoryDataResult;
import com.zyp.domain.model.EveryDayDataResult;
import com.zyp.domain.model.RandomDataResult;
import com.zyp.domain.model.SearchDataResult;
import com.zyp.domain.model.SpecificDateDataResult;

import javax.inject.Inject;
import javax.inject.Singleton;

import rx.Observable;

/**
 * Created by zyp on 2016/6/22.
 */
@Singleton
public class GankDataRepository implements GankRepository{

    private GankCloudDs gankCloudDs;

    @Inject
    public GankDataRepository(GankCloudDs gankCloudDs) {
        this.gankCloudDs = gankCloudDs;
    }

    @Override
    public Observable<CategoryDataResult> getCategoryData(String category, int number, int page) {
        return gankCloudDs.getCategoryData(category,number,page);
    }

    @Override
    public Observable<EveryDayDataResult> getEveryDayData() {
        return gankCloudDs.getEveryDayData();
    }

    @Override
    public Observable<RandomDataResult> getRandomData(String category, int number) {
        return gankCloudDs.getRandomData(category,number);
    }

    @Override
    public Observable<SpecificDateDataResult> getSpecificDateData(int year, int month, int day) {
        return gankCloudDs.getSpecificDateData(year, month, day);
    }

    @Override
    public Observable<SearchDataResult> getSearchData(String content, String category, int count, int page) {
        return gankCloudDs.getSearchData(content, category, count, page);
    }
}
