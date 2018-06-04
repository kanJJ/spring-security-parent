package com.security.core.code;

import org.springframework.web.context.request.ServletWebRequest;

/**
 * 使用依赖查找必须实现的接口
 * Created by Chris on 2018/4/26.
 */
public interface ValidateCodeProcess {
    public void create(ServletWebRequest web);
    public void validate(ServletWebRequest request);
}
