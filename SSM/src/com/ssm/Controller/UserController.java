package com.ssm.Controller;

import com.ssm.model.bean.UserInfo;
import com.ssm.model.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import java.util.List;

/**
 * Created by xixi on 2018/7/11.
 */
@Controller
public class UserController{

    //setter注入 注解
    @Autowired
    private UserService userService;

    @RequestMapping("selectUser")
    public ModelAndView selectUser(){
        //调用service查询

        System.out.println(userService==null);
        List<UserInfo> list=userService.selectUsers();
        ModelAndView mav=new ModelAndView();
        mav.addObject("resultList",list);
        mav.setViewName("select");
        return mav;
    }
}
