package com.cxj.bean;

import java.util.Vector;

/**
 * Created by jay chen on 2016/8/23.
 */
public class UserInfoList {
    private static UserInfoList user=new UserInfoList();
    private Vector vector=null;

    private UserInfoList(){
        this.vector=new Vector();
    }

    public static UserInfoList getInstance(){
        return user;
    }

    public boolean addUserInfo(String user){
        if(user!=null){
            this.vector.add(user);
            return true;
        }else {
         return false;
        }
    }

    public Vector getList(){
        return vector;
    }

    public void removeUserInfo(String user){
        if(user!=null){
            vector.removeElement(user);
        }
    }
}

