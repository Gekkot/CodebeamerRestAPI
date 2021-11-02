package com.gekkot.cb.rest.common.callers;

/**
 * Base reactive caller generic.
 * Return response as if
 * @param <ResponseType> response type
 */
public abstract class BaseRxCaller<ResponseType> extends StructuredRXCaller<ResponseType,ResponseType> {
    @Override
    protected ResponseType getAnswer(ResponseType responseType) {
        return responseType;
    }
}
