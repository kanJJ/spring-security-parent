package com.security.core.social.qq.config;

import com.security.core.properties.SecurityProperties;
import com.security.core.properties.social.QQProperties;
import com.security.core.social.qq.connect.QQConnectFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.autoconfigure.condition.ConditionalOnProperty;
import org.springframework.boot.autoconfigure.social.SocialAutoConfigurerAdapter;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.social.connect.ConnectionFactory;
import org.springframework.social.security.SpringSocialConfigurer;

/**
 * Created by Chris on 2018/5/27.
 */
@Configuration
@ConditionalOnProperty(prefix = "security.social.qq", name="appId")
public class QQAutoConfig extends SocialAutoConfigurerAdapter {

    @Autowired
    private SecurityProperties securityProperties;

    @Override
    protected ConnectionFactory<?> createConnectionFactory() {
        QQProperties qq = securityProperties.getSocial().getQq();
        return new QQConnectFactory(qq.getProvideId(),qq.getAppId(), qq.getAppSecret() );
    }

    /**
     * 用于添加到 spring security 过滤器链上
     * @return
     */
    @Bean
    public SpringSocialConfigurer mySpringSocialConfigurer() {
        return new SpringSocialConfigurer();
    }

}
