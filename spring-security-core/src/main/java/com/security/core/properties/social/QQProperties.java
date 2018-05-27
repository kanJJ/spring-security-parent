package com.security.core.properties.social;

import org.springframework.boot.autoconfigure.social.SocialProperties;

/**
 * Created by Chris on 2018/5/27.
 */
public class QQProperties extends SocialProperties {

    private String provideId = "qq";

    public String getProvideId() {
        return provideId;
    }

    public void setProvideId(String provideId) {
        this.provideId = provideId;
    }
}
