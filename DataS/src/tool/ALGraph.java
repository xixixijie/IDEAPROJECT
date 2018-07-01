package tool;

import javafx.scene.shape.Arc;

import javax.xml.transform.Templates;
import java.io.*;
import java.util.*;

/**
 * Created by xixi on 2017/8/29.
 */
public class ALGraph {
    private int MAXNUM = 32767;
    private int nodeNum = 12;
    private List<ArcNode> nodes;
    private Map<String, List<VNode>> neighborList;
    private List<VNode> vNodes;

    public ALGraph() {
    }

    //从文件中读取信息
    public ALGraph(String s1, String s2) {
        nodes = new ArrayList<>();
        neighborList = new HashMap<>();
        vNodes = new ArrayList<>();

        String encoding = "UTF-8";
        try {

            File file = new File(s1);
            if (file.isFile() && file.exists()) { //判断文件是否存在
                InputStreamReader read = new InputStreamReader(
                        new FileInputStream(file), encoding);//考虑到编码格式
                BufferedReader bufferedReader = new BufferedReader(read);
                String lineTxt = null;

                while ((lineTxt = bufferedReader.readLine()) != null) {
                    if (lineTxt.equals("")) {
                        break;
                    }
                    //分割每一行 储存景点信息
                    //System.out.println(lineTxt);
                    String[] strs = lineTxt.split(" ");

                    nodes.add(new ArcNode(strs[0], Integer.valueOf(strs[1]), strs[2], strs[3].equals("1") ? true : false, strs[4].equals("1") ? true : false));
                    //System.out.println(strs[0]+" "+Integer.valueOf(strs[1])+" "+strs[2]+" "+(strs[3].equals("1")?true:false)+" "+(strs[4].equals("1")?true:false));
                }
                read.close();
            } else {
                System.out.println("找不到指定的文件1");
            }
        } catch (Exception e) {
            System.out.println("读取文件1内容出错");
            e.printStackTrace();
        }

        try {
            File file = new File(s2);
            if (file.isFile() && file.exists()) { //判断文件是否存在
                InputStreamReader read = new InputStreamReader(
                        new FileInputStream(file), encoding);//考虑到编码格式
                BufferedReader bufferedReader = new BufferedReader(read);
                String lineTxt = null;
                while ((lineTxt = bufferedReader.readLine()) != null) {
                    if (lineTxt.equals("")) {
                        break;
                    }
                    //分割每一行，构建邻接表
                    //System.out.println(lineTxt);
                    String[] strs = lineTxt.split("--");
//                    System.out.println(strs.length);
//                    System.out.println(strs[0]+" "+strs[1]+" "+strs[2]);
                    vNodes.add(new VNode(strs[0], strs[1], Integer.valueOf(strs[2])));
                }
                read.close();
            } else {
                System.out.println("找不到指定的文件2");
            }
        } catch (Exception e) {
            System.out.println("读取文件2内容出错");
            e.printStackTrace();
        }
        CreatGraph();
    }

    //创建图的邻接表存储
    void CreatGraph() {
        //System.out.println();
        for (ArcNode an : nodes) {
            List<VNode> list = new ArrayList<>();
            for (VNode vn : vNodes) {
                if (vn.name1.equals(an.name) || vn.name2.equals(an.name)) {
                    // System.out.println(vn.name1+" "+vn.name2+" "+an.name);
                    list.add(vn);
                }
            }
            //System.out.println(list.size());
            neighborList.put(an.name, list);
        }

    }

    //输出邻接表
    public void OutputGraph() {

        System.out.println("景点分布图：");
        Iterator iter = neighborList.entrySet().iterator();
        while (iter.hasNext()) {
            Map.Entry entry = (Map.Entry) iter.next();
            String name = (String) entry.getKey();
            List<VNode> list = neighborList.get(name);
            System.out.print(name);
            for (VNode vn : list) {
                //System.out.println(vn.name1+" "+vn.name2);

                System.out.print("→" + (vn.name1.equals(name) ? vn.name2 : vn.name1));

            }
            System.out.println();
        }
        System.out.println();
    }

