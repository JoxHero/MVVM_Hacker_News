package com.zyp.gank.event;

import rx.Observable;
import rx.subjects.PublishSubject;
import rx.subjects.SerializedSubject;
import rx.subjects.Subject;

/**
 * courtesy: https://gist.github.com/benjchristensen/04eef9ca0851f3a5d7bf
 */
public class RxBus {

    //private final PublishSubject<Object> subject = PublishSubject.create();

    // If multiple threads are going to emit events to this
    // then it must be made thread-safe like this instead
    private final Subject<Object, Object> subject = new SerializedSubject<>(PublishSubject.create());

    public void send(Object o) {
        subject.onNext(o);
    }

    public Observable<Object> toObserverable() {
        return subject;
    }

    public boolean hasObservers() {
        return subject.hasObservers();
    }
    
    public Observable<Object> subscribe() {
        return subject;
    }
}