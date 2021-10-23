package com.gekkot.cb.rest.common;

import java.util.HashMap;
import java.util.Map;

public class CommonPojo {

    private Map<String, Object> additionalProperties = new HashMap<>();

    public Map<String, Object> getAdditionalProperties() {
        return this.additionalProperties;
    }

    public void setAdditionalProperty(String name, Object value) {
        this.additionalProperties.put(name, value);
    }
}
