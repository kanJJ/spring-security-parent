package com.security.core.exception;

import org.springframework.security.core.AuthenticationException;

/**
 * Created by Chris on 2018/4/15.
 */
public class ValidateCodeException extends AuthenticationException {

    public ValidateCodeException(String msg) {
        super(msg);
    }
}
