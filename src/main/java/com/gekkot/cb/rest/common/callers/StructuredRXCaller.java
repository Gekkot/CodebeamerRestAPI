package com.gekkot.cb.rest.common.callers;

import com.gekkot.cb.rest.common.callback.IDataErrorCallback;
import com.gekkot.cb.rest.common.callback.INetworkExceptionCallback;
import com.gekkot.cb.rest.common.callback.IResultCallback;
import io.reactivex.Observable;
import io.reactivex.observers.DisposableObserver;
import io.reactivex.schedulers.Schedulers;

import java.io.IOException;


/**
 * Structured generic reactive caller - get response and convert  it to another type
 * @param <ResponseType> server response type
 * @param <DataType> returning type
 */
public abstract class StructuredRXCaller<ResponseType, DataType> implements ICaller<DataType>{

    protected abstract Observable<ResponseType> getObservable();

    protected abstract DataType getAnswer(ResponseType responseType);

    @Override
    public void doCall(IResultCallback<DataType> resultCallback,
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
                        resultCallback.onGetValue(getAnswer(responseType));
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
