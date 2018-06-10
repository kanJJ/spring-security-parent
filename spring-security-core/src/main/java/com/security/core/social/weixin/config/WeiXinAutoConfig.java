package com.security.core.social.weixin.config;

import com.security.core.properties.SecurityProperties;
import com.security.core.properties.social.WeiXinProperties;
import com.security.core.social.weixin.connect.WeiXinConnectionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.autoconfigure.condition.ConditionalOnProperty;
import org.springframework.boot.autoconfigure.social.SocialAutoConfigurerAdapter;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.social.connect.ConnectionFactory;
import org.springframework.social.security.SpringSocialConfigurer;

/**
 * Created by Chris on 2018/6/10.
 */
@Configuration
@ConditionalOnProperty(prefix = "security.social.Weixin", name="appId")
public class WeiXinAutoConfig extends SocialAutoConfigurerAdapter {

    @Autowired
    private SecurityProperties securityProperties;

    @Override
    protected ConnectionFactory<?> createConnectionFactory() {
        WeiXinProperties weixin = securityProperties.getSocial().getWeixin();
        return new WeiXinConnectionFactory(weixin.getProvideId(),weixin.getAppId(), weixin.getAppSecret());
    }

    //配置bean 对象
    @Bean
    public SpringSocialConfigurer weixinSpringSocialConfigurer() {
        return new SpringSocialConfigurer();
    }

}
