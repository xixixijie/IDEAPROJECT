package socket;

import java.io.IOException;
import java.net.ServerSocket;



public class BJServer {

    public static void main(String[] args) throws IOException {
        //申请端口
        ServerSocket server = null;
        try {
            server = new ServerSocket(2222);
        } catch (IOException e) {
            System.err.println("2222端口申请失败");
        }
        //连接数据库
        boolean flag = true;
        while (flag) {
            System.out.println("等待客户端连接");
            new UserThread(server.accept()).start();
        }

        //收尾
        server.close();
    }
}
