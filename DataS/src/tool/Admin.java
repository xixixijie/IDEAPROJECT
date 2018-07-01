package tool;

import DBconnect.AdminDao;
import DBconnect.RecordDao;
import javafx.scene.input.DataFormat;

import java.text.SimpleDateFormat;
import java.util.List;
import java.util.Scanner;

/**
 * Created by xixi on 2017/8/30.
 */
public class Admin {
    String id;
    String pswd;
    boolean state;
    ALGraph G;
    public Admin(ALGraph G){
        this.G=G;
        this.state=false;
    }

    public String Start(){
        String info="";
        while (true) {
            String id = "";
            String pswd = "";
            System.out.println("请输入帐号（输入exit返回上级菜单）");
            id = new Scanner(java.lang.System.in).nextLine();
            if(id.equals("exit")||id.equals("EXIT")){
                break;
            }
            System.out.println("请输入密码");
            pswd = new Scanner(java.lang.System.in).nextLine();
            if(AdminDao.getAdmin(id,pswd)){
                System.out.println("登录成功");
                state=true;
                break;
            }else{
                System.out.println("密码错误");
            }
        }
        if (state){
            while(true) {
                show();
                int choice = new Scanner(System.in).nextInt();
                if(choice==7){
                    break;
                }
                switch (choice) {
                    case 1:
                        insertArcNode();
                        break;
                    case 2:
                        deleteArcNode();
                        break;
                    case 3:
                        insertVNode();
                        break;
                    case 4:
                        deleteVNode();
                        break;
                    case 5:
                        showRecord();
                        break;
                    case 6:
                        System.out.println("请输入公告");
                        info=new Scanner(System.in).nextLine();
                        break;
                }
            }
        }
        return info;
    }



    public void show(){
        System.out.println("==============================");

        System.out.println("         *管理员菜单:");
        System.out.println("==============================");

        System.out.println("1.景点的插入");
        System.out.println("2.景点的删除");
        System.out.println("3.路的插入");
        System.out.println("4.路的删除");
        System.out.println("5.查看停车记录");
        System.out.println("6.发布公告");
        System.out.println("7.退出登录");
        System.out.println("请选择功能:");

    }

    public void insertArcNode(){
        //System.out.println(G.getNodesSize());
        System.out.println("请输入景点的名称,欢迎程度，介绍，有无休息区，有无厕所(1有0无) 空格隔开或输入E（e）退出");
        //以及其他信息
        String LineTxt=new Scanner(System.in).nextLine();
        if(LineTxt.equals("e")||LineTxt.equals("E")){
            return;
        }
        String[] strs=LineTxt.split(" ");
        G.getNodes().add(new ArcNode(strs[0],Integer.valueOf(strs[1]),strs[2],strs[3].equals("1")?true:false,strs[4].equals("1")?true:false));
        System.out.println("加入成功");
        G.CreatGraph();
        //System.out.println(G.getNodesSize());
    }

    public void deleteArcNode(){
        //System.out.println(G.getNodesSize());
        List<ArcNode> list=G.getNodes();
        int oldSize=list.size();
        int newSize=list.size();
        String name="";
        while(oldSize==newSize) {
            System.out.println("请输入景点名称,或输入E（e）退出");
            name = new Scanner(System.in).next();
            if(name.equals("e")||name.equals("E")){
                break;
            }
            list.remove(G.getNodeByname(name));
            newSize=list.size();
            if(newSize==oldSize){
                System.out.println("不存在该景点");
            }
        }
        System.out.println("删除成功");

        //删除相关边
        for(int i=0;i<G.getVNodesSize();i++){
            if(G.getvNodes().get(i).name1.equals(name)||G.getvNodes().get(i).name2.equals(name)){
                G.getvNodes().remove(i);
                i--;
            }
        }
        G.CreatGraph();
        //System.out.println(G.getNodesSize());

    }


    public void insertVNode(){
        //System.out.println(G.getVNodesSize());
        List<ArcNode> list=G.getNodes();
        System.out.println("请输入起点,或输入E（e）退出");
        String name1=new Scanner(System.in).next();

        if(name1.equals("e")||name1.equals("E")){
            return;
        }

        System.out.println("请输入终点");
        String name2=new Scanner(System.in).next();
        System.out.println("请输入距离");
        int weight=new Scanner(System.in).nextInt();
        int num=0;
        for(ArcNode an:list){
            if(an.name.equals(name1)||an.name.equals(name2)){
                num++;
            }
        }
        if(num!=2){
            System.out.println("起点或终点不存在，加入失败");
            return;
        }

        System.out.println("加入成功");
        G.getvNodes().add(new VNode(name1,name2,weight));
        G.CreatGraph();
        //System.out.println(G.getVNodesSize());

    }

    public void deleteVNode(){
        //System.out.println(G.getVNodesSize());
        //如果起点终点不存在
        System.out.println("请输入起点，或输入E（e）退出");
        String name1=new Scanner(System.in).next();

        if(name1.equals("e")||name1.equals("E")){
            return;
        }

        System.out.println("请输入终点");
        String name2=new Scanner(System.in).next();


        List<VNode> list=G.getvNodes();
        int oldSize=list.size();
        int newSize=0;
        for(int i=0;i<list.size();i++){
            if((list.get(i).name2.equals(name2)&&list.get(i).name1.equals(name1))||
                    (list.get(i).name2.equals(name1)&&list.get(i).name1.equals(name2))){
                list.remove(i);
                i--;
            }
        }
        newSize=list.size();
        if(newSize==oldSize){
            System.out.println("起点或终点输入错误，删除失败");
            return;
        }
        System.out.println("删除成功");
        G.CreatGraph();
       // System.out.println(G.getVNodesSize());

    }

    public void showRecord(){
        List<Record> list= RecordDao.getRecords();
        SimpleDateFormat sdf=new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
        System.out.println("停车记录：");
        for(Record r:list){
            System.out.println("车牌:"+r.carID+" 进入时间："+sdf.format(r.inTime)+ " 出去时间："+sdf.format(r.outTime)+" 停车费"+r.money+"元");
        }

    }
}
