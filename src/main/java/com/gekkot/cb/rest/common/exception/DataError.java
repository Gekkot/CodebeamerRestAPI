package com.gekkot.cb.rest.common.exception;

public class DataError {
    private String request;
    private int code;
    private String errorMessage;

    public DataError(String request, int code, String errorMessage) {
        this.request = request;
        this.code = code;
        this.errorMessage = errorMessage;
    }

    public String getRequest() {
        return request;
    }

    public int getCode() {
        return code;
    }

    public String getErrorMessage() {
        return errorMessage;
    }

    @Override
    public String toString() {
        return "DataError{" +
                "request='" + request + '\'' +
                ", code=" + code +
                ", errorMessage='" + errorMessage + '\'' +
                '}';
    }
}
