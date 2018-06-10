package com.security.core.social.weixin.connect;

import com.security.core.social.weixin.api.WeiXin;
import com.security.core.social.weixin.api.WeiXinImpl;
import org.springframework.social.oauth2.AbstractOAuth2ServiceProvider;

/**
 * Created by Chris on 2018/6/10.
 */
public class WeiXinServiceProvider extends AbstractOAuth2ServiceProvider<WeiXin> {


    /**
     * 微信获取授权码的url
     */
    private static final String URL_AUTHORIZE = "https://open.weixin.qq.com/connect/qrconnect";
    /**
     * 微信获取accessToken的url
     */
    private static final String URL_ACCESS_TOKEN = "https://api.weixin.qq.com/sns/oauth2/access_token";
    /**
     *
     *  the OAuth2Operations template for conducting the OAuth 2 flow with the provider.
     */
    public WeiXinServiceProvider(String clientId, String clientSecret) {
        super(new WeixinOAuth2Template(clientId , clientSecret, URL_AUTHORIZE, URL_ACCESS_TOKEN));
    }

    @Override
    public WeiXin getApi(String openId) {
        return new WeiXinImpl(openId);
    }
}
