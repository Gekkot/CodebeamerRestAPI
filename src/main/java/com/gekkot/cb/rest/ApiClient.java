package com.gekkot.cb.rest;

import com.gekkot.cb.params.ApiParams;
import com.gekkot.cb.rest.projects.ProjectListRequest;
import com.gekkot.cb.rest.time.TimeRequest;
import com.gekkot.cb.rest.user.UserRequest;
import com.gekkot.cb.rest.version.GetVersionRequest;
import com.google.gson.Gson;
import com.google.gson.GsonBuilder;

import java.util.Arrays;
import java.util.Base64;
import io.reactivex.schedulers.Schedulers;
import okhttp3.OkHttpClient;
import okhttp3.logging.HttpLoggingInterceptor;
import org.apache.commons.codec.Charsets;
import retrofit2.Retrofit;
import retrofit2.adapter.rxjava2.RxJava2CallAdapterFactory;
import retrofit2.converter.gson.GsonConverterFactory;
import retrofit2.converter.scalars.ScalarsConverterFactory;

import java.util.concurrent.TimeUnit;


/**
 * API client class. Init retrofit.
 * Singleton.
 */
public class ApiClient {

    private static ApiClient mApiClient;
    private Retrofit mRetrofit;

    /* retrofit params - server url, timeouts */
    private static ApiParams params;

    public static void setParams(ApiParams params) {
        ApiClient.params = params;
    }

    private Gson gson = new GsonBuilder().setLenient().create();



    private ApiClient() {
        if(params == null){
            throw  new RuntimeException("set Api params before creating Api Client");
        }
       HttpLoggingInterceptor httpLoggingInterceptor = new HttpLoggingInterceptor();
        httpLoggingInterceptor.setLevel(HttpLoggingInterceptor.Level.BODY);


        OkHttpClient.Builder client = new OkHttpClient.Builder()
                .callTimeout(params.getCallTimeoutSeconds(), TimeUnit.SECONDS)
                .connectTimeout(params.getConnectTimeoutSeconds(), TimeUnit.SECONDS)
                .readTimeout(params.getReadTimeoutSeconds(), TimeUnit.SECONDS)
                .writeTimeout(params.getWriteTimeoutSeconds(), TimeUnit.SECONDS);
        byte[] tokenBytes = (params.getLogin() + ":" + params.getPassword()).getBytes(Charsets.UTF_8);
        final String token = "Basic " + new String(Base64.getEncoder().encode(tokenBytes));
        AuthenticationInterceptor interceptorAuth = new AuthenticationInterceptor(token);

        if (!client.interceptors().contains(interceptorAuth)) {
            client.addInterceptor(interceptorAuth);
        }

        client.addInterceptor(httpLoggingInterceptor);

        RxJava2CallAdapterFactory rxAdapter =
                RxJava2CallAdapterFactory.createWithScheduler(Schedulers.io());

        mRetrofit = new Retrofit.Builder()
                .baseUrl(params.getCodeBeamerURL())
                .addConverterFactory(ScalarsConverterFactory.create())
                .addConverterFactory(GsonConverterFactory.create(gson))
                .addCallAdapterFactory(rxAdapter)
                .client(client.build())
                .build();
    }

    public static ApiClient getInstance() {
        if(mApiClient == null){
            mApiClient = new ApiClient();
        }
        return mApiClient;
    }

    public GetVersionRequest getVersionRequest() {
        return mRetrofit.create(GetVersionRequest.class);
    }

    public UserRequest getUserRequest(){
        return mRetrofit.create(UserRequest.class);
    }

    public TimeRequest getTimeRequest(){
        return mRetrofit.create(TimeRequest.class);
    }

    public ProjectListRequest getProjectsRequest(){
        return mRetrofit.create(ProjectListRequest.class);
    }

}