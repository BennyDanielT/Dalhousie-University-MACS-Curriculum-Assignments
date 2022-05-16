import java.sql.*;

public class Task4
{
    public static void main(String[] args)
    {
        Connection con = null;
        Connection con_GCP = null;
        Statement stmt = null;
        Statement stmt_GCP = null;
        ResultSet rs = null;
        ResultSet transaction1 = null;
        ResultSet transaction_GCP = null;
        String schema = "a2bn489600";
        String tran1="Insert into olist_order_reviews_dataset values (\"9990009xy1hi4e33jk9875653c2ca4t87\",\"fc046d7776171871436844218f817d7d\",4,\"Perfecto Hombre\",\"este producto es impresionantev\",\"22-06-2018 00:00\",\"26-06-2018 13:51\");\n" +
                "\n" +
                "Delete from olist_products_dataset where product_category_name = \"automotivo\" and product_photos_qty < 2;\n" +
                "\n" +
                "Update olist_order_payments_dataset set payment_value=payment_value*1.15 where payment_type=\"credit_card\";\n" +
                "\n" +
                "Select customer_city,count(distinct customer_zip_code_prefix) Number_of_Zip_Codes, count(distinct customer_id) Number_of_Customers\n" +
                "from olist_customers_dataset group by customer_city;\n" +
                "\n" +
                "Select ordi.order_id,order_item_id,ordi.product_id,ordi.price,ordi.freight_value,\n" +
                "(ordi.price+ordi.freight_value) Total_Price,orders.customer_id,c.customer_city,\n" +
                " py.payment_type,py.payment_value from olist_order_items_dataset ordi\n" +
                "join olist_products_dataset p on ordi.product_id=p.product_id\n" +
                "join olist_orders_dataset orders on ordi.order_id=orders.order_id\n" +
                "join olist_customers_dataset c on orders.customer_id=c.customer_id\n" +
                "join olist_order_payments_dataset py on ordi.order_id=py.order_id\n" +
                " where p.product_category_name=\"perfumaria\" limit 5;\n" +
                " commit;";
        String tran2="Insert into olist_geolocation_dataset values (9999,\"-30.549292\",\"--52.63355948\",\"Curaca\",\"CU\");\n" +
                "\n" +
                "Delete from product_category_name_translation where product_category_name like \"%artes%\";\n" +
                "\n" +
                "Update olist_sellers_dataset set seller_zip_code_prefix=9999 and seller_city=\"Curaca\" and seller_state=\"CU\"\n" +
                " where seller_id in (select seller_id from olist_order_items_dataset where product_id=\"e5f2d52b802189ee658865ca93d83a8f\");\n" +
                "\n" +
                "Select p.product_category_name,ordi.seller_id,count(ordi.product_id) Total_Quantity_Sold, sum(ordi.price) Total_Sales\n" +
                " from olist_order_items_dataset ordi\n" +
                "join olist_products_dataset p on ordi.product_id=p.product_id\n" +
                "where product_category_name!=\" \"\n" +
                "group by 1,2\n" +
                "order by 1,2;\n" +
                "commit;";


        try {
            //Connection Statement for the Local Database
            DatabaseConnection Connection = new DatabaseConnection();
            con = Connection.connectToDatabase();
            con.setAutoCommit(false);


            //Connection Statement for the GCP instance
            Class.forName("com.mysql.jdbc.Driver");
            con_GCP = DriverManager.getConnection("jdbc:mysql://34.134.211.229:3306/", "root", "root-0828");
            con_GCP.setAutoCommit(false);
            System.out.println("Connection established with " + schema + " successfully");

            PreparedStatement prepStatement1;
            stmt = con.createStatement();
            stmt.execute("use " + schema + ";");
            System.out.println("**********Connection established with Local Database successfully**********");
            Date startTime = new Date();
            transaction1=stmt.executeQuery(tran1); //Query to retrieve OrderNumber passed to the function
            Date endTime = new Date();
            float executionTimeLocal = endTime.getTime()-startTime.getTime();


            PreparedStatement prepStatement2;
            stmt_GCP = con.createStatement();
            stmt_GCP.execute("use A2bn489600;");
            startTime = new Date();
            transaction_GCP=stmt_GCP.executeQuery(tran2); //Query to retrieve OrderNumber passed to the functionv
            endTime = new Date();
            float executionTimeGCP = endTime.getTime()-startTime.getTime();
            System.out.println("Total Execution Time: " + (executionTimeLocal+executionTimeGCP));

            transaction1.close();
            transaction_GCP.close();
            stmt.close();
            stmt_GCP.close();
            con.close();
            con_GCP.close();


        } catch (SQLException | ClassNotFoundException throwables) {
            throwables.printStackTrace();
        }

    }
}
