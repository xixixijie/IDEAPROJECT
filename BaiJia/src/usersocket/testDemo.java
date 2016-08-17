package usersocket; /**
 * Created by jay chen on 2016/5/9.
 */
import function.ServerSocketIO;
import function.UserLogin;

public class testDemo {
    public static void main(String[] args) {
        //打开客户端
        ServerSocketIO.openSocket();

        UserLogin.checkUserid();
        UserLogin.checkPassword();



        //ServerSocketIO.out.println(123);


    }
}
