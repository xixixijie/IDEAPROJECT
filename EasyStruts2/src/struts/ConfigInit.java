package struts;

import org.dom4j.Document;
import org.dom4j.Element;
import org.dom4j.io.SAXReader;

import java.io.File;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;

/**
 * Created by xixi on 01/01/2017.
 */
public class ConfigInit {

    public static void init(String config) {
        // 创建saxReader对象
        SAXReader reader = new SAXReader();
        File f = new File(config);
        try {
            // 通过read方法读取xml文件， 转换成Document对象
            Document doc = reader.read(f);
            // 得到配置文件的根结点
            Element root = doc.getRootElement();
            Element actionmappings = (Element) root.element("action-mappings");
            // 解析action结点的所有参数
            for (Iterator j = actionmappings.elementIterator("action"); j
                    .hasNext();) {
                Element am = (Element) j.next();
                ActionMapping actionMapping = new ActionMapping();

                // 设置actionMapping的path和type
                actionMapping.setPath(am.attributeValue("path"));
                actionMapping.setType(am.attributeValue("type"));

                Map forward = new HashMap();
                // 解析forward结点的所有参数
                for (Iterator k = am.elementIterator("forward"); k.hasNext();) {
                    Element fo = (Element) k.next();
                    forward.put((String) fo.attributeValue("name"), (String) fo
                            .attributeValue("path"));
                }
                // 设置forward
                //如果是添加ActionMapping的存储如下；
                /*
                 * actionMapping{ path="/servlet/addUser";
                 * type="com.liang.action.AddUserAction"
              *forwardMap{
                 * key="success",value="/add_success.jsp"
                 * key="error",value="/add_error.jsp" }
                 *}
                 */
                actionMapping.setForward(forward);
                /*
                 * 上面Mappings.actions的存储结构相当于将配置信息与映射一一对应
                 * map.put("/servlet/delUser", actionMapping);
                 * map.put("/servlet/addUser", actionMapping);
                 * map.put("/servlet/modifyUser", actionMapping);
                 * map.put("/servlet/queryUser", actionMapping);
                 */
                Mappings.actions.put((String) am.attributeValue("path"),
                        actionMapping);

            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}

