public class DatabaseConfig
{
    private static final String URL = "jdbc:mysql://127.0.0.1:3306/" ;

    private static final String username = "root";

    private static final String password = "root";

    public String getURL()
    {
        return URL;
    }

    public String getUserName ()
    {
        return username;
    }

    public String getPassword()
    {
        return password;
    }
}