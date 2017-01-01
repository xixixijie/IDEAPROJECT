package struts;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Created by xixi on 01/01/2017.
 */
public interface Action {
    public String execute(HttpServletRequest req, HttpServletResponse resp)
            throws Exception;
}
