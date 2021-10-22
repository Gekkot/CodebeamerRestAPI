package com.gekkot.cb.rest;

import com.gekkot.cb.params.ApiParams;
import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import okhttp3.OkHttpClient;
import okhttp3.logging.HttpLoggingInterceptor;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

import java.util.concurrent.TimeUnit;


/**
 * API client class. Init retrofit.
 * Singleton.
 */
public class ApiClient {

    private static String authToken;
    private static ApiClient mApiClient;
    private Retrofit mRetrofit;

    /* retrofit params - server url, timeouts */
    private static ApiParams params;

    public static void setParams(ApiParams params) {
        ApiClient.params = params;
    }

    private Gson gson = new GsonBuilder().setLenient().create();

    /**
     * Check token is set.
     */
    private boolean checkTokenSet(){
        return authToken != null && authToken.isEmpty();
    }



    private ApiClient() {
        if(params == null){
            throw  new RuntimeException("set Api params before creating Api Client");
        }
       HttpLoggingInterceptor interceptor = new HttpLoggingInterceptor();
        interceptor.setLevel(HttpLoggingInterceptor.Level.BODY);

        OkHttpClient.Builder client = new OkHttpClient.Builder()
                .callTimeout(params.getCallTimeoutSeconds(), TimeUnit.SECONDS)
                .connectTimeout(params.getConnectTimeoutSeconds(), TimeUnit.SECONDS)
                .readTimeout(params.getReadTimeoutSeconds(), TimeUnit.SECONDS)
                .writeTimeout(params.getWriteTimeoutSeconds(), TimeUnit.SECONDS);
        AuthenticationInterceptor interceptorAuth = checkTokenSet() ? null : new AuthenticationInterceptor(authToken);

        if (interceptorAuth != null && !client.interceptors().contains(interceptorAuth)) {
            client.addInterceptor(interceptorAuth);
        }
        mRetrofit = new Retrofit.Builder()
                .baseUrl(params.getCodeBeamerURL())
                .addConverterFactory(GsonConverterFactory.create(gson))
                .client(client.build())
                .build();
    }

    public static ApiClient getInstance() {
        if(mApiClient == null){
            mApiClient = new ApiClient();
        }
        return mApiClient;
    }

}