    //输出邻接矩阵
    public void OutputMatrix() {
        System.out.print("        ");
        for (int i = 0; i < nodes.size(); i++) {
            System.out.print(nodes.get(i).name + "   ");
            if (nodes.get(i).name.length() < 3) {
                System.out.print("  ");
            }
        }
        System.out.println();
        for (int i = 0; i < nodes.size(); i++) {

            System.out.print(nodes.get(i).name + "   ");
            if (nodes.get(i).name.length() < 3) {
                System.out.print("  ");
            }
            for (int j = 0; j < nodes.size(); j++) {
                if (i == j) {
                    System.out.print("0       ");
                } else {
                    VNode v = null;
                    for (int k = 0; k < vNodes.size(); k++) {
                        if (vNodes.get(k) == null) {
                            break;
                        } else if ((vNodes.get(k).name1.equals(nodes.get(i).name) && vNodes.get(k).name2.equals(nodes.get(j).name)) || (vNodes.get(k).name1.equals(nodes.get(j).name) && vNodes.get(k).name2.equals(nodes.get(i).name))) {
                            v = vNodes.get(k);
                            break;
                        }
                    }
                    if (v == null) {
                        System.out.print(MAXNUM + "   ");
                    } else {
                        System.out.print(v.weight + "      ");
                        if (v.weight < 10) {
                            System.out.print(" ");
                        }
                    }
                }


            }
            System.out.println();
        }
    }

    //景点查找
    public void findArcNode(String keyWord) {
        System.out.println("符合条件的景点有:");
        for (ArcNode an : nodes) {
            if (an.name.contains(keyWord) || an.introduction.contains(keyWord)) {
                System.out.print(an.name + " ");
            }
        }
        System.out.println();
    }

    //景点排序
    public void sort() {
        //按欢迎度排序从大到小 冒泡

        for (int i = 0; i < nodes.size(); i++) {
            for (int j = i + 1; j < nodes.size(); j++) {
                if (nodes.get(i).popularity < nodes.get(j).popularity) {
                    ArcNode temp = nodes.get(i);
                    nodes.set(i, nodes.get(j));
                    nodes.set(j, temp);
                }
            }
        }

        for (ArcNode an : nodes) {
            System.out.println(an.name + " " + "推荐程度：" + an.popularity);
        }

    }

    //两点之间最短线路
    public void findShortestPath(String from, String to) {
        //初始化未访问顶点集合
        Queue<ArcNode> unVisited = new PriorityQueue<ArcNode>();

        //设置from的权重为0；
        for (ArcNode an : nodes) {
            if (an.name.equals(from)) {
                an.weight = 0;
            }
            //System.out.println(an.weight+" "+an.name);
            unVisited.offer(an);
        }

        while (!unVisited.isEmpty()) {
            ArcNode vertex = unVisited.poll();
            //顶点已经计算出最短路径，设置为"已访问"
//            System.out.println(vertex.name);
//            System.out.println(vertex.weight);
            vertex.isVisit = true;
            //获取所有"未访问"的邻居
            List<ArcNode> neighbors = getNeighbors(vertex);
            //更新邻居的最短路径
            updatesDistance(vertex, neighbors);

            unVisited.clear();
            for (ArcNode an : nodes) {
                //System.out.println(an.name+ " "+an.weight);
                if(an.isVisit){
                    continue;
                }
                unVisited.offer(an);
            }
        }

        //打印线路
        System.out.println("从" + from + "到" + to + "的最短路径是：");

        String order = "";
        ArcNode tempNode = getNodeByname(to);

        while (!tempNode.name.equals(from)) {
            order = "→" + tempNode.name + order;
            tempNode = getNodeByname(tempNode.from);
        }
        System.out.println(from + order);
        System.out.println("最短距离为：" + getNodeByname(to).weight);


    }

    //更新所有邻居最短路径
    private void updatesDistance(ArcNode vertex, List<ArcNode> neighbors) {
        for (ArcNode neighbor : neighbors) {
            updateDistance(vertex, neighbor);
        }
    }


    // 更新邻居的最短路径
    private void updateDistance(ArcNode vertex, ArcNode neighbor) {
        int distance = getDistance(vertex, neighbor) + vertex.getWeight();
        if (distance < neighbor.getWeight()) {
            //System.out.println(neighbor.name+" "+vertex.name);
            //System.out.println(neighbor.name);
            neighbor.from = vertex.name;
            neighbor.setWeight(distance);
        }
    }

    //获得从一个点到另一个点的距离
    private int getDistance(ArcNode source, ArcNode destination) {
        int weight = MAXNUM;
        //System.out.println(source.name+" "+destination.name);
        for (VNode vn : vNodes) {
            //System.out.println(vn.name1+" "+vn.name2);
            if ((vn.name2.equals(source.name) && vn.name1.equals(destination.name)) || (vn.name1.equals(source.name) && vn.name2.equals(destination.name))) {
                weight = vn.weight;
                break;
            }
        }
        return weight;
    }

