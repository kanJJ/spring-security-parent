package com.security.core.code.sms;

/**
 * Created by Chris on 2018/4/25.
 */
public interface SmsSender {

    public String sender(String mobild, String code);
}
