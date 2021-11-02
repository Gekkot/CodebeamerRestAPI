package com.gekkot.cb.rest.common.callers;

import com.gekkot.cb.rest.common.callback.IDataErrorCallback;
import com.gekkot.cb.rest.common.callback.INetworkExceptionCallback;
import com.gekkot.cb.rest.common.callback.IResultCallback;
import com.gekkot.cb.rest.common.exception.DataError;
import com.gekkot.cb.rest.common.exception.IncorrectAnswerException;
import retrofit2.Call;
import retrofit2.Response;

import java.io.IOException;

/**
 * Structured generic caller - get response and convert  it to another type
 * @param <ResponseType> server response type
 * @param <DataType> returning type
 */
public abstract class StructuredCaller<ResponseType, DataType> implements ICaller<DataType>{

    protected abstract Call<ResponseType> getCall();
    protected abstract DataType getAnswer(ResponseType responseType);

    @Override
    public void doCall(IResultCallback<DataType> resultCallback,
                       IDataErrorCallback dataErrorCallback,
                       INetworkExceptionCallback networkExceptionCallback) {
        try {
            Call<ResponseType> call = getCall();
            Response<ResponseType> execute = call.execute();
            if (execute.isSuccessful()) {
                if (execute.body() != null) {
                    ResponseType responseType = execute.body();
                    resultCallback.onGetValue(getAnswer(responseType));

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