    //获取该节点的所有邻居节点
    private List<ArcNode> getNeighbors(ArcNode a) {
        List<ArcNode> neighbors = new ArrayList<ArcNode>();
        //System.out.println(a.name);
        List<VNode> temp = neighborList.get(a.name);
        for (VNode vn : temp) {
            //有路径可达

            String neighborName = vn.name1.equals(a.name) ? vn.name2 : vn.name1;
            for (ArcNode an : nodes) {
                //an是邻居且未访问
                if (an.name.equals(neighborName) && !an.isVisit) {
                    neighbors.add(an);
                    break;
                }
            }

        }
        return neighbors;
    }

    //找导游路线图 哈密顿回路
    //从输入点进入  输出点由算法提供。
//    public void findRouteMap(String name) {
//        List<VNode> eNew = new ArrayList<>();//没走过的边
//        List<ArcNode> vNew = new ArrayList<>();//走过的点
//        List<ArcNode> vOld = new ArrayList<>();//没走过的点
//        ArcNode a0 = getNodeByname(name);
//        for (ArcNode an : nodes) {
//            vOld.add(an);
//        }
//        vOld.remove(a0);
//        vNew.add(a0);
//        PriorityQueue<VNode> pq = new PriorityQueue<>();
//        ArcNode now = a0;//现在所在的位置
//        while (vNew.size() < nodes.size()) {
//            List<VNode> neighbor = neighborList.get(now.name);
//            for (VNode v : neighbor) {
//                pq.add(v);
//            }
//            VNode vNode = pq.poll();
//            ArcNode a1 = new ArcNode();
//            ArcNode a2 = new ArcNode();
//            //
//            while (true) {
//                a1 = getNodeByname(vNode.name1);
//                a2 = getNodeByname(vNode.name2);
//
//                if (vOld.contains(a1) && vNew.contains(a2)) {
//                    break;
//                } else if (vOld.contains(a2) && vNew.contains(a1)) {
//                    break;
//                } else {
//                    vNode = pq.poll();
//                }
//            }
//            //清空优先权队列
//            pq.clear();
//
//            if (a1.name.equals(now.name)) {
//                vNew.add(a2);
//                vOld.remove(a2);
//                eNew.add(vNode);
//                now = a2;
//            } else {
//                vNew.add(a1);
//                vOld.remove(a1);
//                eNew.add(vNode);
//                now = a1;
//            }
//
//        }
//
////        for (ArcNode a : vNew) {
////            System.out.println(a.name);
////        }
////
////        for (VNode v : eNew) {
////            System.out.println(v.name1 + " " + v.name2 + " " + v.weight);
////        }
//
//
//        ArcNode arcNode = getNodeByname(name);
//        System.out.print(name);
//        for (int j = 0; j < eNew.size(); j++) {
//            //System.out.println(eNew.get(j).name1+" "+eNew.get(j).name2);
//            if (eNew.get(j).name1.equals(arcNode.name)) {
//                arcNode = getNodeByname(eNew.get(j).name2);
//                System.out.print("→"+arcNode.name);
//                eNew.remove(eNew.get(j));
//                j--;
//            } else {
//                arcNode = getNodeByname(eNew.get(j).name1);
//                System.out.print("→"+arcNode.name);
//                eNew.remove(eNew.get(j));
//                j--;
//            }
//
//        }
//
//        System.out.println();
//    }

