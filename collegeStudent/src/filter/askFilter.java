package filter;

import Entity.NewsEntity;
import dao.newsAction;
import javax.servlet.*;
import javax.servlet.annotation.WebFilter;
import javax.servlet.http.HttpServletRequest;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

/**
 * Created by jay chen on 2016/9/16.
 */
public class askFilter implements Filter {
    //来访数量
    private int count;
    public void destroy() {
    }

    public void doFilter(ServletRequest req, ServletResponse resp, FilterChain chain) throws ServletException, IOException {
        count++;
        HttpServletRequest request=(HttpServletRequest)req;

        ServletContext sc=request.getSession().getServletContext();
        sc.setAttribute("count",count);

        req.setCharacterEncoding("UTF-8");
        resp.setCharacterEncoding("UTF-8");
        //lD leftDiv cD centerDiv
        List<NewsEntity> lD1=new ArrayList<>();
        List<NewsEntity> lD2=new ArrayList<>();
        List<NewsEntity> cD1=new ArrayList<>();
        List<NewsEntity> cD2=new ArrayList<>();
        List<NewsEntity> cD3=new ArrayList<>();

        lD1 = newsAction.searchNews("news");
        lD2 =newsAction.searchNews("community_committee");
        cD1=newsAction.searchNews("community_activity");
        cD2=newsAction.randomSearch("competition");
        cD3=newsAction.randomSearch("resource");

        req.setAttribute("lD1",lD1);
        req.setAttribute("lD2",lD2);
        req.setAttribute("cD1",cD1);
        req.setAttribute("cD2",cD2);
        req.setAttribute("cD3",cD3);
        chain.doFilter(req, resp);
    }

    public void init(FilterConfig config) throws ServletException {
        String param=config.getInitParameter("count");
        count=Integer.valueOf(param);
    }

}
