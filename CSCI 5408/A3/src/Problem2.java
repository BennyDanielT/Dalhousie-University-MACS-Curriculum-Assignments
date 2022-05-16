import java.util.ArrayList;
import java.util.List;

public class Problem2
{
    public static void main(String[] args)
    {
        DatabaseConnection con = new DatabaseConnection();
        Locks locks = new Locks();
        //Store Queries in ArrayLists for each transaction
        List<String> transaction_1= new ArrayList<>();
        List<String> transaction_2 = new ArrayList<>();
        String transaction1_Query1 = "Select `TICKETS SOLD` from annualticketsales where YEAR=2011;";
        String transaction1_Query2 = "Update annualticketsales set `TICKETS SOLD` = 0 where YEAR=2011;";
        String transaction1_Query3 = "Commit;";
        transaction_1.add(transaction1_Query1);
        transaction_1.add(transaction1_Query2);
        transaction_1.add(transaction1_Query3);
        String transaction2_Query1 = "Update annualticketsales set `TICKETS SOLD` = 0 where YEAR=2011;";
        String transaction2_Query2 = "Select `TICKETS SOLD` from annualticketsales where YEAR=2011;";
        String transaction2_Query3 = "Commit;";
        transaction_2.add(transaction2_Query1);
        transaction_2.add(transaction2_Query2);
        transaction_2.add(transaction2_Query3);
        //Create Transaction objects
        Transactions T1 = new Transactions("T1",transaction_1);
        Transactions T2 = new Transactions("T2",transaction_2);
        //Create Threads to execute the Transactions
        Threads Thread1 = new Threads(T1);
        Threads Thread2 = new Threads(T2);
        //Set Priorities for the Threads
        Thread1.setPriority(8);
        Thread2.setPriority(5);

        System.out.println("<---------------------------------SEQUENCE WITH LOCKS & THREADS--------------------------------->");
//        Thread1.setPriority(Thread.MAX_PRIORITY);
//        Thread2.setPriority(Thread.MIN_PRIORITY);
        Thread1.start();
        Thread2.start();
        try {

            Thread1.join();
            Thread2.join();
        } catch (InterruptedException e) {
            e.printStackTrace();
        }


    }
}
