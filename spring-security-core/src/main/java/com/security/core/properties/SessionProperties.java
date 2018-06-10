package com.security.core.properties;

import com.security.core.constants.Constants;

/**
 * Created by Chris on 2018/6/11.
 */
public class SessionProperties {
    private String invalidSessionUrl = Constants.DEFAULT_SESSION_INVALID_URL;
    private Integer maximumSessions = 1;
    private Boolean maxSessionsPreventsLogin = false;

    public String getInvalidSessionUrl() {
        return invalidSessionUrl;
    }

    public void setInvalidSessionUrl(String invalidSessionUrl) {
        this.invalidSessionUrl = invalidSessionUrl;
    }

    public Integer getMaximumSessions() {
        return maximumSessions;
    }

    public void setMaximumSessions(Integer maximumSessions) {
        this.maximumSessions = maximumSessions;
    }

    public Boolean getMaxSessionsPreventsLogin() {
        return maxSessionsPreventsLogin;
    }

    public void setMaxSessionsPreventsLogin(Boolean maxSessionsPreventsLogin) {
        this.maxSessionsPreventsLogin = maxSessionsPreventsLogin;
    }
}
