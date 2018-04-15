package com.security.core.controller;

import com.security.core.code.ImageCode;
import com.security.core.code.ValidateCodeGenerator;
import com.security.core.constants.Constants;
import com.security.core.properties.SecurityProperties;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.social.connect.web.HttpSessionSessionStrategy;
import org.springframework.social.connect.web.SessionStrategy;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.context.request.ServletWebRequest;

import javax.imageio.ImageIO;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

/**
 * Created by Chris on 2018/4/15.
 */
@RestController
@RequestMapping(value = "/code")
public class ImageCodeValidController {

    SessionStrategy ss = new HttpSessionSessionStrategy();

    @Autowired
    private SecurityProperties securityProperties;

    @Autowired
    private ValidateCodeGenerator imageCodeGenerator;

    @GetMapping("/image")
    public void getimageCode(HttpServletRequest request, HttpServletResponse response) throws IOException {
        ImageCode generate = imageCodeGenerator.generate(new ServletWebRequest(request));
        ss.setAttribute(new ServletWebRequest(request), Constants.SESSION_IMAGE_CODE_KEY ,generate.getCode());
        ImageIO.write(generate.getImage(), "jpeg", response.getOutputStream());
    }

}
