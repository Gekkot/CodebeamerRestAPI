package com.gekkot.cb.rest.user;

import com.gekkot.cb.rest.ApiClient;
import com.gekkot.cb.rest.common.BaseCaller;
import retrofit2.Call;

public class UserCaller extends BaseCaller<UserPojo> {


    private final String userIdOrName;

    public UserCaller(String userIdOrName) {
        this.userIdOrName = userIdOrName;
    }


    @Override
    protected Call<UserPojo> getCall() {
        return ApiClient.getInstance().getUserRequest().getUser(userIdOrName);
    }

}
