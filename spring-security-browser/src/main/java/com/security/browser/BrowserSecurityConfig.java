package com.security.browser;

import com.security.core.properties.SecurityProperties;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.security.web.authentication.AuthenticationSuccessHandler;

/**
 * Created by Chris on 2018/4/11.
 */
// @EnableWebSecurity
public class BrowserSecurityConfig extends WebSecurityConfigurerAdapter {
    @Bean
    public PasswordEncoder passwordEncoder() {
        return new BCryptPasswordEncoder();
    }

    @Autowired
    private AuthenticationSuccessHandler loginSuccessHandler;

    @Autowired
    private SecurityProperties sp;

    @Override
    protected void configure(HttpSecurity http) throws Exception {
        http.formLogin().loginPage("/index").loginProcessingUrl("/authenticate/require").permitAll().successHandler(loginSuccessHandler)
                .and().authorizeRequests().antMatchers(sp.getBrowser().getLoginPage()).permitAll().anyRequest().authenticated()
        .and().csrf().disable();
    }
}
