package com.cxj.listener; /**
 * Created by jay chen on 2016/8/23.
 */

import com.cxj.bean.UserInfoList;

import javax.servlet.ServletContextEvent;
import javax.servlet.ServletContextListener;
import javax.servlet.annotation.WebListener;
import javax.servlet.http.*;

@WebListener()
public class MyListener implements HttpSessionBindingListener {

    private String user;
    private UserInfoList container=UserInfoList.getInstance();
    // Public constructor is required by servlet spec
    public MyListener() {
        this.user="";
    }

    public void setUser(String user){
        this.user=user;
    }

    public String getUser(){
        return this.user;
    }


    @Override
    public void valueBound(HttpSessionBindingEvent httpSessionBindingEvent) {
        System.out.println(this.user+"上线");
    }

    @Override
    public void valueUnbound(HttpSessionBindingEvent httpSessionBindingEvent) {
        System.out.println(this.user+"下线");
        if(user!=""){
            container.removeUserInfo(user);
        }
    }
}
