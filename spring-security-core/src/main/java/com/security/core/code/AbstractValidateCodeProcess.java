package com.security.core.code;

import com.security.core.constants.Constants;
import com.security.core.exception.ValidateCodeException;
import com.security.core.model.ValidateCode;
import org.apache.commons.lang.StringUtils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.social.connect.web.HttpSessionSessionStrategy;
import org.springframework.social.connect.web.SessionStrategy;
import org.springframework.web.bind.ServletRequestBindingException;
import org.springframework.web.bind.ServletRequestUtils;
import org.springframework.web.context.request.ServletWebRequest;

import java.util.Map;

import static com.security.core.constants.Constants.SESSION_CODE_KEY_SMS;

/**
 * Created by Chris on 2018/4/26.
 */
public abstract class AbstractValidateCodeProcess<C extends ValidateCode> implements ValidateCodeProcess {

    private Logger logger = LoggerFactory.getLogger(this.getClass());

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
        String type = getProcessType(web);
        if (type == null || type == "") {
            throw new RuntimeException("不能获取url 中 type");
        }

        if ("image".equals(type)) {
            ss.setAttribute(web, Constants.SESSION_CODE_KEY_IMAGE, code.getCode());
        } else if ("sms".equals(type)) {
            ss.setAttribute(web, SESSION_CODE_KEY_SMS, code.getCode());
        } else {
            throw new RuntimeException("url 中 type 不匹配");
        }

    }

    public C general(ServletWebRequest requset) {
        String type = getProcessType(requset);
        ValidateCodeGenerator validateCodeGenerator = validateCodeGeneratorMap.get(type + "CodeGenerator");
        return (C) validateCodeGenerator.generate(requset);
    }

    @Override
    public void validate(ServletWebRequest web) {
        ValidateCodeType type = getValidateCodeType(web);
        String sessionKey = Constants.SESSION_CODE_KEY_PREFIX + type.toString().toUpperCase();
        String sessionCode = (String) ss.getAttribute(web, sessionKey);
        String urlCode = null;
        try {
            urlCode = ServletRequestUtils.getStringParameter(web.getRequest(),
                    type.getParamNameOnValidate());
        } catch (ServletRequestBindingException e) {
            e.printStackTrace();
        }

        if (sessionCode == null) {
            throw new ValidateCodeException("验证码失效，请重新获取");
        }
        if (StringUtils.isBlank(urlCode)) {
            throw new ValidateCodeException("验证码不能为空");
        }
        if (!sessionCode.equals(urlCode)) {
            throw new ValidateCodeException("验证码不匹配");
        }
        ss.removeAttribute(web, sessionKey);
        logger.info("验证成功");
    }

    public String getProcessType(ServletWebRequest web) {
        return StringUtils.substringAfter(web.getRequest().getRequestURI(), Constants.DEFAULT_VALIDATE_CODE_URL_PREFIX);
    }

    public ValidateCodeType getValidateCodeType(ServletWebRequest web) {
        // 子类 smsValidateCodeProcess , 获取类似 sms image 字段
        String s = StringUtils.substringBefore(this.getClass().getSimpleName(), "ValidateCodeProcess");
        return ValidateCodeType.valueOf(s.toUpperCase());
    }

    public abstract void sender(ServletWebRequest web, C code);
}
