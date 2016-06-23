package com.zyp.domain.interactor;

import com.zyp.domain.GankRepository;
import com.zyp.domain.UseCase;
import com.zyp.domain.executor.PostExecutionThread;
import com.zyp.domain.executor.ThreadExecutor;
import com.zyp.domain.model.EveryDayDataResult;

import javax.inject.Inject;

import rx.Observable;

/**
 * Created zyp  on 2016/6/23.
 */
public class GetEveryDayDataUseCase extends UseCase<EveryDayDataResult> {

    private final GankRepository gankRepository;

    @Inject
    public GetEveryDayDataUseCase(GankRepository gankRepository, ThreadExecutor threadExecutor, PostExecutionThread postExecutionThread) {
        super(threadExecutor, postExecutionThread);
        this.gankRepository = gankRepository;
    }

    @Override
    protected Observable<EveryDayDataResult> buildUseCaseObservable() {
        return gankRepository.getEveryDayData();
    }
}