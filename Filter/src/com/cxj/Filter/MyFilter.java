package com.cxj.Filter;

import javax.servlet.*;
import javax.servlet.annotation.WebFilter;
import javax.servlet.http.HttpServletRequest;
import java.io.IOException;

/**
 * Created by jay chen on 2016/8/23.
 */
@WebFilter(filterName = "MyFilter")
public class MyFilter implements Filter {
    //来访数量
    private int count;
    public void destroy() {
    }

    public void doFilter(ServletRequest req, ServletResponse resp, FilterChain chain) throws ServletException, IOException {
        count++;
        HttpServletRequest request=(HttpServletRequest)req;

        ServletContext sc=request.getSession().getServletContext();
        sc.setAttribute("count",count);
        chain.doFilter(req, resp);
    }

    public void init(FilterConfig config) throws ServletException {
        String param=config.getInitParameter("count");
        count=Integer.valueOf(param);
    }

}
