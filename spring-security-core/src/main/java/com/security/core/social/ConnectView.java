package com.security.core.social;

import org.springframework.web.servlet.view.AbstractView;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.util.Map;

/**
 *
 * 绑定与解绑功能
 * 使用ConnectController 类进行服务封装
 * Created by Chris on 2018/6/10.
 */
public class ConnectView extends AbstractView {
    @Override
    protected void renderMergedOutputModel(Map<String, Object> model, HttpServletRequest request, HttpServletResponse response) throws Exception {
        if (model.get("connection")  == null) {
            response.setContentType("text/html;charset=utf-8");
            response.getWriter().write("<h3>解绑成功</h3>");
        }else {
            response.setContentType("text/html;charset=utf-8");
            response.getWriter().write("<h3>绑定成功</h3>");
        }

    }
}
