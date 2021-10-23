package com.gekkot.cb.rest.common.exception;

import java.io.IOException;

public class IncorrectAnswerException extends IOException {
    public IncorrectAnswerException(String request, String message) {
        super(String.format("exception on request %s : %s",request,message));
    }
}
