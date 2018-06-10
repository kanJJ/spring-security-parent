package com.security.core.social;

import org.apache.commons.collections.CollectionUtils;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.web.servlet.view.AbstractView;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * 获取应用是否绑定其他账户信息
 * Created by Chris on 2018/6/10.
 */
@Component("connect/status")
public class ConnectStatusView extends AbstractView {

    @Autowired
    private ObjectMapper objectMapper;

    @Override
    protected void renderMergedOutputModel(Map<String, Object> model, HttpServletRequest request, HttpServletResponse response) throws Exception {
        Map<String, List> connectMap = (Map<String, List>) model.get("connectionMap");
            Map<String, Boolean> result = new HashMap<String, Boolean>();
            for (String key : connectMap.keySet()) {
                result.put(key, CollectionUtils.isNotEmpty(connectMap.get(key)));
            }

        response.setContentType("application/json;charset=utf-8");
        response.getWriter().write(objectMapper.writeValueAsString(result));
    }
}
