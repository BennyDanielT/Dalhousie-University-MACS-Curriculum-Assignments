import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class DatabaseConnection
{
//    public Connection DatabaseConnection()
//    {
//        DatabaseConfig config = new DatabaseConfig();
//        String URL = config.getURL();
//        String username = config.getUserName();
//        String password = config.getPassword();
//        Connection con = null;
//        {
//            try {
//                con = DriverManager.getConnection(URL, "username", "password");
//            } catch (SQLException e) {
//                e.printStackTrace();
//            }
//        }
//        return con;
//    }

    public Connection connectToDatabase()
{
    DatabaseConfig config = new DatabaseConfig();
    String URL = config.getURL();
    String username = config.getUserName();
    String password = config.getPassword();
    Connection con = null;
    {
        try {
            con = DriverManager.getConnection(URL, username, password);
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
    return con;
}



}