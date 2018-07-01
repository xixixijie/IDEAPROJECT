package tool;

import DBconnect.RecordDao;

import java.sql.*;
import java.util.*;
import java.util.Date;

/**
 * Created by xixi on 2017/9/1.
 */
public class Parking {
    Queue<Car> waiting;
    PStack parking;
    PStack temp;
    List<Record> recordList;
    int payForHour;
    long nh=1000*60*60;

    public Parking(){
        recordList=new ArrayList<>();
        waiting=new LinkedList<Car>();
        parking=new PStack(1);//调试暂定为1
        temp=new PStack(100);
        payForHour=10;
    }

    public void Start(){
        while (true){
            show();
            int choice=new Scanner(System.in).nextInt();
            if(choice==3){
                break;
            }
            switch (choice){
                case 1:
                    stopCar();
                    break;
                case 2:
                    getCar();
                    break;
            }
        }
    }

    public void show(){
        System.out.println("==============================");

        System.out.println("         *停车场管理程序\n         *请输入数字");
        System.out.println("==============================");

        System.out.println("1.停车");
        System.out.println("2.拿车");
        System.out.println("3.退出程序");
        System.out.println("目前停车场有"+(parking.MAXSIZE-parking.nowSize)+"空位");
    }

    public void stopCar(){
        System.out.println("请输入车牌");
        String carID=new Scanner(System.in).next();
        Car car=new Car(carID);
        if(parking.isFull()){
            System.out.println("停车场已满，车牌："+car.carID+"暂时在外面等候");
            waiting.offer(car);

        }else{
            parking.push(car);
            recordList.add(new Record(car.carID,new Date()));
            System.out.println("车牌："+car.carID+"成功停入停车场");
        }
    }

    public void getCar(){
        System.out.println("请输入车牌");
        String carID=new Scanner(System.in).next();
        boolean out=true;
        while(out){
            if(parking.peek().carID.equals(carID)){
                out=false;
                Car car=parking.pop();
                for(Record r:recordList){
                    if (r.carID.equals(car.carID)){
                        //从列表中删除，加入数据库
                        recordList.remove(r);
                        r.outTime=new Date();
                        long hours=  ((r.outTime.getTime()-r.inTime.getTime())/nh+1);
                        //System.out.println(hours);
                        r.setMoney(hours*payForHour);
                        RecordDao.addRecord(r);
                        break;
                    }
                }
                System.out.println("车牌："+car.carID+"已退出停车场");
            }else{
                //将车弹出停车场，放入临时栈
                Car car= (Car) parking.pop();
                temp.push(car);
            }
        }
        //清空临时栈
        while(!temp.empty()){
            Car car=temp.pop();
            parking.push(car);
        }

        //从队列中调入停车场
        if(!waiting.isEmpty()){
            Car car=waiting.poll();
            System.out.println("车牌："+car.carID+"已进入停车场");
            recordList.add(new Record(car.carID,new Date()));
            parking.push(car);
        }

    }

    public void End(){

    }
}
