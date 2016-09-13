package servlet;

import DAO.ProDao;
import bean.Product;
import org.apache.catalina.core.ApplicationPart;

import javax.servlet.ServletException;
import javax.servlet.annotation.MultipartConfig;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.Part;
import java.io.IOException;
import java.io.PrintWriter;

/**
 * Created by jay chen on 2016/9/2.
 */
@WebServlet(name = "AddProServlet", urlPatterns = "/AddProServlet")
@MultipartConfig(location = "e:/tmp")//这个必不可少
public class AddProServlet extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        request.setCharacterEncoding("UTF-8");
        response.setCharacterEncoding("UTF-8");
        //对上传文件的处理
        PrintWriter out = response.getWriter();
        String path = this.getServletContext().getRealPath("\\");//获取服务器地址
        Part p = request.getPart("proimage");
        String proimage = "";


        ApplicationPart ap = (ApplicationPart) p;
        String fname1 = ap.getSubmittedFileName(); //获取上传文件名
        int path_idx = fname1.lastIndexOf(" ") + 1;        //对上传文件名进行截取
        String fname2 = fname1.substring(path_idx, fname1.length());
        proimage = path + "upload\\" + fname2;
        System.out.println(path + "upload\\" + fname2);
        p.write(path + "upload\\" + fname2);//写入地址

        Product product = new Product();
        product.setName(request.getParameter("proname"));
        product.setPrice(request.getParameter("proprice"));
        product.setAddress(request.getParameter("proaddress"));
        product.setImage(proimage);

        if (ProDao.addToDB(product)) {
            //加入成功
            System.out.println("成功");
            response.sendRedirect("DivideServlet");

        } else {
            //加入失败
            System.out.println("失败");
        }


    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        this.doPost(request, response);
    }
}
