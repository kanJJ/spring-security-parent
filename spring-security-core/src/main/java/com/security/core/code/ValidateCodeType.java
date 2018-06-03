package com.security.core.code;

import com.security.core.constants.Constants;

/**
 * Created by chris on 2018/6/3.
 */
public enum ValidateCodeType {
    /**+
     * SMS
     */
    SMS {
        @Override
        public String getParamNameOnValidate() {
            return Constants.DEFAULT_PARAMETER_NAME_CODE_SMS;
        }
    },

    /**
     * IMAGE
     */
    IMAGE {
        @Override
        public String getParamNameOnValidate() {
            return Constants.DEFAULT_PARAMETER_NAME_CODE_IMAGE;
        }
    };

    /**
     * get key from request urls
     * @return
     */
    public abstract String getParamNameOnValidate();
}
