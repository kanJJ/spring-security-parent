package com.security.core.properties;

/**
 * Created by Chris on 2018/4/25.
 */
public class SmsCodeProperties {

    private int expireIn = 60;
    private String urls;
    private int length = 4;

    public int getLength() {
        return length;
    }

    public void setLength(int length) {
        this.length = length;
    }

    public int getExpireIn() {
        return expireIn;
    }

    public void setExpireIn(int expireIn) {
        this.expireIn = expireIn;
    }

    public String getUrls() {
        return urls;
    }

    public void setUrls(String urls) {
        this.urls = urls;
    }
}
