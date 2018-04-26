package com.security.core.code.image;

import com.security.core.code.AbstractValidateCodeProcess;
import com.security.core.model.ImageCode;
import org.springframework.stereotype.Component;
import org.springframework.web.context.request.ServletWebRequest;

import javax.imageio.ImageIO;
import java.io.IOException;

/**
 * Created by Chris on 2018/4/26.
 */
@Component("imageCodeProcess")
public class ImageCodeProcess extends AbstractValidateCodeProcess<ImageCode> {
    @Override
    public void sender(ServletWebRequest web, ImageCode code) {
        try {
            ImageIO.write(code.getImage(), "jpeg", web.getResponse().getOutputStream());
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
