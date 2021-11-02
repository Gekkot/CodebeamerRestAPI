package com.gekkot.cb.rest.common.callers;

import com.gekkot.cb.rest.common.callback.IDataErrorCallback;
import com.gekkot.cb.rest.common.callback.INetworkExceptionCallback;
import com.gekkot.cb.rest.common.callback.IResultCallback;

public interface ICaller<DataType> {

    void doCall(IResultCallback<DataType> resultCallback,
                IDataErrorCallback dataErrorCallback,
                INetworkExceptionCallback networkExceptionCallback);
}
