package com.security.core.filter;

import com.security.core.constants.Constants;
import com.security.core.exception.ValidateCodeException;
import com.security.core.properties.SecurityProperties;
import org.apache.commons.lang.StringUtils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.InitializingBean;
import org.springframework.security.web.authentication.AuthenticationFailureHandler;
import org.springframework.social.connect.web.HttpSessionSessionStrategy;
import org.springframework.social.connect.web.SessionStrategy;
import org.springframework.util.AntPathMatcher;
import org.springframework.web.context.request.ServletWebRequest;
import org.springframework.web.filter.OncePerRequestFilter;

import javax.servlet.FilterChain;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.HashSet;

/**
 * Created by Chris on 2018/4/15.
 */
public class ImageCodeValidFilter extends OncePerRequestFilter implements InitializingBean {

    Logger logger = LoggerFactory.getLogger(getClass());

    private SessionStrategy sessionStrategy = new HttpSessionSessionStrategy();

    private AuthenticationFailureHandler authenticationFailHandler;

    private SecurityProperties securityProperties;

    public SecurityProperties getSecurityProperties() {
        return securityProperties;
    }

    public void setSecurityProperties(SecurityProperties securityProperties) {
        this.securityProperties = securityProperties;
    }

    private HashSet<String> urls = new HashSet<>();

    private AntPathMatcher antPathMatcher = new AntPathMatcher();

    @Override
    public void afterPropertiesSet() throws ServletException {
        super.afterPropertiesSet();
        String[] configUrls = StringUtils.splitByWholeSeparator(securityProperties.getCode().getUrls(),",");
        for (String url: configUrls) {
            urls.add(url);
        }
        urls.add("/authenticate/require");
    }

    @Override
    protected void doFilterInternal(HttpServletRequest request, HttpServletResponse response, FilterChain filterChain) throws ServletException, IOException {
        Boolean action = false;
        for (String url: urls) {
            if (antPathMatcher.match(url, request.getRequestURI())) {
                action = true;
            }
        }

        if (action) {
            try {
                validate(new ServletWebRequest(request));
            }catch (ValidateCodeException e) {
                authenticationFailHandler.onAuthenticationFailure(request, response, e);
                return;
            }
        }
        filterChain.doFilter(request, response);
    }

    private void validate(ServletWebRequest request) {
        Object sessionCode = sessionStrategy.getAttribute(request, Constants.SESSION_IMAGE_CODE_KEY);
        if (sessionCode == null) {
            throw  new ValidateCodeException("qing shua xin ye mian");
        }
        String code = sessionCode.toString();
        String imagecode = request.getParameter("imagecode");
        if (StringUtils.isBlank(imagecode) ) {
            throw  new ValidateCodeException("yanzhengma buneng wei kong");
        }
        if (!StringUtils.equals(code,imagecode )) {
            throw  new ValidateCodeException("yan zheng ma cuo wu");
        }
        sessionStrategy.removeAttribute(request, Constants.SESSION_IMAGE_CODE_KEY);
    }

    public AuthenticationFailureHandler getAuthenticationFailHandler() {
        return authenticationFailHandler;
    }

    public void setAuthenticationFailHandler(AuthenticationFailureHandler authenticationFailHandler) {
        this.authenticationFailHandler = authenticationFailHandler;
    }
}
