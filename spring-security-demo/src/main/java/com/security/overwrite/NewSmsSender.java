package com.security.overwrite;

import com.security.core.code.sms.SmsSender;

/**
 * Created by Chris on 2018/4/26.
 */
//@Component
public class NewSmsSender implements SmsSender {
    @Override
    public String sender(String mobile, String code) {
        System.out.println("****************** ****************************");
        System.out.println(mobile);
        System.out.println(code);
        return null;
    }
}
