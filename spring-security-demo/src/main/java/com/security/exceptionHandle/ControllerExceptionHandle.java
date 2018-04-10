package com.security.exceptionHandle;

import com.security.exception.UserException;
import org.apache.commons.collections.map.HashedMap;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.ResponseStatus;

import java.util.Map;

/**
 * Created by Chris on 2018/4/10.
 */
@ControllerAdvice
public class ControllerExceptionHandle {

    @ExceptionHandler(UserException.class)
    @ResponseBody
    @ResponseStatus(HttpStatus.INTERNAL_SERVER_ERROR)
    public Map<String, Object> userExceptionHandle(UserException ex) {
        Map<String, Object> map = new HashedMap();
        map.put("id", ex.getId());
        map.put("detail",ex.getLocalizedMessage());
        return map;
    }

}
