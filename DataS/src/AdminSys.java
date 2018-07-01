
import tool.ALGraph;
import tool.Admin;
import tool.Parking;

import java.util.InputMismatchException;
import java.util.Scanner;

/**
 * Created by xixi on 2017/9/1.
 */
public class AdminSys {
    private String info = "";
    private ALGraph G;
    private Parking P;

    public static void main(String[] args) {
        AdminSys sys = new AdminSys();
        //sys.G.findRouteMap1("狮子山");
        sys.Start();

        sys.End();

//        sys.G.findRouteMap("北门");
    }

    public AdminSys() {
        G = new ALGraph("/Users/xixi/IdeaProjects/DataS/src/file1", "/Users/xixi/IdeaProjects/DataS/src/file2");
        P = new Parking();
    }

    public void Start() {

        while (true) {
            show();
            int choice;
            try {
                 choice = new Scanner(System.in).nextInt();
            }catch (InputMismatchException e){
                System.out.println("请输入数字选择功能");
                 choice = new Scanner(System.in).nextInt();
            }
            if (choice == 8)
                break;
            switch (choice) {
                case 1:
                    Admin admin = new Admin(G);
                    info = admin.Start();
                    break;
                case 2:
                    G.OutputGraph();
                    System.out.println();
                    G.OutputMatrix();
                    break;
                case 3:
                    System.out.println("请输入关键字");
                    String keyWord = new Scanner(System.in).next();
                    G.findArcNode(keyWord);
                    break;
                case 4:
                    G.sort();
                    break;
                case 5:
                    System.out.println("请输入起始点");
                    String begin=new Scanner(System.in).nextLine();
                    G.findRouteMap1(begin);
                    break;
                case 6:
                    System.out.println("请输入起点");
                    String from = new Scanner(System.in).next();
                    System.out.println("请输入终点");
                    String to = new Scanner(System.in).next();
                    G.findShortestPath(from,to);
                    break;
                case 7:
                    P.Start();
                    break;
            }
        }
    }


    //展示基础菜单
    public void show() {
        System.out.println("==============================");
        System.out.println("     欢迎使用景区信息管理系统 ");
        System.out.println("          *请选择功能 ");
        if (info != "") {
            java.lang.System.out.println("    公告：" + info);
        }
        System.out.println("==============================");
        System.out.println("1.管理员登录");
        System.out.println("2.输出景区景点分布图");
        System.out.println("3.景点查找");
        System.out.println("4.景点排序");
        System.out.println("5.输出导游路线图");
        System.out.println("6.两个景点间的最短路径和最短距离");
        System.out.println("7.停车场车辆进出记录信息。");
        System.out.println("8.退出");

    }

    public void End(){
        G.End();
        P.End();
    }


}
