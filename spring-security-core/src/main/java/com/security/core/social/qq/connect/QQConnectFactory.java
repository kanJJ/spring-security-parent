package com.security.core.social.qq.connect;

import com.security.core.social.qq.api.QQ;
import org.springframework.social.connect.support.OAuth2ConnectionFactory;

/**
 * Created by Chris on 2018/5/27.
 */
public class QQConnectFactory extends OAuth2ConnectionFactory<QQ> {
    /**
     * Create a {@link OAuth2ConnectionFactory}.
     *
     * @param providerId      the provider id e.g. "facebook"
     * @param clinetId current app id
     * @param clientSecret  current app sevret
     */
    public QQConnectFactory(String providerId, String clinetId, String clientSecret) {
        super(providerId, new QQServiceProvider(clinetId, clientSecret), new QQAdapter());
    }
}
