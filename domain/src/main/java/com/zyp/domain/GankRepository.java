package com.zyp.domain;

import com.zyp.domain.model.CategoryDataResult;
import com.zyp.domain.model.EveryDayDataResult;
import com.zyp.domain.model.RandomDataResult;
import com.zyp.domain.model.SearchDataResult;
import com.zyp.domain.model.SpecificDateDataResult;

import rx.Observable;

/**
 * Created by zyp on 2016/6/22.
 */

public interface GankRepository {

     Observable<CategoryDataResult> getCategoryData(String category, int number, int page);

    Observable<EveryDayDataResult>getEveryDayData();

    Observable<RandomDataResult>getRandomData(String category, int number);

    Observable<SpecificDateDataResult>getSpecificDateData(int year, int month, int day);

    Observable<SearchDataResult>getSearchData(String content, String category, int count, int page);
}
