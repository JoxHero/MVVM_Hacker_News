package com.zyp.domain.interactor;

import com.zyp.domain.GankRepository;
import com.zyp.domain.UseCase;
import com.zyp.domain.executor.PostExecutionThread;
import com.zyp.domain.executor.ThreadExecutor;
import com.zyp.domain.model.SearchDataResult;

import javax.inject.Inject;

import rx.Observable;

/**
 * Created by zyp on 2016/6/23.
 */

public class SearchDataUseCase extends UseCase<SearchDataResult> {

    private final GankRepository gankRepository;

    private String content;
    private String category;
    private int count;
    private int page;

    public String getContent() {
        return content;
    }

    public void setContent(String content) {
        this.content = content;
    }

    public String getCategory() {
        return category;
    }

    public void setCategory(String category) {
        this.category = category;
    }

    public int getCount() {
        return count;
    }

    public void setCount(int count) {
        this.count = count;
    }

    public int getPage() {
        return page;
    }

    public void setPage(int page) {
        this.page = page;
    }

    @Inject
    public SearchDataUseCase(GankRepository gankRepository, ThreadExecutor threadExecutor, PostExecutionThread postExecutionThread) {
        super(threadExecutor, postExecutionThread);
        this.gankRepository = gankRepository;
    }

    @Override
    protected Observable<SearchDataResult> buildUseCaseObservable() {
        return gankRepository.getSearchData(content,category,count,page);
    }
}
