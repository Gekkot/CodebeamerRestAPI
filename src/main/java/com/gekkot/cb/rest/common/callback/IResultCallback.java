package com.gekkot.cb.rest.common.callback;

public interface IResultCallback<T> {
    void onGetValue(T value);
}
