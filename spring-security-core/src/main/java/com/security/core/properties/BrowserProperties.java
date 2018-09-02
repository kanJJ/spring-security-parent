package com.security.core.properties;

import com.security.core.constants.Constants;

/**
 * Created by Chris on 2018/4/12.
 */

public class BrowserProperties {
    private String loginPageUrl = Constants.DEFAULT_SINGIN_PAGE;
    private String logoutPageUrl = Constants.DEFAULT_LOGINOUT_URL;

    private int rememberMeTime = 600;

    public int getRememberMeTime() {
        return rememberMeTime;
    }

    public void setRememberMeTime(int rememberMeTime) {
        this.rememberMeTime = rememberMeTime;
    }

    public String getLoginPageUrl() {
        return loginPageUrl;
    }

    public void setLoginPageUrl(String loginPageUrl) {
        this.loginPageUrl = loginPageUrl;
    }

    public String getLogoutPageUrl() {
        return logoutPageUrl;
    }

    public void setLogoutPageUrl(String logoutPageUrl) {
        this.logoutPageUrl = logoutPageUrl;
    }
}
