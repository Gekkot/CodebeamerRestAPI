

package com.gekkot.cb.rest.projects;

import com.gekkot.cb.rest.common.CommonPojo;

public class ProjectShortInfoPojo extends CommonPojo {

    private String uri;
    private String name;
    private String description;
    private String descFormat;
    private String category;
    private String status;
    private Boolean closed;
    private Boolean deleted;

    public String getUri() {
        return uri;
    }

    public void setUri(String uri) {
        this.uri = uri;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public String getDescFormat() {
        return descFormat;
    }

    public void setDescFormat(String descFormat) {
        this.descFormat = descFormat;
    }

    public String getCategory() {
        return category;
    }

    public void setCategory(String category) {
        this.category = category;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public Boolean getClosed() {
        return closed;
    }

    public void setClosed(Boolean closed) {
        this.closed = closed;
    }

    public Boolean getDeleted() {
        return deleted;
    }

    public void setDeleted(Boolean deleted) {
        this.deleted = deleted;
    }


}
