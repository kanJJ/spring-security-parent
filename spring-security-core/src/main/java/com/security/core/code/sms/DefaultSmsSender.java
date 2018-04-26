package com.security.core.code.sms;

/**
 * Created by Chris on 2018/4/25.
 */
public class DefaultSmsSender implements SmsSender {
    @Override
    public String sender(String mobile, String code) {
        System.out.printf("向%s发送验证码：%s \r\n", mobile, code);
        return null;
    }
}
