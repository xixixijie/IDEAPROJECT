package heap;

import java.util.ArrayList;
import java.util.List;

/**
 * VM Args： -Xms20m -Xmx20 -XX:+HeapDumpOnOutOfMemoryError
 * -Xms 设置堆的最大值
 * -Xmx 设置对的最小值
 * 最后一个： 让虚拟机在内存溢出时Dump出当前的内存堆转储快照
 */
public class HeapOOM {
    static class OOMObject {

    }

    public static void main(String[] args) {
        List<OOMObject> list=new ArrayList<>();
        while(true){
            list.add(new OOMObject());
        }
    }
}
