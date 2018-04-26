package com.security.core.code;

import com.security.core.model.ValidateCode;
import org.springframework.web.context.request.ServletWebRequest;

/**
 * Created by Chris on 2018/4/25.
 */
public interface ValidateCodeGenerator {

    public ValidateCode generate(ServletWebRequest web);
}
