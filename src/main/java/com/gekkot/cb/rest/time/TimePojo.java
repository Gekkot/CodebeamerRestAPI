package com.gekkot.cb.rest.time;

import com.gekkot.cb.rest.common.CommonPojo;

public class TimePojo extends CommonPojo {
    private String date;
    private long millis;

    public TimePojo() {
    }

    public String getDate() {
        return date;
    }

    public void setDate(String date) {
        this.date = date;
    }

    public long getMillis() {
        return millis;
    }

    public void setMillis(long millis) {
        this.millis = millis;
    }
}
