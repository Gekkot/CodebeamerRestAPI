package com.gekkot.cb.rest.version;


import retrofit2.Call;
import retrofit2.http.GET;


public interface GetVersionRequest {
    @GET("/cb/rest/version")
    Call<String> getVersion();
}
