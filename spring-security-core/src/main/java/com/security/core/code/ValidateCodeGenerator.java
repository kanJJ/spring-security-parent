package com.security.core.code;

import com.security.core.model.ValidateCode;
import org.springframework.web.context.request.ServletWebRequest;

/**
 * 验证码生成接口
 * Created by Chris on 2018/4/25.
 */
public interface ValidateCodeGenerator {

    public ValidateCode generate(ServletWebRequest web);

}
