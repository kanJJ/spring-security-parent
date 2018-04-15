package com.security.core.properties;

import org.springframework.boot.context.properties.ConfigurationProperties;

/**
 * Created by Chris on 2018/4/12.
 */
@ConfigurationProperties(prefix = "security")
public class SecurityProperties {
    private BrowserProperties browser = new BrowserProperties();

    public BrowserProperties getBrowser() {
        return browser;
    }

    public void setBrowser(BrowserProperties browser) {
        this.browser = browser;
    }

    private ValidateCodeProperties code = new ValidateCodeProperties();

    public ValidateCodeProperties getCode() {
        return code;
    }

    public void setCode(ValidateCodeProperties code) {
        this.code = code;
    }
}
