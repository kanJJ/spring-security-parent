package com.security.core.code;

import com.security.core.constants.Constants;
import com.security.core.exception.ValidateCodeException;
import com.security.core.properties.SecurityProperties;
import org.apache.commons.lang.StringUtils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.web.authentication.AuthenticationFailureHandler;
import org.springframework.social.connect.web.HttpSessionSessionStrategy;
import org.springframework.social.connect.web.SessionStrategy;
import org.springframework.stereotype.Component;
import org.springframework.util.AntPathMatcher;
import org.springframework.web.context.request.ServletWebRequest;
import org.springframework.web.filter.OncePerRequestFilter;

import javax.servlet.FilterChain;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.HashMap;
import java.util.Map;

/**
 * 验证码拦截器
 * 拦截所有路径，做判断调用不同逻辑
 * Created by Chris on 2018/6/3.
 */
@Component("validateCodeFilter")
public class ValidateCodeFilter extends OncePerRequestFilter {

    private Logger logger = LoggerFactory.getLogger(getClass());

    @Autowired
    private AuthenticationFailureHandler loginFailedHandler;

    private SessionStrategy sessionStrategy = new HttpSessionSessionStrategy();

    private Map<String, ValidateCodeType> urlMap = new HashMap<>();
    /**
     *
     */
    @Autowired
    private SecurityProperties securityProperties;

    @Autowired
    private ValidateCodeProcessorHolder validateCodeProcessorHolder;
    /**
     * 验证请求url与配置的url是否匹配的工具类
     */
    private AntPathMatcher pathMatcher = new AntPathMatcher();

    @Override
    public void afterPropertiesSet() {
        // 多链接进行分类， 调用不同的validate方法进行处理
        urlMap.put(Constants.DEFAULT_LOGIN_PROCESSING_URL_FORM, ValidateCodeType.IMAGE);
        urlMap.put(Constants.DEFAULT_LOGIN_PROCESSING_URL_MOBILE, ValidateCodeType.SMS);
        addUrlToMap(securityProperties.getCode().getImage().getUrls(), ValidateCodeType.IMAGE);
        addUrlToMap(securityProperties.getCode().getSms().getUrls(), ValidateCodeType.SMS);
    }

    protected void addUrlToMap(String urls, ValidateCodeType type) {
        if (StringUtils.isNotBlank(urls)) {
            String[] strings = StringUtils.splitByWholeSeparatorPreserveAllTokens(urls, ";");
            for (String url : strings) {
                urlMap.put(url, type);
            }
        }
    }


    @Override
    protected void doFilterInternal(HttpServletRequest request, HttpServletResponse response, FilterChain filterChain) throws ServletException, IOException {
        ValidateCodeType validateCodeType = getValidateCodeType(request);
        // get process
        if (validateCodeType != null) {
            try {
                logger.info("开始类型为 %s 的验证", validateCodeType.toString());
                validateCodeProcessorHolder
                        // 找不同的ValidateCodeProcess 进行处理，
                        .findProcessByValidateCodeType(validateCodeType)
                        // 若子类中没有方法，默认调用父类方法, AbstractValidateCodeProcess
                        .validate(new ServletWebRequest(request, response));
                logger.info("验证成功");
            } catch (ValidateCodeException e) {
                loginFailedHandler.onAuthenticationFailure(request, response, e);
                return;
            }
        }
        filterChain.doFilter(request, response);

    }

    public ValidateCodeType getValidateCodeType(HttpServletRequest request) {
        ValidateCodeType validateCodeType = null;
        // 不能为get类型
        if (!StringUtils.equalsIgnoreCase(request.getMethod(), "get")) {
            String path = request.getRequestURI();
            // 判断是否匹配拦截路径
            for (String url : urlMap.keySet()) {
                if (pathMatcher.match(url, path)) {
                    validateCodeType = urlMap.get(url);
                }
            }
        }
        return validateCodeType;
    }
}
