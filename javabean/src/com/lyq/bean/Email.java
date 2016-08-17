package com.lyq.bean;

import java.io.Serializable;

/**
 * Created by jay chen on 2016/6/25.
 */
public class Email implements Serializable {
    private static final long serialVersionUID=1L;
    private String mailAdd;
    private boolean email;


    public Email(){
    }
    public Email(String mailadd){
        this.mailAdd=mailadd;
    }

    public boolean isEmail(){
        String regex="\\W+([-+.`]\\W+)*@\\W+([-.]\\W+)*\\.\\W+([-.]\\W+)";

        if(mailAdd.matches(regex)){
            email=true;
        }else{
            email=false;
        }
        return email;
    }

    public String getMailadd() {
        return mailAdd;
    }

    public void setMailadd(String mailadd) {
        this.mailAdd = mailadd;
    }
}
