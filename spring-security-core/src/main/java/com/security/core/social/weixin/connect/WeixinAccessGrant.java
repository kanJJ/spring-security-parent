package com.security.core.social.weixin.connect;

import org.springframework.social.oauth2.AccessGrant;

/**
 * Created by Chris on 2018/6/10.
 */
public class WeixinAccessGrant extends AccessGrant {

    private String openId;

    public WeixinAccessGrant(String accessToken, String scope, String refreshToken, Long expiresIn) {
        super(accessToken, scope, refreshToken, expiresIn);
    }

    public String getOpenId() {
        return openId;
    }

    public void setOpenId(String openId) {
        this.openId = openId;
    }
}
