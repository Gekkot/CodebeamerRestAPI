package com.gekkot.cb.params;

public class ApiParams {

    private String codeBeamerURL;
    private int readTimeoutSeconds = 30;
    private int writeTimeoutSeconds = 40;
    private int connectTimeoutSeconds = 10;
    private int callTimeoutSeconds = 30;

    private String login;
    private String password;

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

    public String getLogin() {
        return login;
    }

    public void setLogin(String login) {
        this.login = login;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }
}
