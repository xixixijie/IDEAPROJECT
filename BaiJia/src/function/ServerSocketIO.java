package function;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.net.Socket;

/**
 * Created by jay chen on 2016/5/9.
 */
public class ServerSocketIO {
    static public Socket bjSocket=null;
    static public BufferedReader in=null;
    static public PrintWriter out=null;

    public static void openSocket(){
        try {
            bjSocket=new Socket("localhost",2222);
            in=new BufferedReader(new InputStreamReader(bjSocket.getInputStream()));
            out=new PrintWriter(bjSocket.getOutputStream(),true);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public  void closeSocket() throws IOException {
        this.out.close();
        this.in.close();
        this.bjSocket.close();
    }
}
