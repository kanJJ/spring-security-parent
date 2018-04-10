package com.security.register;

import com.security.filter.TimerFilter;
import com.security.interceptor.TimerInterceptor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.web.servlet.FilterRegistrationBean;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.InterceptorRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurerAdapter;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by Chris on 2018/4/10.
 */
@Configuration
public class WebRegister extends WebMvcConfigurerAdapter {

    @Autowired
    private TimerInterceptor timerInterceptor;

    @Bean
    public FilterRegistrationBean timeFilter() {
        FilterRegistrationBean frb = new FilterRegistrationBean();
        TimerFilter tf = new TimerFilter();
        frb.setFilter(tf);
        List<String> urls = new ArrayList<>();
        urls.add("/*");
        frb.setUrlPatterns(urls);
        return frb;
    }

    @Override
    public void addInterceptors(InterceptorRegistry registry) {
        registry.addInterceptor(timerInterceptor);
        super.addInterceptors(registry);
    }
}
