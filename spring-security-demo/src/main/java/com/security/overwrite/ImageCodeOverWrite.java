package com.security.overwrite;

import com.security.core.code.ImageCode;
import com.security.core.code.ValidateCodeGenerator;
import org.springframework.stereotype.Component;
import org.springframework.web.context.request.ServletWebRequest;

/**
 * Created by Chris on 2018/4/16.
 */
@Component("imageCodeGenerator")
public class ImageCodeOverWrite implements ValidateCodeGenerator {
    @Override
    public ImageCode generate(ServletWebRequest request) {
        System.out.println("*******************************************************");
        return null;
    }
}
