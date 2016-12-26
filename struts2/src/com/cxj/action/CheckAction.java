package com.cxj.action;

import com.opensymphony.xwork2.ActionSupport;

/**
 * Created by xixi on 13/12/2016.
 */
public class CheckAction extends ActionSupport {
    private String username;
    private String password;

    public String execute() throws Exception{
        return SUCCESS;
    }

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
}
