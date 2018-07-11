package util;

import org.springframework.web.servlet.HandlerExceptionResolver;
import org.springframework.web.servlet.ModelAndView;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Created by xixi on 2018/7/9.
 */
public class CustomerExceptionResovler implements HandlerExceptionResolver {
    @Override
    public ModelAndView resolveException(HttpServletRequest httpServletRequest, HttpServletResponse httpServletResponse, Object o, Exception e) {
        CustomerException customerException;
        if(e instanceof CustomerException){
            customerException =(CustomerException) e;
        }else{
            customerException =new CustomerException("网络异常");
        }

        ModelAndView mav=new ModelAndView();
        mav.addObject("errorMessage",customerException.getMessage());
        mav.setViewName("/error");

        return mav;
    }
}
