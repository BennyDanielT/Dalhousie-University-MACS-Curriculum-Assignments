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



//    Properties dbConnectionProperties = new Properties();
//    //Path to the Properties File
//    String propertiesFileName = "DatabaseConfig.properties";
//    FileReader propertyFileReader = new FileReader(propertiesFileName);
////Load the contents of the "Properties" File
//            dbConnectionProperties.load(propertyFileReader);
//                    String driver = dbConnectionProperties.getProperty("driver");
//                    String url = dbConnectionProperties.getProperty("url");
//                    String username = dbConnectionProperties.getProperty("username");
//                    String password = dbConnectionProperties.getProperty("password");



      //  try {
//            Class.forName("com.mysql.jdbc.Driver");
//            con = DriverManager.getConnection("jdbc:mysql://db.cs.dal.ca:3306", "benny", "B00899629");
//            System.out.println("Connection established with " + schema + " successfully");
//        }
//        catch (ClassNotFoundException | SQLException e)
//        {
//            e.printStackTrace(); //throw new SqlException("Connection Error");
//        }


//    //*****************************************TEST to be deleted
//    String querytest = "select * from people";//Check if person exists
//    Statement stmeTest = con.createStatement();
//            rs=stmeTest.executeQuery(querytest);
//                    while(rs.next())
//                    {
//                    System.out.println(rs.getInt(1));
//                    }
//                    con.close();
//                    stmt.close();
//                    rs.close();
////*****************************************TEST