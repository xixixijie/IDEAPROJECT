package struts;

import java.util.HashMap;
import java.util.Map;

/**
 * Created by xixi on 01/01/2017.
 */
public class ActionMapping {
    //路径信息
    private String path;
    //action实现类信息
    private String type;

    Map forward = new HashMap();


    public Map getForward() {
        return forward;
    }
    public void setForward(Map forward) {
        this.forward = forward;
    }
    public String getType() {
        return type;
    }
    public void setType(String type) {
        this.type = type;
    }
    public String getPath() {
        return path;
    }
    public void setPath(String path) {
        this.path = path;
    }
}
