import javax.servlet.*;
import javax.servlet.http.HttpServletRequest;
import java.io.IOException;

/**
 * Created by jay chen on 2016/7/3.
 */
public class MyFilter implements Filter {
    private int count;
    public void destroy() {
    }

    public void doFilter(ServletRequest req, ServletResponse resp, FilterChain chain) throws javax.servlet.ServletException, IOException {
        count++;
        HttpServletRequest request=(HttpServletRequest)req;
        ServletContext context=request.getSession().getServletContext();
        context.setAttribute("count",count);//更新初始化参数
        chain.doFilter(req, resp);
    }

    public void init(FilterConfig config) throws ServletException {
        String param=config.getInitParameter("count");
        this.count=Integer.valueOf(param);
    }

}
