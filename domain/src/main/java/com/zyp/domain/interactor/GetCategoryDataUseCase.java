package com.zyp.domain.interactor;


import com.zyp.domain.GankRepository;
import com.zyp.domain.UseCase;
import com.zyp.domain.executor.PostExecutionThread;
import com.zyp.domain.executor.ThreadExecutor;
import com.zyp.domain.model.CategoryDataResult;

import javax.inject.Inject;

import rx.Observable;

/**
 * Created zyp  on 2016/6/23.
 */
public class GetCategoryDataUseCase extends UseCase<CategoryDataResult> {

    private final GankRepository gankRepository;

    private String category;
    private int number;
    private int page;

    public String getCategory() {
        return category;
    }

    public void setCategory(String category) {
        this.category = category;
    }

    public int getNumber() {
        return number;
    }

    public void setNumber(int number) {
        this.number = number;
    }

    public int getPage() {
        return page;
    }

    public void setPage(int page) {
        this.page = page;
    }

    @Inject
    public GetCategoryDataUseCase(GankRepository gankRepository, ThreadExecutor threadExecutor, PostExecutionThread postExecutionThread) {
        super(threadExecutor, postExecutionThread);
        this.gankRepository = gankRepository;
    }

    @Override
    protected Observable<CategoryDataResult> buildUseCaseObservable() {
        return gankRepository.getCategoryData(category,number,page);
    }
}