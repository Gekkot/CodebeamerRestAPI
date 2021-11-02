package com.gekkot.cb.rest.projects;

import com.google.gson.annotations.Expose;

import java.util.List;

public class ProjectResponse {
    @Expose
    private List<ProjectShortInfoPojo> projects;

    public List<ProjectShortInfoPojo> getProjects() {
        return projects;
    }

    public void setProjects(List<ProjectShortInfoPojo> projects) {
        this.projects = projects;
    }
}
