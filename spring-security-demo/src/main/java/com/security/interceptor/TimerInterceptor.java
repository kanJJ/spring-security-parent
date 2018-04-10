package com.security.interceptor;

import org.springframework.stereotype.Component;
import org.springframework.web.method.HandlerMethod;
import org.springframework.web.servlet.HandlerInterceptor;
import org.springframework.web.servlet.ModelAndView;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.util.Date;

/**
 * Created by Chris on 2018/4/10.
 */
@Component
public class TimerInterceptor implements HandlerInterceptor {
    @Override
    public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object handler) throws Exception {
        System.out.println("time interceptor prehandle...");
        request.setAttribute("start", new Date().getTime());
        return true;
    }

    @Override
    public void postHandle(HttpServletRequest request, HttpServletResponse response, Object handler, ModelAndView modelAndView) throws Exception {
        System.out.println("time interceptor postHandle...");
        Object start = request.getAttribute("start");
        System.out.println(((HandlerMethod) handler).getMethod().getName());
        System.out.println(((HandlerMethod) handler).getClass().getName());
        System.out.println("total time:" + (new Date().getTime() - Long.parseLong(start.toString())));
    }

    @Override
    public void afterCompletion(HttpServletRequest request, HttpServletResponse response, Object handler, Exception ex) throws Exception {
        System.out.println("        System.out.println(time interceptor afterCompletion...");
    }
}
