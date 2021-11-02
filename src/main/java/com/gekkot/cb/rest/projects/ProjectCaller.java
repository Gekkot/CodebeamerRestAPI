package com.gekkot.cb.rest.projects;

import com.gekkot.cb.rest.ApiClient;
import com.gekkot.cb.rest.common.callers.BaseCaller;
import retrofit2.Call;

import java.util.List;

public class ProjectCaller extends BaseCaller<List<ProjectShortInfoPojo>> {


    @Override
    protected Call<List<ProjectShortInfoPojo>> getCall() {
        return ApiClient.getInstance().getProjectsRequest().getProjectsList();
    }

}
