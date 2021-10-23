package com.gekkot.cb.rest;


import okhttp3.Interceptor;
import okhttp3.Request;
import okhttp3.Response;
import org.apache.http.HttpHeaders;
import org.apache.http.message.BasicHeader;

import java.io.IOException;

public class AuthenticationInterceptor implements Interceptor {

    private String authToken;

    public AuthenticationInterceptor(String token) {
        this.authToken = token;
    }
    private BasicHeader getAuthenticationHeader() {
        return new BasicHeader(HttpHeaders.AUTHORIZATION, authToken);
    }

    @Override
    public Response intercept(Chain chain) throws IOException {
        Request original = chain.request();
        BasicHeader authenticationHeader = getAuthenticationHeader();
        Request.Builder builder = original
                .newBuilder()
                .header(authenticationHeader.getName(),authenticationHeader.getValue())
                .method(original.method(), original.body());
        Request request = builder.build();
        return chain.proceed(request);
    }
}