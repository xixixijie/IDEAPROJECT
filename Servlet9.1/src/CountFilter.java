import javax.servlet.ServletContext;
import javax.servlet.http.HttpServletRequest;
import java.io.IOException;

/**
 * Created by jay chen on 2016/7/3.
 */
public class CountFilter implements javax.servlet.Filter {
    private int count;
    public void destroy() {
    }

    public void doFilter(javax.servlet.ServletRequest req, javax.servlet.ServletResponse resp, javax.servlet.FilterChain chain) throws javax.servlet.ServletException, IOException {
        count++;

        HttpServletRequest request=(HttpServletRequest)req;
        ServletContext context=request.getSession().getServletContext();
        context.setAttribute("count",count);

        chain.doFilter(req, resp);
    }

    public void init(javax.servlet.FilterConfig config) throws javax.servlet.ServletException {

    }

}
