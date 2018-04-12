package com.security.controller;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import javax.imageio.ImageIO;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.awt.*;
import java.awt.image.BufferedImage;
import java.io.IOException;
import java.io.OutputStream;
import java.util.Random;

/**
 * Created by Chris on 2018/4/12.
 */
@Controller
@RequestMapping(value="/view")
public class ViewController {

    Logger logger = LoggerFactory.getLogger(getClass());

    @RequestMapping(value="/login")
    public String login() {
        return "login";
    }

    @RequestMapping(value="/validatecode")
    public void validatecode(HttpServletRequest request, HttpServletResponse response) throws IOException {
        int width = 80;
        int height = 32;
        //create the image
        BufferedImage image = new BufferedImage(width, height, BufferedImage.TYPE_INT_RGB);
        Graphics g = image.getGraphics();
        // set the background color
        g.setColor(new Color(0xDCDCDC));
        g.fillRect(0, 0, width, height);
        // draw the border
        g.setColor(Color.black);
        g.drawRect(0, 0, width - 1, height - 1);
        // create a random instance to generate the codes
        Random rdm = new Random();
        String hash1 = Integer.toHexString(rdm.nextInt());
        // make some confusion
        for (int i = 0; i < 50; i++) {
            int x = rdm.nextInt(width);
            int y = rdm.nextInt(height);
            g.drawOval(x, y, 0, 0);
        }
        // generate a random code
        String capstr = hash1.substring(0, 4);
        // session.setAttribute("key", capstr);
        g.setColor(new Color(0, 100, 0));
        g.setFont(new Font("Candara", Font.BOLD, 24));
        g.drawString(capstr, 8, 24);
        g.dispose();
        response.setContentType("image/jpeg");
        // out.clear();
        // out = pageContext.pushBody();
        OutputStream strm = response.getOutputStream();
        ImageIO.write(image, "jpeg", strm);
        strm.close();
    }

    @RequestMapping(value="/validate")
    public String validate(@RequestParam String username,
                           @RequestParam String password,
                           Model model) {
        logger.info("username is:", username);
        logger.info("password is:", password);
        model.addAttribute("username", username);
        model.addAttribute("password", password);
        return "success";
    }
}
