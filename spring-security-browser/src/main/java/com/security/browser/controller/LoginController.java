package com.security.browser.controller;

import com.security.browser.model.SimpleResponse;
import com.security.core.properties.SecurityProperties;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.security.web.DefaultRedirectStrategy;
import org.springframework.security.web.RedirectStrategy;
import org.springframework.security.web.savedrequest.HttpSessionRequestCache;
import org.springframework.security.web.savedrequest.RequestCache;
import org.springframework.security.web.savedrequest.SavedRequest;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

/**
 * Created by Chris on 2018/4/12.
 */
@RestController
public class LoginController {

    private RequestCache rc = new HttpSessionRequestCache();

    private RedirectStrategy rs = new DefaultRedirectStrategy();

    @Autowired
    private SecurityProperties sp;

    @GetMapping("/index")
    @ResponseStatus(HttpStatus.FORBIDDEN)
    public SimpleResponse authenticateRequest(HttpServletRequest req, HttpServletResponse res) throws IOException {
        SavedRequest request = rc.getRequest(req, res);
        if (request != null) {
            String redirectUrl = request.getRedirectUrl();
            if (redirectUrl != null && redirectUrl.endsWith(".html")) {
                rs.sendRedirect(req, res, sp.getBrowser().getLoginPage());
            }
        }
        res.setContentType("application/json;charset=UTF-8");
        return new SimpleResponse("访问的服务需要身份认证，请引导用户到登录页");
    }
}
