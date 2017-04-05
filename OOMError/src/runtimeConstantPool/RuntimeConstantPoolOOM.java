package runtimeConstantPool;

import java.util.ArrayList;
import java.util.List;

/**
 * -XX:PermSize=10M -XX:MaxPermSize=10M
 * 设置常量池容量
 */
public class RuntimeConstantPoolOOM {
    public static void main(String[] args) {
        List<String> list=new ArrayList<String>();
        int i=0;
        while(true){
            list.add(String.valueOf(i++).intern());
        }
    }
}
