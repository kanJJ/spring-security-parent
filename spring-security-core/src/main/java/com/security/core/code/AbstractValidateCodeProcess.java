package com.security.core.code;

import com.security.core.constants.Constants;
import com.security.core.model.ValidateCode;
import org.apache.commons.lang.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.social.connect.web.HttpSessionSessionStrategy;
import org.springframework.social.connect.web.SessionStrategy;
import org.springframework.web.context.request.ServletWebRequest;

import java.util.Map;

/**
 * Created by Chris on 2018/4/26.
 */
public abstract class AbstractValidateCodeProcess<C extends ValidateCode> implements ValidateCodeProcess {

    @Autowired
    private Map<String, ValidateCodeGenerator> validateCodeGeneratorMap;

    private SessionStrategy ss = new HttpSessionSessionStrategy();

    @Override
    public void create(ServletWebRequest web) {
        C code = general(web);
        save(web, code);
        sender(web, code);
    }

    public void save(ServletWebRequest web, ValidateCode code) {
        ss.setAttribute(web, Constants.SESSION_IMAGE_CODE_KEY, code.getCode());
    }

    public C general(ServletWebRequest requset) {
        String type = getProcessType(requset);
        ValidateCodeGenerator validateCodeGenerator = validateCodeGeneratorMap.get(type + "CodeGenerator");
        return (C) validateCodeGenerator.generate(requset);
    }

    public String getProcessType(ServletWebRequest web) {
        return StringUtils.substringAfter(web.getRequest().getRequestURI(), "/code/");
    }

    public abstract void sender(ServletWebRequest web, C code);
}
