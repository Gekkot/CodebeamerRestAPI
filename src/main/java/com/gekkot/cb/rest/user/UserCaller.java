package com.gekkot.cb.rest.user;

import com.gekkot.cb.rest.ApiClient;
import com.gekkot.cb.rest.common.BaseRxCaller;
import io.reactivex.Observable;

public class UserCaller extends BaseRxCaller<UserPojo> {


    private final String userIdOrName;

    public UserCaller(String userIdOrName) {
        this.userIdOrName = userIdOrName;
    }

    @Override
    protected Observable<UserPojo> getObservable() {
        return  ApiClient.getInstance().getUserRequest().getUser(userIdOrName);
    }
}
