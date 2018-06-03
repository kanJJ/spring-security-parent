package com.security.core.code;

import org.springframework.web.context.request.ServletWebRequest;

/**
 * Created by Chris on 2018/4/26.
 */
public interface ValidateCodeProcess {
    public void create(ServletWebRequest web);
    public void validate(ServletWebRequest request);
}
