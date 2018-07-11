package Controller;

import mode.Bean.User;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.validation.ObjectError;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.servlet.ModelAndView;

import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

/**
 * Created by xixi on 2018/7/6.
 */
@Controller
@RequestMapping("user")
public class UserManageController {

    //控制器返回值
    /*
    ModelAndView ：支持页面跳转及数据共享
    String :支持页面跳转也支持数据共享
    支持跳转方式
    void:
    控制器默认支持的参数类型
    model 相当于 request作用域
    httpsession 会话
    httpServletRequest 请求对象
    HttpServletResponse 响应对象

    1。简单类型的参数绑定 可选参数名要和 传过来的名字一样
    2。POJO类型的参数绑定
    3.checkbox参数绑定 list

    validation校验框架

     */
    @RequestMapping(value="select",method = {RequestMethod.GET})
    public ModelAndView selectUser(){

        List<User> list=new ArrayList<>();
        User u1=new User();
        u1.setId(1);
        u1.setUsername("chen");
        u1.setAge(2);
        u1.setEmail("123@1q.q");
        list.add(u1);
        User u2=new User();
        u2.setId(2);
        u2.setUsername("xi");
        u2.setAge(3);
        u2.setEmail("123@1q.q");
        list.add(u2);
        ModelAndView mav=new ModelAndView();
        //数据共享 默认放在请求作用域内
        mav.addObject("list",list);
        //页面跳转，默认请求转发
        mav.setViewName("selectUser");
        return mav;
    }

    @RequestMapping("editUser")
    public String editUser(Model model,Integer userid,User user){
        User u1=new User();
        u1.setId(1);
        u1.setUsername("chen");
        u1.setAge(2);
        u1.setEmail("123@1q.q");
        //数据存在request作用域内
        model.addAttribute("result",u1);
        return "editUser";
//        return "redirect:editUser.jsp";
    }

    @RequestMapping("updateUser")
    public String updateUser(){

        return "redirect:select.action";
    }

    @RequestMapping("addUser")
    public String addUser(@Validated User u, BindingResult bindingResult, Model model, MultipartFile file){
        List<ObjectError> errors=bindingResult.getAllErrors();



        if(errors!=null && errors.size()>0){
            model.addAttribute("errors",errors);
        }
//获取原文件名
        String oldName=file.getOriginalFilename();
       String newName=System.currentTimeMillis()+ oldName.substring(oldName.indexOf("."));
       File file1=new File("d:/photo/",newName);
        try {
            file.transferTo(file1);
        } catch (IOException e) {
            e.printStackTrace();
        }

        return "addUser";
    }


    @RequestMapping("deleteUser")
    public String delete(Integer[] chks){


        return "redirect:select.action";
    }
}
