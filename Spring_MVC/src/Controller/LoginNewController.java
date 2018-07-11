package Controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

/**
 * Created by xixi on 2018/7/6.
 */
@Controller
public class LoginNewController {

    @RequestMapping("Login")
    public ModelAndView login(){
        ModelAndView mav=new ModelAndView();
        mav.setViewName("main");
        return mav;
    }

    /*
    RequestMapping注解，
    可以在应用类的上方，也可以在下方
     */
}
