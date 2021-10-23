package com.gekkot.cb.rest.common;

import com.gekkot.cb.rest.common.callback.IDataErrorCallback;
import com.gekkot.cb.rest.common.callback.INetworkExceptionCallback;
import com.gekkot.cb.rest.common.callback.IResultCallback;
import com.gekkot.cb.rest.common.exception.DataError;
import com.gekkot.cb.rest.common.exception.IncorrectAnswerException;
import retrofit2.Call;
import retrofit2.Response;

import java.io.IOException;

/**
 * Base caller generic.
 * @param <ResponseType>
 */
public abstract class BaseCaller<ResponseType> {



    protected abstract Call<ResponseType> getCall();

    public void doCall(IResultCallback<ResponseType> resultCallback,
                       IDataErrorCallback dataErrorCallback,
                       INetworkExceptionCallback networkExceptionCallback) {
        try {
            Call<ResponseType> call = getCall();
            Response<ResponseType> execute = call.execute();
            if (execute.isSuccessful()) {
                if (execute.body() != null) {
                    ResponseType responseType = execute.body();
                    resultCallback.onGetValue(responseType);

                } else {
                    IOException ioException = new IncorrectAnswerException(call.request().url().toString(),"response  body is null");
                    networkExceptionCallback.onGetNetworkException(ioException);
                }
            }
             else {
                int code = execute.code();
                String message = execute.message();

                DataError dataError = new DataError(call.request().url().toString(),code,message);
                dataErrorCallback.onGetDataError(dataError);
            }
        } catch (IOException e) {
            networkExceptionCallback.onGetNetworkException(e);
        }
    }
}
