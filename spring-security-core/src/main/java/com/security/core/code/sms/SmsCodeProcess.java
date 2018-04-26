package com.security.core.code.sms;

import com.security.core.code.AbstractValidateCodeProcess;
import com.security.core.model.ValidateCode;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.web.bind.ServletRequestUtils;
import org.springframework.web.context.request.ServletWebRequest;

/**
 * Created by Chris on 2018/4/26.
 */
@Component("smsCodeProcess")
public class SmsCodeProcess extends AbstractValidateCodeProcess<ValidateCode> {

    @Autowired
    private SmsSender smsSender;

    @Override
    public void sender(ServletWebRequest web, ValidateCode code) {
        try {
            String mobile = ServletRequestUtils.getRequiredStringParameter(web.getRequest(), "mobile");
            smsSender.sender(mobile, code.getCode());
        }catch (Exception e) {

        }
    }
}
