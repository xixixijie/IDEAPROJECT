package com.ssm.model.service;

import com.ssm.model.bean.UserInfo;
import com.ssm.model.dao.UserInfoDAO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

/**
 * Created by xixi on 2018/7/11.
 */

@Service
public class UserService {

    @Autowired
    private UserInfoDAO userInfoDAO;

    public List<UserInfo> selectUsers(){
        return userInfoDAO.selectUsers();
    }

}
