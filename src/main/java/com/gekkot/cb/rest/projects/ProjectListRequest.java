package com.gekkot.cb.rest.projects;

import retrofit2.Call;
import retrofit2.http.GET;

import java.util.List;

public interface ProjectListRequest {

    @GET("/cb/rest/projects/")
    Call<List<ProjectShortInfoPojo>> getProjectsList();
}
