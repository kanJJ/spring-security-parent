package com.security.model;

import com.fasterxml.jackson.annotation.JsonView;
import com.security.valid.MyNotNull;

import javax.validation.constraints.NotNull;

/**
 * Created by Chris on 2018/4/9.
 */
public class User {
    private interface SimpleView {};
    private interface  View extends SimpleView {};

    @MyNotNull(message = "username bu neng wei kong")
    @JsonView(SimpleView.class)
    private String username;

    @JsonView(SimpleView.class)
    private String id;

    @NotNull
    @JsonView(View.class)
    private String password;

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }
}
