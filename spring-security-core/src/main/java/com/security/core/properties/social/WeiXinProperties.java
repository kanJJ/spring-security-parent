package com.security.core.properties.social;

import org.springframework.boot.autoconfigure.social.SocialProperties;

/**
 * Created by Chris on 2018/6/10.
 */
public class WeiXinProperties extends SocialProperties {
    private String provideId = "weixin";

    public String getProvideId() {
        return provideId;
    }

    public void setProvideId(String provideId) {
        this.provideId = provideId;
    }
}