    public void findRouteMap1(String name){
        List<VNode> eNew = new ArrayList<>();//没走过的边
        Stack<VNode> back=new Stack<>();
        List<ArcNode> vNew = new ArrayList<>();//走过的点
        List<ArcNode> vOld = new ArrayList<>();//没走过的点
        ArcNode a0 = getNodeByname(name);
        for (ArcNode an : nodes) {
            vOld.add(an);
        }
        vOld.remove(a0);
        vNew.add(a0);
        PriorityQueue<VNode> pq = new PriorityQueue<>();
        ArcNode now = a0;//现在所在的位置
        while (vNew.size() < nodes.size()) {
            List<VNode> neighbor = neighborList.get(now.name);
            for (VNode v : neighbor) {
                pq.add(v);
            }
            VNode vNode = pq.poll();
            ArcNode a1 = new ArcNode();
            ArcNode a2 = new ArcNode();
            //弹出没访问过的最小边
            while (true) {
                //System.out.println(pq.size());
                a1 = getNodeByname(vNode.name1);
                a2 = getNodeByname(vNode.name2);

                if (vOld.contains(a1) && vNew.contains(a2)) {
                    break;
                } else if (vOld.contains(a2) && vNew.contains(a1)) {
                    break;
                } else {
                    vNode = pq.poll();
                    //找不到下一个未访问的邻接点，退回上一个节点
                    if(vNode==null){
                        VNode vNode1=back.pop();//最后加入的一条边;
                        if(vNode1.name1.equals(now.name)){
                            now=getNodeByname(vNode1.name2);
                            eNew.add(vNode1);

                        }else{
                            now=getNodeByname(vNode1.name1);
                            eNew.add(vNode1);
                        }
                        break;
                    }
                }
            }
            if(vNode==null){
                continue;
            }
            //清空优先权队列
            pq.clear();

            if (a1.name.equals(now.name)) {
                vNew.add(a2);
                vOld.remove(a2);
                eNew.add(vNode);
                back.add(vNode);
                now = a2;
            } else {
                vNew.add(a1);
                vOld.remove(a1);
                eNew.add(vNode);
                back.add(vNode);
                now = a1;
            }

        }

//        for (ArcNode a : vNew) {
//            System.out.println(a.name);
//        }
//
//        for (VNode v : eNew) {
//            System.out.println(v.name1 + " " + v.name2 + " " + v.weight);
//        }

//        for(VNode v:eNew){
//            System.out.println(v.name1+" "+v.name2);
//        }
        System.out.println("推荐导游路线:");
        ArcNode arcNode = getNodeByname(name);
        System.out.print(name);
        for (int j = 0; j < eNew.size(); j++) {
            //System.out.println(eNew.get(j).name1+" "+eNew.get(j).name2);
            if (eNew.get(j).name1.equals(arcNode.name)) {
                arcNode = getNodeByname(eNew.get(j).name2);
                System.out.print("→"+arcNode.name);
                eNew.remove(eNew.get(j));
                j--;
            } else {
                arcNode = getNodeByname(eNew.get(j).name1);
                System.out.print("→"+arcNode.name);
                eNew.remove(eNew.get(j));
                j--;
            }

        }

        System.out.println();

    }

    public List<ArcNode> getNodes() {
        return nodes;
    }

    public List<VNode> getvNodes() {
        return vNodes;
    }

    public int getNodesSize() {
        return nodes.size();
    }

    public int getVNodesSize() {
        return vNodes.size();
    }

    public ArcNode getNodeByname(String name) {
        for (ArcNode an : nodes) {
            if (an.name.equals(name)) {
                return an;
            }
        }
        return null;
    }

    public void End() {
        String path1 = "/Users/xixi/IdeaProjects/DataS/src/file1";
        String path2 = "/Users/xixi/IdeaProjects/DataS/src/file2";
        //String testPath="/Users/xixi/IdeaProjects/DataS/src/testFile";
        File file1 = new File(path1);
        File file2 = new File(path2);
        //File testFile=new File(testPath);

        //写入景点信息 未完全
        try {
            if (!file1.exists()) {
                file1.createNewFile();
            }

            FileOutputStream fos = new FileOutputStream(file1, false);//追加用 true 覆盖用false；
            StringBuffer sb = new StringBuffer();

            for (ArcNode arcNode : nodes) {
                sb.append(arcNode.name + " " + arcNode.popularity + " " + arcNode.introduction + " ");
                sb.append((arcNode.isRest ? "1" : "0") + " " + (arcNode.isWC ? "1" : "0") + "\n");
            }

            fos.write(sb.toString().getBytes("UTF-8"));
            fos.close();
        } catch (IOException e) {
            e.printStackTrace();
        }

        // 写入边信息
        try {
            if (!file2.exists()) {
                file2.createNewFile();
            }
            FileOutputStream fos = new FileOutputStream(file2, false);//追加用 true 覆盖用false；
            StringBuffer sb = new StringBuffer();

            for (VNode vNode : vNodes) {
                sb.append(vNode.name1 + "--" + vNode.name2 + "--" + vNode.weight + "\n");
            }

            fos.write(sb.toString().getBytes("UTF-8"));
            fos.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }


}
