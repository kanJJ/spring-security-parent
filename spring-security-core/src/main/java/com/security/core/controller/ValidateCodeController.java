package com.security.core.controller;

import com.security.core.code.ValidateCodeGenerator;
import com.security.core.code.ValidateCodeProcess;
import com.security.core.code.sms.SmsSender;
import com.security.core.properties.SecurityProperties;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.social.connect.web.HttpSessionSessionStrategy;
import org.springframework.social.connect.web.SessionStrategy;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.context.request.ServletWebRequest;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.util.Map;

/**
 * Created by Chris on 2018/4/15.
 */
@RestController
@RequestMapping(value = "/code")
public class ValidateCodeController {

    SessionStrategy ss = new HttpSessionSessionStrategy();

    @Autowired
    private SecurityProperties securityProperties;

    @Autowired
    private ValidateCodeGenerator imageCodeGenerator;

    @Autowired
    private ValidateCodeGenerator smsCodeGenerator;

    @Autowired
    private SmsSender smsSender;

    @Autowired
    private Map<String, ValidateCodeProcess> stringValidateCodeProcessMap;

//    @GetMapping("/image")
//    public void getimageCode(HttpServletRequest request, HttpServletResponse response) throws IOException {
//        ImageCode generate = (ImageCode) imageCodeGenerator.generate(new ServletWebRequest(request));
//        ss.setAttribute(new ServletWebRequest(request), Constants.SESSION_IMAGE_CODE_KEY ,generate.getCode());
//        ImageIO.write(generate.getImage(), "jpeg", response.getOutputStream());
//    }
//
//    @GetMapping("/sms")
//    public void getsmsCode(HttpServletRequest request, HttpServletResponse response) throws IOException, ServletRequestBindingException {
//        ValidateCode generate = smsCodeGenerator.generate(new ServletWebRequest(request));
//        ss.setAttribute(new ServletWebRequest(request), Constants.SESSION_IMAGE_CODE_KEY ,generate.getCode());
//        String mobile = ServletRequestUtils.getRequiredStringParameter(request,"mobile");
//        smsSender.sender(mobile, generate.getCode());
//    }

    @GetMapping("/{type}")
    public void getCode(HttpServletRequest request, HttpServletResponse response , @PathVariable String type) {
        stringValidateCodeProcessMap.get(type+"CodeProcess").create(new ServletWebRequest(request,response));
    }

}
