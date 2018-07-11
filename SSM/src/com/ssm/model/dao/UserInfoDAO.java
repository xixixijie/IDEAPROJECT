package com.ssm.model.dao;

import com.ssm.model.bean.UserInfo;

import java.util.List;

/**
 * Created by xixi on 2018/7/11.
 */
public interface UserInfoDAO {
    public List<UserInfo> selectUsers();
}
