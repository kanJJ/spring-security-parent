package com.security.core.code;

import org.springframework.web.context.request.ServletWebRequest;

/**
 * Created by Chris on 2018/4/15.
 */
public interface ValidateCodeGenerator {
    public ImageCode generate(ServletWebRequest request);
}
