package com.security.core.properties.social;

/**
 * Created by Chris on 2018/5/27.
 */
public class SocialProperties {
    private QQProperties qq;
    private WeiXinProperties weixin;

    public WeiXinProperties getWeixin() {
        return weixin;
    }

    public void setWeixin(WeiXinProperties weixin) {
        this.weixin = weixin;
    }

    public QQProperties getQq() {
        return qq;
    }

    public void setQq(QQProperties qq) {
        this.qq = qq;
    }
}
