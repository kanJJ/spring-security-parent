package com.security.core.social.weixin.api;

/**
 * Created by Chris on 2018/6/10.
 */
public interface WeiXin {

    WeiXinUserInfo getWeiXinUserInfo(String openId);
}
