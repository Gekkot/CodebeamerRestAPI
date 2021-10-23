package com.gekkot.cb.rest.version;

import com.gekkot.cb.rest.ApiClient;
import com.gekkot.cb.rest.common.BaseCaller;
import retrofit2.Call;

public class VersionCaller extends BaseCaller<String> {

    private static VersionCaller versionCaller;
    private VersionCaller(){

    }

    @Override
    protected Call<String> getCall() {
        return ApiClient.getInstance().getVersionRequest().getVersion();
    }

    public static VersionCaller getInstance() {
        if(versionCaller == null){
            versionCaller = new VersionCaller();
        }
        return versionCaller;
    }


}
