import java.util.PriorityQueue;

/**
 * Created by xixi on 2017/12/4.
 */
public class Dijkstra {
    //设置最大值
    int MAX=999;
    //顶点总个数
    int total;
    //邻接矩阵表示距离
    int[][] matrix;
    //结点相关信息
    String[] nodes;
    //存储最后结果
    int[] dis;
    //标记结点
    int[] mark;
    Dijkstra(int total,String[] nodes)
    {
        this.total = total;
        this.nodes = nodes;
        this.matrix = new int[total][total];
        this.dis = new int[total];
        this.mark = new int[total];
    }
    private void initMatrix() {
        // 初始化矩阵为最大值(各节点都不连通)
        for (int i = 0; i < this.total; i++) {
            for (int j = 0; j < this.total; j++) {
                if (i == j) {
                    this.matrix[i][j] = 0;
                } else {
                    this.matrix[i][j] = MAX;
                }
            }
        }

        // 手动设置有向路径
        // A->B, A->E, A->D
        this.matrix[0][1] = 2;
        this.matrix[0][4] = 3;
        this.matrix[0][3] = 1;
        // B->C
        this.matrix[1][2] = 2;
        // C->F
        this.matrix[2][5] = 1;
        // D->E, D->G
        this.matrix[3][4] = 5;
        this.matrix[3][6] = 2;
        // E->F, E->H
        this.matrix[4][5] = 6;
        this.matrix[4][7] = 1;
        // F->I
        this.matrix[5][8] = 3;
        // G->H
        this.matrix[6][7] = 4;
        // H->F, H->I
        this.matrix[7][5] = 1;
        this.matrix[7][8] = 2;
    }

    private void printMatrix() {
        System.out.println("--------- weighted directed matrix ---------");
        System.out.println("---0---1---2---3---4---5---6---7---8---");
        System.out.println("---A---B---C---D---E---F---G---H---I---");
        for (int i = 0; i < this.total; i++) {
            System.out.print("-" + this.nodes[i] + "|");
            for (int j = 0; j < this.total; j++) {
                System.out.print(String.format("%03d", this.matrix[i][j]) + "-");
            }
            System.out.print("\n");
        }
        System.out.println("--------- weighted directed matrix ---------");
    }
    //普通方法
    private void dijkstra1(int s)
    {
        for(int i=0;i<total;i++ )
            mark[i]=0;
        mark[s]=1;
        for(int i=0;i<total;i++)
        {
            dis[i]=matrix[s][i];
        }
        /**每次找到一个最小值，标记，然后修改其相邻的值*/
        for(int i=0;i<total;i++)
        {
            int min=MAX;
            int index=-1;
            for(int j=0;j<total;j++)
            {
                if(mark[j]==0&&dis[j]<min)
                {
                    index=j;
                    min=matrix[s][j];
                }
            }
            if(index==-1) return;
            mark[index]=1;
            for(int k=0;k<total;k++)
            {
                if(mark[k]==0&&dis[index]+matrix[index][k]<dis[k])
                {
                    dis[k]=dis[index]+matrix[index][k];
                }
            }
            printDis(0,this.nodes[i],"第"+i+"次");
        }
    }
    //使用小顶堆，帮助找到最小值
    private void dijkstra2()
    {
        class Node implements Comparable<Node>
        {
            int id;
            int weight;
            Node(int i,int j)
            {
                this.id=i;
                this.weight=j;
            }
            @Override
            public int compareTo(Node node) {
                if(this.weight==node.weight)
                    return 0;
                else if(this.weight<node.weight)
                    return -1;
                else
                    return 1;
            }
        }
        //小顶堆
        PriorityQueue<Node> queue=new PriorityQueue<Node>();
        queue.offer(new Node(0,0));
        for(int i=0;i<total;i++ )
            mark[i]=0;
        for(int i=0;i<total;i++)
        {
            dis[i]=matrix[0][i];
            if(dis[i]!=MAX)
                queue.offer(new Node(i,dis[i]));
        }
        int count=0;
        while(queue!=null)
        {
            count++;
            Node node=queue.poll();
            if(node==null) return;
            int index=node.id;
            mark[index]=1;
            for(int i=0;i<total;i++)
            {
                if(mark[i]==0&&dis[index]+matrix[index][i]<dis[i])
                {
                    dis[i]=dis[index]+matrix[index][i];
                    queue.add(new Node(i,dis[i]));
                }

            }
            printDis(0,"0","第"+count+"次");
        }
    }
    private void printDis(int i, String node, String pre) {
          /*System.out.print("\n" + pre + "," + node + "," + i + "--->");
          for (int t = 0; t < this.dis.length; t++) {
              System.out.print(t + ",");
          }*/
        System.out.print("\n" + pre + i + "--->");
        for (int t : this.dis) {
            System.out.print(t + ",");
        }
        System.out.print("\n");
    }
    public static void main(String[] args) {
        String[] nodes = new String[] { "A", "B", "C", "D", "E", "F", "G", "H", "I" };
        Dijkstra dij = new Dijkstra(nodes.length, nodes);
        dij.initMatrix();
        dij.printMatrix();

        System.out.println();
        System.out.println("------ Dijkstra算法-(迪杰斯特拉)算法之迭代开始 ------");
        dij.dijkstra1(0);
        dij.printDis(0, "迭代结果", "最终值");
        System.out.print("\n");
        System.out.println("------ Dijkstra算法-(迪杰斯特拉)算法之迭代结束 ------");

        System.out.println();
        System.out.println("------ Dijkstra算法-(迪杰斯特拉)算法之优先队列开始 ------");
        dij.dijkstra2();
        dij.printDis(0, "优先级队列", "最终值");
        System.out.print("\n");
        System.out.println("------ Dijkstra算法-(迪杰斯特拉)算法之优先队列结束 ------");
    }
}

