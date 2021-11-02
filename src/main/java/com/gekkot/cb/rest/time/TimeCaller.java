package com.gekkot.cb.rest.time;

import com.gekkot.cb.rest.ApiClient;
import com.gekkot.cb.rest.common.callers.BaseCaller;
import retrofit2.Call;

public class TimeCaller  extends BaseCaller<TimePojo> {

    @Override
    protected Call<TimePojo> getCall() {
        return ApiClient.getInstance().getTimeRequest().getTime();
    }
}
