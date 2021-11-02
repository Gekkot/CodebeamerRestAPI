package com.gekkot.cb.rest.common;

/**
 * Base caller generic.
 * Return response as if
 * @param <ResponseType> response type
 */
public abstract class BaseCaller<ResponseType> extends StructuredCaller<ResponseType,ResponseType>{

    @Override
    protected ResponseType getAnswer(ResponseType responseType) {
        return responseType;
    }
}
