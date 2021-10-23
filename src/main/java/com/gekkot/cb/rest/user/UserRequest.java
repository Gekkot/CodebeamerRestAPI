package com.gekkot.cb.rest.user;

import retrofit2.Call;
import retrofit2.http.GET;
import retrofit2.http.Path;

public interface UserRequest {

    @GET("/cb/rest/user/{id}")
    Call<UserPojo> getUser(@Path("id") String id);
}
