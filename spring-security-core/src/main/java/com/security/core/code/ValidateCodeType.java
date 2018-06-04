package com.security.core.code;

import com.security.core.constants.Constants;

/**
 * 枚举类，
 *      1 可以根据枚举类的名字，进行依赖查找
 *      2 通过枚举类对URI 进行分类，调用不同接口处理
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
