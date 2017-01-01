package servlet;

import struts.*;


import javax.servlet.ServletException;
import java.io.IOException;
import java.util.List;

/**
 * Created by xixi on 01/01/2017.
 */
public class TestServlet extends javax.servlet.http.HttpServlet {
    protected static String config = "/WEB-INF/struts-config.xml";

    public void init() throws ServletException {
        //需要读取的文件名
        //获得文件的路径
        //initialize();
        //根据web.xml中映射的目录获得文件在对应服务器中的真实路径
        config = getServletContext().getRealPath("/")+ getInitParameter("config");
        //解析struts-config.xml配置文件
        ConfigInit.init(config);
    }

    //根据web.xml中映射的目录获得文件在对应服务器中的真实路径
//  private void initialize() {
//      try {
//          config = getServletContext().getRealPath("/")
//                  + getInitParameter("config");
//      } catch (Exception e) {
//          e.printStackTrace();
//      }
//  }
    protected void doPost(javax.servlet.http.HttpServletRequest request, javax.servlet.http.HttpServletResponse response) throws javax.servlet.ServletException, IOException {
        //取得访问的URI
        String reqeuestURI = request.getRequestURI();
        //截取URI，获得路径
        String path = reqeuestURI.substring(reqeuestURI.indexOf("/"), reqeuestURI.indexOf("."));

        Mappings mapings = new Mappings();
        // 根据截取的URL请求，到Map中取得本次请求对应的Action类
        ActionMapping actionMapping = (ActionMapping)mapings.actions.get(path);
        //取得本请求对应的Action类的完整路径
        String type = actionMapping.getType(); //com.liang.action.DelUserAction
        //采用反射，动态实例化Action
        try {
            Action action = (Action)Class.forName(type).newInstance();
            // 采用多态的机制，动态调用Action中的execute方法，返回转向路径
            String result = action.execute(request, response);

            //获得真实转向页面
            String forward =(String)actionMapping.getForward().get(result);

            //根据转向路径完成转向
            request.getRequestDispatcher(forward).forward(request, response);
        } catch (InstantiationException e) {
            e.printStackTrace();
        } catch (IllegalAccessException e) {
            e.printStackTrace();
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    protected void doGet(javax.servlet.http.HttpServletRequest request, javax.servlet.http.HttpServletResponse response) throws javax.servlet.ServletException, IOException {
        doPost(request,response);
    }
}
