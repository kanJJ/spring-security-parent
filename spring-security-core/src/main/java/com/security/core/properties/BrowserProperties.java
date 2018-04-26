package com.security.core.properties;

/**
 * Created by Chris on 2018/4/12.
 */

public class BrowserProperties {
    private String loginPage = "/sigin.html";

    private int rememberMeTime = 600;

    public int getRememberMeTime() {
        return rememberMeTime;
    }

    public void setRememberMeTime(int rememberMeTime) {
        this.rememberMeTime = rememberMeTime;
    }

    public String getLoginPage() {
        return loginPage;
    }

    public void setLoginPage(String loginPage) {
        this.loginPage = loginPage;
    }
}
