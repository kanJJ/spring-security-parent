package com.security.browser;

import com.security.core.filter.ImageCodeValidFilter;
import com.security.core.properties.SecurityProperties;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.security.web.authentication.AuthenticationFailureHandler;
import org.springframework.security.web.authentication.AuthenticationSuccessHandler;
import org.springframework.security.web.authentication.UsernamePasswordAuthenticationFilter;

/**
 * Created by Chris on 2018/4/11.
 */
@EnableWebSecurity
public class BrowserSecurityConfig extends WebSecurityConfigurerAdapter {
    @Bean
    public PasswordEncoder passwordEncoder() {
        return new BCryptPasswordEncoder();
    }

    @Autowired
    private AuthenticationSuccessHandler loginSuccessHandler;

    @Autowired
    private AuthenticationFailureHandler loginFailedHandler;

    @Autowired
    private SecurityProperties sp;



    @Override
    protected void configure(HttpSecurity http) throws Exception {
        ImageCodeValidFilter imageCodeValidFilter = new ImageCodeValidFilter();
        imageCodeValidFilter.setSecurityProperties(sp);
        imageCodeValidFilter.setAuthenticationFailHandler(loginFailedHandler);
        imageCodeValidFilter.afterPropertiesSet();
        http.addFilterBefore(imageCodeValidFilter, UsernamePasswordAuthenticationFilter.class) .formLogin().loginPage("/index").loginProcessingUrl("/authenticate/require").permitAll().successHandler(loginSuccessHandler)
                .and().authorizeRequests().antMatchers(sp.getBrowser().getLoginPage(), "/code/image").permitAll().anyRequest().authenticated()
        .and().csrf().disable();
    }
}
