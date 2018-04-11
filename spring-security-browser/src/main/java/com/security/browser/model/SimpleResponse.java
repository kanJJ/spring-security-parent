package com.security.browser.model;

/**
 * Created by Chris on 2018/4/12.
 */
public class SimpleResponse {
    private Object obj;

    public SimpleResponse(Object obj) {
        this.obj = obj;
    }

    public Object getObj() {
        return obj;
    }

    public void setObj(Object obj) {
        this.obj = obj;
    }
}
