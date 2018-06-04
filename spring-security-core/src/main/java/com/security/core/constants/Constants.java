package com.security.core.constants;

/**
 * Created by Chris on 2018/4/15.
 */
public class Constants {
    // 根据动态拼接， 可以获取image 和 sms 的session key
    public static final String SESSION_CODE_KEY_PREFIX = "SESSION_CODE_KEY_";
    // 图形验证码存在session中的 key
    public static final String SESSION_CODE_KEY_IMAGE = "SESSION_CODE_KEY_IMAGE";
    // 短信验证码存在session中的 key
    public static final String SESSION_CODE_KEY_SMS = "SESSION_CODE_KEY_SMS";
    // 短信验证码 url上参数明曾
    public static final String DEFAULT_PARAMETER_NAME_CODE_SMS = "smsCode";
    // 图形验证码 url上参数明曾
    public static final String DEFAULT_PARAMETER_NAME_CODE_IMAGE = "imageCode";
    // 入参 手机号
    public static final String DEFAULT_PARAMETER_NAME_MOBILE = "mobile";
    // 引导用户跳转默认登录页面，根据后缀不同显示不同方式，适配浏览器和手机端
    public static final String DEFAULT_UNAUTHENTICATION_URL = "/authentication/require";
    // 默认用户名密码表单登录方式拦截路径
    public static final String DEFAULT_LOGIN_PROCESSING_URL_FORM = "/authenticate/form";
    // 默认手机验证码登录拦截路径
    public static final String DEFAULT_LOGIN_PROCESSING_URL_MOBILE=  "/authenticate/mobile";
    // 获取图形验证码及短信验证码前缀
    public static final String  DEFAULT_VALIDATE_CODE_URL_PREFIX = "/code/";

}
