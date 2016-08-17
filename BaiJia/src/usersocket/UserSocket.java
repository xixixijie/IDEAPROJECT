package usersocket;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.net.Socket;

/**
 * Created by jay chen on 2016/5/8.
 */
public class UserSocket {
   /* public static void main(String[] args) throws IOException {
        Socket bjSocket=null;
        BufferedReader in=null;
        PrintWriter out=null;
        try {
            bjSocket=new Socket("localhost",2222);
            in=new BufferedReader(new InputStreamReader(bjSocket.getInputStream()));
            out=new PrintWriter(bjSocket.getOutputStream(),true);
        } catch (IOException e) {
            e.printStackTrace();
        }
        BufferedReader stdln=new BufferedReader(new InputStreamReader(System.in));
        String userinput;
        System.out.println("\n请输入:");
        try {
            while((userinput=stdln.readLine())!=null){

                if(userinput.equals("exit")){
                    out.println(userinput);
                    System.out.println("退出");
                    break;
                }
                out.println(userinput);
                String str=in.readLine();
                System.out.println(str);
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
        out.close();
        in.close();
        bjSocket.close();

    }*/



}
