package servlet;

import DAO.ProDao;
import bean.DividePage;
import bean.Product;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.LinkedList;
import java.util.List;

/**
 * Created by jay chen on 2016/9/3.
 */
@WebServlet(name = "DivideServlet",urlPatterns = "/DivideServlet")
public class DivideServlet extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        int currPage=1;
        if(request.getParameter("page")!=null){
            currPage=Integer.parseInt(request.getParameter("page"));
        }
        String proname=request.getParameter("proname");
        String[] ids =request.getParameterValues("ids");



        List<Product> list=new LinkedList<>();

        if((proname==null||"".equals(proname))&&ids==null) {
            list = ProDao.find(currPage);
        }else if(ids!=null){
            int[] proid=new int[100] ;
            for (int i = 0; i < ids.length; i++) {
                proid[i]=Integer.valueOf(ids[i]);
            }
            ProDao.delPro(proid);
            list=ProDao.find(currPage);
        }else{
            list=ProDao.searchPro(proname);
        }
        request.setAttribute("currPage",currPage);
        request.setAttribute("list",list);
        int maxpage=0;
        int count =ProDao.findCount();
        if(count% DividePage.getPageSize()==0){
            maxpage=count/DividePage.getPageSize();
        }else{
            maxpage=count/DividePage.getPageSize()+1;
        }
        request.setAttribute("maxpage",maxpage);
        StringBuffer sb=new StringBuffer();
        for(int i=1;i<=maxpage;i++){
            if(i==currPage){
                sb.append("["+i+"]");
            }else{
                sb.append("<a href='DivideServlet?page="+i+"'>"+i+"</a>");
            }
            sb.append(" ");
        }
        request.setAttribute("bar",sb.toString());
        request.getRequestDispatcher("main.jsp").forward(request,response);
    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        this.doPost(request,response);
    }
}
