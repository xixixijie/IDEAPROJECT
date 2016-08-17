package function;

import java.io.*;


/**
 * Created by jay chen on 2016/5/9.
 */
public class UserLogin {
    //检验用户名
    public static void checkUserid(){
        BufferedReader stdin = new BufferedReader(new InputStreamReader(System.in));
        String userid = null;
        String result = null;

        try {
            System.out.println("请输入用户id");
            userid = stdin.readLine();
        } catch (IOException e) {
            e.printStackTrace();
        }
        ServerSocketIO.out.println(userid);
        ServerSocketIO.out.flush();
        try {
            result = ServerSocketIO.in.readLine();
        } catch (IOException e) {
            e.printStackTrace();
        }
        while (!result.equals("true")) {
            try {
                System.out.println("查无此用户，请重新输入用户名");
                userid = stdin.readLine();
                ServerSocketIO.out.println(userid);
                ServerSocketIO.out.flush();
                result= ServerSocketIO.in.readLine();
            } catch (IOException e) {
                e.printStackTrace();
            }
        }

    }

    //检验密码
    public static void checkPassword() {
        BufferedReader stdin = new BufferedReader(new InputStreamReader(System.in));
        String password = null;
        String result = null;

        try {
            System.out.println("请输入密码");
            password = stdin.readLine();
        } catch (IOException e) {
            e.printStackTrace();
        }
        ServerSocketIO.out.println(password);
        ServerSocketIO.out.flush();
        try {
            result = ServerSocketIO.in.readLine();
        } catch (IOException e) {
            e.printStackTrace();
        }


        while (!result.equals("true")) {
            try {
                System.out.println("密码错误,请重新输入密码");
                password = stdin.readLine();
                ServerSocketIO.out.println(password);
                ServerSocketIO.out.flush();
                result = ServerSocketIO.in.readLine();

            } catch (IOException e) {
                e.printStackTrace();
            }
        }


    }
}
