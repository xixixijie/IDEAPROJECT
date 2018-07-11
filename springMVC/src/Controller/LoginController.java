package Controller;


import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.mvc.Controller;

/**
 * Created by xixi on 2018/7/6.
 */
public class LoginController implements Controller {
    @Override
    public ModelAndView handleRequest(javax.servlet.http.HttpServletRequest httpServletRequest, javax.servlet.http.HttpServletResponse httpServletResponse) throws Exception {
        System.out.println("进入控制器");
        ModelAndView mav=new ModelAndView();
        mav.setViewName("main");

        return mav;
    }
}
