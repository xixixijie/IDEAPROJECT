package Complex.Facade;

import Complex.Factory.Creator;
import Complex.Strategy.CommonStrategy;
import Complex.Strategy.Strategy;
import Complex.Strategy.VIPStrategy;
import Complex.User;
import Complex.wager.Cash;
import Complex.wager.Wager;

import java.awt.*;
import java.util.ArrayList;
import java.util.Scanner;

/**
 * Created by xixi on 2017/10/19.
 */
public class GamblingHouse {
    static Creator creator=new Creator();
    static Strategy strategy;
    User user;

    public GamblingHouse(){
       user=new User();
    }



    public void Start(){
        System.out.println("请选择 功能");
        menu();
        Scanner scanner=new Scanner(System.in);
        int choice=scanner.nextInt();
        while(true) {
            switch (choice) {
                case 1:
                    Exchange();
                    break;
                case 2:
                    System.out.println("您的总资产为" + user.Sum());
                    break;
                case 3:
                    user.show();
                    break;
            }
            if(choice==4){
                System.out.println("已退出");
                break;
            }
            menu();
            choice=scanner.nextInt();
            System.out.println(choice);

        }
    }



    public  void Exchange(){
        System.out.println("输入想要换的筹码");
        double amount=new Scanner(System.in).nextDouble();
        user.pay(amount);
        if(user.isVIP()){
            strategy=new VIPStrategy();
        }else{
            strategy=new CommonStrategy();
        }
        amount=strategy.Algorithm(amount);
        user.addWager("Jetton",amount);

    }

    public void menu(){
        System.out.println("1.换筹码");
        System.out.println("2.计算赌注总价值");
        System.out.println("3.展示自身财富");
        System.out.println("4.退出");
    }
}
