package com.security.filter;

import javax.servlet.*;
import java.io.IOException;
import java.util.Date;

/**
 * Created by Chris on 2018/4/10.
 */
// @Component
public class TimerFilter implements Filter {
    @Override
    public void init(FilterConfig filterConfig) throws ServletException {
        System.out.println("timer Filter init...");
    }

    @Override
    public void doFilter(ServletRequest request, ServletResponse response, FilterChain chain) throws IOException, ServletException {
        System.out.println("timer Filter doFilter...");
        Long start = new Date().getTime();
        chain.doFilter(request, response);
        System.out.println("total time:" + (new Date().getTime() - start));
    }

    @Override
    public void destroy() {
        System.out.println("time filter destory");
    }
}
