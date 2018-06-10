package com.security.browser.session;

import org.apache.commons.lang.StringUtils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.security.web.DefaultRedirectStrategy;
import org.springframework.security.web.RedirectStrategy;
import org.springframework.security.web.session.InvalidSessionStrategy;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

/**
 * Created by Chris on 2018/6/11.
 */
public class DefaultInvalidSessionStrategy implements InvalidSessionStrategy {

    private Logger logger = LoggerFactory.getLogger(this.getClass());

    private String invalidUrl;

    private RedirectStrategy redirectStrategy = new DefaultRedirectStrategy();
    /**
     * 跳转前是否创建新的session
     */
    private boolean createNewSession = true;

    public DefaultInvalidSessionStrategy(String invalidUrl) {
        this.invalidUrl = invalidUrl;
    }

    @Override
    public void onInvalidSessionDetected(HttpServletRequest request, HttpServletResponse response) throws IOException, ServletException {
        if (createNewSession) {
            request.getSession();
        }
        String requestURL = request.getRequestURL().toString();
        if (requestURL != null && StringUtils.endsWithIgnoreCase(requestURL, ".html")) {
            String target = invalidUrl + ".html";
            logger.info("session 过期 重定向目标路径："+ target);
            redirectStrategy.sendRedirect(request, response, target);
        }else {
            response.setContentType("application/json;charset=utf-8");
            response.getWriter().write("session 过期");
        }
    }

    public boolean isCreateNewSession() {
        return createNewSession;
    }

    public void setCreateNewSession(boolean createNewSession) {
        this.createNewSession = createNewSession;
    }
}
