package struts;

import test.UserManager;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Created by xixi on 01/01/2017.
 */
public class AddUserAction implements Action {
    @Override
    public String execute(HttpServletRequest req, HttpServletResponse resp)
            throws Exception {
        //获取参数
        String username = req.getParameter("username");

        //调用业务逻辑
        UserManager userManager = new UserManager();
        try{
            //添加的业务逻辑
            userManager.add(username);
        }catch(Exception e){
            //返回添加失败的界面
            return "error";//和配置文件的配置一致
        }
        //返回添加成功的界面
        return "success";//和配置文件的配置一致

    }
}

