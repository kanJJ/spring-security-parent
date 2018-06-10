package com.security.core.properties;

import com.security.core.properties.social.SocialProperties;
import org.springframework.boot.context.properties.ConfigurationProperties;

/**
 * Created by Chris on 2018/4/12.
 */
@ConfigurationProperties(prefix = "security")
public class SecurityProperties {
    private BrowserProperties browser = new BrowserProperties();
    private SocialProperties social = new SocialProperties();
    private SessionProperties session = new SessionProperties();

    public SessionProperties getSession() {
        return session;
    }

    public void setSession(SessionProperties session) {
        this.session = session;
    }

    public SocialProperties getSocial() {
        return social;
    }

    public void setSocial(SocialProperties social) {
        this.social = social;
    }

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
