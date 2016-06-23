package com.zyp.domain.interactor;

import com.zyp.domain.GankRepository;
import com.zyp.domain.UseCase;
import com.zyp.domain.executor.PostExecutionThread;
import com.zyp.domain.executor.ThreadExecutor;
import com.zyp.domain.model.RandomDataResult;

import javax.inject.Inject;

import rx.Observable;

/**
 * Created zyp  on 2016/6/23.
 */
public class GetRandomDataUseCase extends UseCase<RandomDataResult> {

    private final GankRepository gankRepository;

    private String category;
    private int number;

    @Inject
    public GetRandomDataUseCase(GankRepository gankRepository, ThreadExecutor threadExecutor, PostExecutionThread postExecutionThread) {
        super(threadExecutor, postExecutionThread);
        this.gankRepository = gankRepository;
    }

    @Override
    protected Observable<RandomDataResult> buildUseCaseObservable() {
        return gankRepository.getRandomData(category,number);
    }
}