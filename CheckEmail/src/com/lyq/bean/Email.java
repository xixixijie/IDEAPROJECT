package com.lyq.bean;

import java.io.Serializable;

/**
 * Created by jay chen on 2016/8/18.
 */
public class Email implements Serializable {
    //serialVersionUID值
    private static final long serialVersionUID=1L;
    //Email address
    private String mailAdd;
    //judge a correct mailadd
    private boolean email;
    //default
    public Email(){
    }
    //有参
    public Email(String mailAdd){
        this.mailAdd=mailAdd;
    }
    public boolean isEmail(){
        String regex="\\w+([-+.]\\w+)*@\\w+([-.]\\w+)*\\.\\w+([-.]\\w+)*";

        if(mailAdd.matches(regex)){
            email=true;
        }
        return email;
    }

    public String getMailAdd(){
        return mailAdd;
    }

    public void setMailAdd(String mailAdd){
        this.mailAdd=mailAdd;
    }
}

