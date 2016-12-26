package com.cxj.action;

import com.opensymphony.xwork2.ActionSupport;

//import com.sun.org.apache.xpath.internal.operations.String;

/**
 * Created by xixi on 06/12/2016.
 */
public class UserAction extends ActionSupport {
    private static final long serialVersionUID=1L;
    private String name;
    private String password;
    private String description;
    private int sex=0;
    private String province;
    private String[] hobby;


//    private String info;
//
//    public String add() throws Exception{
//        info = "添加用户信息";
//        return "add";
//    }
//
//    public String update() throws Exception{
//        info = "更新用户信息";
//        return "update";
//    }
//
//    public String getInfo() {
//        return info;
//    }
//
//    public void setInfo(String info) {
//        this.info = info;
//    }
//
//    public String execute(){
//        return SUCCESS;
//    }
//    private User user;

    public String execute() throws Exception{
        return SUCCESS;
    }
    public String register() throws Exception{
        return SUCCESS;
    }

//    public User getUser(){
//        return user;
//    }
//
//    public void setUser(User user){
//        this.user=user;
//    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public int getSex() {
        return sex;
    }

    public void setSex(int sex) {
        this.sex = sex;
    }

    public String getProvince() {
        return province;
    }

    public void setProvince(String province) {
        this.province = province;
    }

    public String[] getHobby() {
        return hobby;
    }

    public void setHobby(String[] hobby) {
        this.hobby = hobby;
    }
}
