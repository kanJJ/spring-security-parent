package com.security.browser;

import com.security.browser.session.DefaultInvalidSessionStrategy;
import com.security.browser.session.DefaultSessionInformationExpiredStrategy;
import com.security.core.properties.SecurityProperties;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.autoconfigure.condition.ConditionalOnMissingBean;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.web.session.InvalidSessionStrategy;
import org.springframework.security.web.session.SessionInformationExpiredStrategy;

/**
 * Created by Chris on 2018/6/11.
 */
@Configuration
public class BrowserSecurityBeanConfig {

    @Autowired
    private SecurityProperties securityProperties;

    @Bean
    @ConditionalOnMissingBean(SessionInformationExpiredStrategy.class)
    public SessionInformationExpiredStrategy defaultSessionInformationExpiredStrategy() {
        return new DefaultSessionInformationExpiredStrategy();
    }

    @Bean
    @ConditionalOnMissingBean(InvalidSessionStrategy.class)
    public InvalidSessionStrategy defaultInvalidSessionStrategy() {
        return new DefaultInvalidSessionStrategy(securityProperties.getSession().getInvalidSessionUrl());
    }
}
