import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;

/**
 * Created by jay chen on 2016/7/3.
 */

public class LoginServlet extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        response.setContentType("text/html");
        response.setCharacterEncoding("GBK");
        PrintWriter out=response.getWriter();
        out.println("<html>");
        out.println("<head><title>登陆成功</title></head>");
        out.println("<body>");
        out.print("  注册成功  ");
        out.println(this.getClass());
        out.println(" </body>");
        out.println("</html>");
        out.flush();
        out.close();
    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

    }
}
