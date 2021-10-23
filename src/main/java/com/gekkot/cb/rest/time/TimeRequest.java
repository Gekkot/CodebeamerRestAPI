package com.gekkot.cb.rest.time;

import retrofit2.Call;
import retrofit2.http.GET;

public interface TimeRequest {
    @GET("/cb/rest/time/")
    Call<TimePojo> getTime();
}
