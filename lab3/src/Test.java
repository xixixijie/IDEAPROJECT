import java.util.ArrayList;
import java.util.List;

/**
 * Created by xixi on 2017/12/4.
 */
public class Test {
    public static void main(String[] args) {
        MyGraph graph=new MyGraph();
        graph.initGraph();
        BFSearch bfs=new BFSearch();
        DFSearch dfs=new DFSearch();

        //广度优先
        bfs.searchTraversing(graph.getGraphNodes().get(0));
        System.out.println("--------------");
        //深度优先
        List<GraphNode> visit=new ArrayList<>();
        dfs.searchTraversing(graph.getGraphNodes().get(0),visit);
    }
}
