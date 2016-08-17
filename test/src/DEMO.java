import javax.security.sasl.SaslServer;
import java.io.IOException;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;

/**
 * Created by jay chen on 2016/4/29.
 */
public class DEMO {
    public void y() throws IOException {
        throw new IOException("Exception from y");
    }

    public static void main(String[] args) throws SQLException {
        int i=2;

       System.out.print(5/i);

    }
}
