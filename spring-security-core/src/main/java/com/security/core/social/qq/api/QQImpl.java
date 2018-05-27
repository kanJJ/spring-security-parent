package com.security.core.social.qq.api;

import com.fasterxml.jackson.databind.ObjectMapper;
import org.apache.commons.lang.StringUtils;
import org.springframework.social.oauth2.AbstractOAuth2ApiBinding;
import org.springframework.social.oauth2.TokenStrategy;

import java.io.IOException;

/**
 * Created by Chris on 2018/5/24.
 */
public class QQImpl extends AbstractOAuth2ApiBinding implements QQ {

    private static final String USER_INFO_URL = "https://graph.qq.com/user/get_user_info?oauth_consumer_key=%s&openid=%s";
    private static final String OPEN_ID_URL = "https://graph.qq.com/oauth2.0/me?access_token=%s";


    private String openId;
    private String oauth_consumer_key;
    private ObjectMapper mapper = new ObjectMapper();


    public QQImpl(String accessToken, String oauth_consumer_key) {
        super(accessToken, TokenStrategy.ACCESS_TOKEN_PARAMETER);
        String url = String.format(OPEN_ID_URL, accessToken);
        String result = getRestTemplate().getForObject(url, String.class);
        String id = StringUtils.substringBetween(result, "\"openid\":\"", "\"}");
        this.openId = id;
        this.oauth_consumer_key = oauth_consumer_key;
    }

    @Override
    public QQUserInfo getQQUserInfo() {
        String url = String.format(USER_INFO_URL, this.oauth_consumer_key, this.openId);
        String info = getRestTemplate().getForObject(url, String.class);
        System.out.println(info);
        try {
            return mapper.readValue(info, QQUserInfo.class);
        } catch (IOException e) {
            e.printStackTrace();
            return null;
        }
    }
}
