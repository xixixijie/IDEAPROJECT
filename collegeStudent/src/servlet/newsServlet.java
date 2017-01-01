package servlet;


import Entity.NewsEntity;
import dao.newsAction;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

/**
 * Created by jay chen on 2016/9/17.
 */
@WebServlet(name = "newsServlet",urlPatterns = "/newsServlet")
public class newsServlet extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        request.setCharacterEncoding("UTF-8");
        response.setCharacterEncoding("UTF-8");
        List<NewsEntity> list=new ArrayList<NewsEntity>();
        String path=this.getServletContext().getRealPath("/");
        //kind 为数据库表名
        String kind=request.getParameter("kind");
        //kind1 为模块名
        String kind1=kind.split("_")[0];
        //kind2　为子文件名
        String kind2=kind.split("_")[1];
        switch (kind1){
            case "fit":
                switch (kind2){
                    case "article":
                        list=newsAction.searchNews(kind);
                        break;
                    case "app":
                        list=newsAction.searchNews(kind);
                        break;
                    case "gym":
                        list=newsAction.searchNews(kind);
                        break;
                }
                break;
            case "outdoor":
                switch (kind2){
                    case "activity":
                        list=newsAction.searchNews(kind);
                        break;
                    case "publish":
                        list=newsAction.searchNews(kind);
                        break;
                }
                break;
            case "community":
                switch (kind2){
                    case "committee":
                        list=newsAction.searchNews(kind);
                        break;
                    case "activity":
                        list=newsAction.searchNews(kind);
                        break;
                }
                break;
            case "resource":
                switch (kind2){
                    case "video":
                        list=newsAction.searchNews(kind);
                        break;
                    case "study":
                        list=newsAction.searchNews(kind);
                        break;
                    case "software":
                        list=newsAction.searchNews(kind);
                        break;
                }
                break;
            case "competition":
                switch (kind2){
                    case "team":
                        list=newsAction.searchNews(kind);
                        break;
                    case "item":
                        list=newsAction.searchNews(kind);
                        break;
                    case "corporation":
                        list=newsAction.searchNews(kind);
                        break;
                }
                break;
        }


        request.setAttribute("list",list);
        //String src="Module_"+kind+"/"+kind+".jsp";
        request.getRequestDispatcher("Module_"+kind1+"/"+kind2+".jsp").forward(request,response);
    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        this.doPost(request,response);
    }
}
