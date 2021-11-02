package com.gekkot.cb.rest.common.callers;

import com.gekkot.cb.rest.common.callback.IDataErrorCallback;
import com.gekkot.cb.rest.common.callback.INetworkExceptionCallback;
import com.gekkot.cb.rest.common.callback.IResultCallback;
import io.reactivex.Observable;
import io.reactivex.observers.DisposableObserver;
import io.reactivex.schedulers.Schedulers;

import java.io.IOException;

public abstract class BaseRxCaller<ResponseType> {

    protected abstract Observable<ResponseType> getObservable();

    public void doCall(IResultCallback<ResponseType> resultCallback,
                       IDataErrorCallback dataErrorCallback,
                       INetworkExceptionCallback networkExceptionCallback) {

        getObservable()
                .subscribeOn(Schedulers.io())
                .retry(2)
                .observeOn(Schedulers.newThread())
                .subscribe(new DisposableObserver<ResponseType>() {

                    @Override
                    public void onNext(ResponseType responseType) {
                        System.out.println("onNext");
                        resultCallback.onGetValue(responseType);
                    }

                    @Override
                    public void onError(Throwable throwable) {
                        System.out.println("onError");
                        networkExceptionCallback.onGetNetworkException(new IOException(throwable));
                    }

                    @Override
                    public void onComplete() {
                        System.out.println("onComplete!");
                    }
                });
    }
}
