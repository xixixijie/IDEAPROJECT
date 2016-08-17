package socket;



import service.UserLogin;

import java.io.*;
import java.net.Socket;


/**
 * Created by jay chen on 2016/5/8.
 */
public class UserThread extends Thread {
    private Socket user=null;
    private BufferedReader in = null;
    private  PrintWriter out = null;

    //构造方法，初始化socket，in，out
    public UserThread(Socket user) {
        super("UserThread");
        this.user = user;
        try {
            in = new BufferedReader(new InputStreamReader(user.getInputStream()));
            out = new PrintWriter(user.getOutputStream(),true);//往客户端打印信息
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public BufferedReader getIn() {
        return in;
    }

    public PrintWriter getOut() {
        return out;
    }

    @Override
    public void run() {
        new UserLogin(in,out);
    }
}
