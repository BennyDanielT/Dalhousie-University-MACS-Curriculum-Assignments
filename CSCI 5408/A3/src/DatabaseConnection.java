import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.Statement;

public class DatabaseConnection
{

    public Connection connectToDatabase()
{
    DatabaseConfig config = new DatabaseConfig();
    String URL = config.getURL();
    String username = config.getUserName();
    String password = config.getPassword();
    String useSchemaQuery = "use a3";
    String Driver = "com.mysql.cj.jdbc.Driver";
    Connection con = null;

    try {
        Class.forName(Driver);
        con = DriverManager.getConnection(URL, username, password);
        Statement useDatabase = con.createStatement();
        useDatabase.execute(useSchemaQuery);
        useDatabase.close();
    } catch (SQLException | ClassNotFoundException e) {
        e.printStackTrace();
    }
    return con;
}
}