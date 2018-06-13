package com.security.browser.authentication;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.security.browser.model.SimpleResponse;
import com.security.core.properties.SecurityProperties;
import org.apache.commons.lang.StringUtils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.security.core.Authentication;
import org.springframework.security.web.authentication.logout.LogoutSuccessHandler;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

/**
 * Created by Chris on 2018/6/13.
 */
public class DefaultLoginOutSuccessHandle implements LogoutSuccessHandler {

   private SecurityProperties securityProperties;

    private ObjectMapper objectMapper =  new ObjectMapper();

    public DefaultLoginOutSuccessHandle(SecurityProperties securityProperties) {
        this.securityProperties = securityProperties;
    }

    private Logger logger = LoggerFactory.getLogger(this.getClass());

    @Override
    public void onLogoutSuccess(HttpServletRequest request, HttpServletResponse response, Authentication authentication) throws IOException, ServletException {
        logger.info("退出登录");
        String logoutPageUrl = securityProperties.getBrowser().getLogoutPageUrl();
        if (StringUtils.isNotBlank(logoutPageUrl)) {
            response.sendRedirect(logoutPageUrl);
        }else {
            response.getWriter().write(objectMapper.writeValueAsString(new SimpleResponse("退出成功")));
        }
    }
}
