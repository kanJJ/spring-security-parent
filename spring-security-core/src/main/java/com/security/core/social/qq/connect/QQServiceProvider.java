package com.security.core.social.qq.connect;

import com.security.core.social.qq.api.QQ;
import com.security.core.social.qq.api.QQImpl;
import org.springframework.social.oauth2.AbstractOAuth2ServiceProvider;
import org.springframework.social.oauth2.OAuth2Template;

/**
 * Created by Chris on 2018/5/25.
 */
public class QQServiceProvider extends AbstractOAuth2ServiceProvider<QQ> {

    private String clientId;
    private String clientSecret;
    private static final String AUTH_CODE_URL = "https://graph.qq.com/oauth2.0/authorize";
    private static final String TOKEN_URL = "https://graph.qq.com/oauth2.0/token";

    /**
     * Create a new {@link OAuth2ServiceProvider}.
     *
     * @param oauth2Operations the OAuth2Operations template for conducting the OAuth 2 flow with the provider.
     */
    public QQServiceProvider(String clientId, String clientSecret) {
        super(new OAuth2Template(clientId, clientSecret, AUTH_CODE_URL, TOKEN_URL));
        this.clientId = clientId;
        this.clientSecret = clientSecret;
    }

    @Override
    public QQ getApi(String accessToken) {
        return new QQImpl(accessToken, this.clientId);
    }

}
