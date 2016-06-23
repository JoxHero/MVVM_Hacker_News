package com.zyp.domain.interactor;

import com.zyp.domain.GankRepository;
import com.zyp.domain.UseCase;
import com.zyp.domain.executor.PostExecutionThread;
import com.zyp.domain.executor.ThreadExecutor;
import com.zyp.domain.model.EveryDayDataResult;
import com.zyp.domain.model.SpecificDateDataResult;

import javax.inject.Inject;

import rx.Observable;

/**
 * Created by zyp on 2016/6/23.
 */

public class GetSpecificDateDataUseCase extends UseCase<SpecificDateDataResult> {

    private final GankRepository gankRepository;
    private int year;
    private int month;
    private int day;

    public int getYear() {
        return year;
    }

    public void setYear(int year) {
        this.year = year;
    }

    public int getMonth() {
        return month;
    }

    public void setMonth(int month) {
        this.month = month;
    }

    public int getDay() {
        return day;
    }

    public void setDay(int day) {
        this.day = day;
    }

    @Inject
    public GetSpecificDateDataUseCase(GankRepository gankRepository, ThreadExecutor threadExecutor, PostExecutionThread postExecutionThread) {
        super(threadExecutor, postExecutionThread);
        this.gankRepository = gankRepository;
    }

    @Override
    protected Observable<SpecificDateDataResult> buildUseCaseObservable() {
        return gankRepository.getSpecificDateData(year,month,day);
    }
}
