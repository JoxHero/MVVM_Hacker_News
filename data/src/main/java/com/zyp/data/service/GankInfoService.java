package com.zyp.data.service;

import com.zyp.domain.model.CategoryDataResult;
import com.zyp.domain.model.EveryDayDataResult;
import com.zyp.domain.model.RandomDataResult;
import com.zyp.domain.model.SearchDataResult;
import com.zyp.domain.model.SpecificDateDataResult;

import retrofit.http.GET;
import retrofit.http.Path;
import rx.Observable;

/**
 * Created by zyp on 2016/6/22.
 */

public interface GankInfoService {

    @GET("data/{category}/{number}/{page}")
    Observable<CategoryDataResult> getCategoryData(@Path("category") String category,
                                                   @Path("number")int number,
                                                   @Path("page")int page);

    @GET("day/{year}/{month}/{day}")
    Observable<EveryDayDataResult>getEveryDayData(@Path("year") int year,
                                                  @Path("month") int month,
                                                  @Path("day") int day);

    @GET("random/data/{category}/{number}")
    Observable<RandomDataResult> getRandomData(@Path("category") String category,
                                               @Path("number") int number);

    @GET("history/content/day/{year}/{month}/{day}")
    Observable<SpecificDateDataResult> getSpecificDateData(@Path("year") int year,
                                                           @Path("month") int month,
                                                           @Path("day") int day);

    @GET("search/query/{content}/category/{category}/count/{count}/page/{page}")
    Observable<SearchDataResult> getSearchData(@Path("content") String content,
                                               @Path("category") String category,
                                               @Path("count") int count,
                                               @Path("page") int page);
}
