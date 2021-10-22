package com.gekkot.cb.params;

public class ApiParams {

    private String codeBeamerURL;
    private int readTimeoutSeconds = 30;
    private int writeTimeoutSeconds = 40;
    private int connectTimeoutSeconds = 10;
    private int callTimeoutSeconds = 30;

    public ApiParams(String codeBeamerURL) {
        this.codeBeamerURL = codeBeamerURL;
    }

    public String getCodeBeamerURL() {
        return codeBeamerURL;
    }

    public void setCodeBeamerURL(String codeBeamerURL) {
        this.codeBeamerURL = codeBeamerURL;
    }

    public int getReadTimeoutSeconds() {
        return readTimeoutSeconds;
    }

    public void setReadTimeoutSeconds(int readTimeoutSeconds) {
        this.readTimeoutSeconds = readTimeoutSeconds;
    }

    public int getWriteTimeoutSeconds() {
        return writeTimeoutSeconds;
    }

    public void setWriteTimeoutSeconds(int writeTimeoutSeconds) {
        this.writeTimeoutSeconds = writeTimeoutSeconds;
    }

    public int getConnectTimeoutSeconds() {
        return connectTimeoutSeconds;
    }

    public void setConnectTimeoutSeconds(int connectTimeoutSeconds) {
        this.connectTimeoutSeconds = connectTimeoutSeconds;
    }

    public int getCallTimeoutSeconds() {
        return callTimeoutSeconds;
    }

    public void setCallTimeoutSeconds(int callTimeoutSeconds) {
        this.callTimeoutSeconds = callTimeoutSeconds;
    }
}
