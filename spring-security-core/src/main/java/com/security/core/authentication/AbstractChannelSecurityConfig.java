package com.security.core.authentication;

import com.security.core.constants.Constants;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.web.authentication.AuthenticationFailureHandler;
import org.springframework.security.web.authentication.AuthenticationSuccessHandler;

/**
 * Created by chris on 2018/6/4.
 */
public class AbstractChannelSecurityConfig extends WebSecurityConfigurerAdapter {

    @Autowired
    private AuthenticationFailureHandler loginFailedHandler;

    @Autowired
    private AuthenticationSuccessHandler loginSuccessHandler;

    protected void applyPasswordAuthenticationConfig(HttpSecurity http) throws Exception {
       http.formLogin()
               .loginPage(Constants.DEFAULT_UNAUTHENTICATION_URL)
               .loginProcessingUrl(Constants.DEFAULT_LOGIN_PROCESSING_URL_FORM)
               .successHandler(loginSuccessHandler)
               .failureHandler(loginFailedHandler);
    }
}
