package com.security.core.code;

import com.security.core.exception.ValidateCodeException;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.Map;

/**
 * Created by chris on 2018/6/3.
 */
@Component
public class ValidateCodeProcessorHolder {

    private Logger logger =  LoggerFactory.getLogger(this.getClass());

    @Autowired
    private Map<String, ValidateCodeProcess> validateCodeProcessMap;

    public ValidateCodeProcess findProcessByValidateCodeType(ValidateCodeType type) {
        return findProcessByString(type.toString().toLowerCase());
    }

    /**
     * find process by typp
     * @param type
     * @return
     */
    public ValidateCodeProcess findProcessByString (String type) {
        String className = type + ValidateCodeProcess.class.getSimpleName();
        logger.info("use %s to validate", className);
        ValidateCodeProcess validateCodeProcess = validateCodeProcessMap.get(className);
        if (validateCodeProcess == null) {
            throw new ValidateCodeException(className + " is not exist!");
        }
        return validateCodeProcess;
    }
}
