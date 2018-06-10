package com.security.core.social.weixin.api;

import com.fasterxml.jackson.databind.ObjectMapper;
import org.springframework.social.oauth2.AbstractOAuth2ApiBinding;
import org.springframework.social.oauth2.TokenStrategy;

import java.io.IOException;

/**
 * Created by Chris on 2018/6/10.
 */
public class WeiXinImpl extends AbstractOAuth2ApiBinding implements WeiXin {

    private String USER_INFO_URL = "https://api.weixin.qq.com/sns/userinfo?access_token=%s&openid=%s";

    private String accessToken;

    private ObjectMapper objectMapper = new ObjectMapper();

    public WeiXinImpl(String accessToken) {
        super(accessToken, TokenStrategy.ACCESS_TOKEN_PARAMETER);
        this.accessToken = accessToken;
    }

    @Override
    public WeiXinUserInfo getWeiXinUserInfo(String openId) {
        String url = String.format(USER_INFO_URL, accessToken, openId);
        String forObject = getRestTemplate().getForObject(url, String.class);
        System.out.println(forObject);
        // 数据封装
        WeiXinUserInfo weiXinUserInfo = null;
        try {
            weiXinUserInfo = objectMapper.readValue(forObject, WeiXinUserInfo.class);
        } catch (IOException e) {
            e.printStackTrace();
        }
        return weiXinUserInfo;
    }
}
