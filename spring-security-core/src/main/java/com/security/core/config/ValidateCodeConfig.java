package com.security.core.config;

import com.security.core.code.image.ImageCodeGenerator;
import com.security.core.code.sms.SmsCodeGenerator;
import com.security.core.code.ValidateCodeGenerator;
import com.security.core.code.sms.DefaultSmsSender;
import com.security.core.code.sms.SmsSender;
import com.security.core.properties.SecurityProperties;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.autoconfigure.condition.ConditionalOnMissingBean;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

/**
 * Created by Chris on 2018/4/15.
 */
@Configuration
public class ValidateCodeConfig {

    @Autowired
    @SuppressWarnings("SpringJavaAutowiringInspection")
    private SecurityProperties securityProperties;

    @Bean
    @ConditionalOnMissingBean(name = "imageCodeGenerator")
    public ValidateCodeGenerator imageCodeGenerator() {
        ImageCodeGenerator imageCodeGenerator = new ImageCodeGenerator();
        imageCodeGenerator.setSecurityProperties(securityProperties);
        return imageCodeGenerator;
    }

    @Bean
    @ConditionalOnMissingBean(name="smsCodeGenerator")
    public ValidateCodeGenerator smsCodeGenerator() {
        SmsCodeGenerator sms = new SmsCodeGenerator();
        sms.setSecurityProperties(securityProperties);
        return sms;
    }

    @Bean
    @ConditionalOnMissingBean(SmsSender.class)
    public SmsSender smsSender() {
        return new DefaultSmsSender();
    }



}
