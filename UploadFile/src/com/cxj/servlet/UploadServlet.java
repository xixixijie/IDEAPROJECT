package com.cxj.servlet;

import javafx.application.Application;
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
 * Created by jay chen on 2016/8/24.
 */
@WebServlet(name = "UploadServlet",urlPatterns = "/UploadServlet")
@MultipartConfig(location = "e:/tmp")
public class UploadServlet extends HttpServlet {
    private static final long serialVersionUID= 1L;
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        response.setContentType("text/html;charset=UTF-8");
        PrintWriter out =response.getWriter();
        String path=this.getServletContext().getRealPath("\\");//获取服务器地址
        Part p=request.getPart("file1");

        if(p.getContentType().contains("image")){
           // System.out.println(path);

            ApplicationPart ap=(ApplicationPart)p;
            String fname1=ap.getSubmittedFileName(); //获取上传文件名
            int path_idx=fname1.lastIndexOf(" ")+1;        //对上传文件名进行截取
            String fname2=fname1.substring(path_idx,fname1.length());
            System.out.println(path+"upload\\"+fname2);
            p.write(path+"upload\\"+fname2);
            out.print("上传文件成功");
        }else {
            out.write("请选择图片文件！！");
        }

    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

    }
}
