package struts;

import test.UserManager;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Created by xixi on 01/01/2017.
 */
public class QueryUserAction implements Action {

    @Override
    public String execute(HttpServletRequest req, HttpServletResponse resp) throws Exception {
        //获取参数
        String username = req.getParameter("username");

        UserManager userManager = new UserManager();
        //调用业务逻辑
        userManager.query(username);
        //返回跳转页面
        return "/query_success.jsp";
    }
}
