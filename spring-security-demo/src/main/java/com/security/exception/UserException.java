package com.security.exception;

/**
 * Created by Chris on 2018/4/10.
 */
public class UserException extends RuntimeException {

    private String id;

    public UserException(String id) {
        super("user is not exist!");
        this.id = id;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }
}
