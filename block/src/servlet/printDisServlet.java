package servlet;

import entity.Distribution;
import service.disService;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.List;

/**
 * Created by xixi on 2018/6/15.
 */
public class printDisServlet extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        request.setCharacterEncoding("utf-8");


        String[] tids=request.getParameterValues("chk");
        int[] tid=new int[tids.length];
        for(int i=0;i<tids.length;i++){
            tid[i]=Integer.parseInt(tids[i]);
        }

        List<Distribution> list= disService.getService().printDis(tid);

    }
    void generateFile(int[] tid){

    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        doPost(request,response);
    }
}
