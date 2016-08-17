import com.sun.xml.internal.ws.policy.privateutil.PolicyUtils;

import javax.servlet.ServletException;
import java.io.IOException;
import java.io.PrintWriter;
import javax.servlet.http.*;

/**
 * Created by jay chen on 2016/7/3.
 */
public class TestServlet extends HttpServlet {
    public void init() throws ServletException{}
    public void doPost(HttpServletRequest request,HttpServletResponse response) throws javax.servlet
            .ServletException, IOException {
        response.setContentType("text/html");
        response.setCharacterEncoding("GBK");
        PrintWriter out=response.getWriter();
        out.println("<html>");
        out.println("<head><title>登陆成功</title></head>");
        out.println("<body>");
        out.print("  登陆成功  ");
        out.println(this.getClass());
        out.println(" </body>");
        out.println("</html>");
        out.flush();
        out.close();

    }

    public void doGet(HttpServletRequest request, HttpServletResponse response) throws javax.servlet
            .ServletException, IOException {


    }

    public void doPut(HttpServletRequest request,HttpServletResponse response)throws
            ServletException,IOException{

    }

    public void doDelete(HttpServletRequest request,HttpServletResponse response)throws
            ServletException,IOException{

    }

    public void destroy(){
        super.destroy();
    }

}
