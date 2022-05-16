import java.sql.Connection;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.Map;

public class Orchestration
{
    //Establish a connection with the database
    DatabaseConnection dbManager = new DatabaseConnection();
    Connection con = dbManager.connectToDatabase();
    Transactions transaction;
    public Orchestration(Transactions transaction)
    {
        this.transaction=transaction;
        try {
            con.setAutoCommit(false);
        } catch (SQLException e) {
            e.printStackTrace();
        }
        for(String query:transaction.query)
        {
            acquire_locks(query);
            transaction(query);
            release_locks(transaction);
        }
        //release_locks(transaction);
    }
    Locks locks = new Locks();
    String writeLockTransactionId;

    public void acquire_locks(String query)
    {
        //Check if a Write Lock is acquired by a transaction, if yes make the Transaction wait till the other transaction "commits" or "aborts"
        if (Locks.exclusiveLock.size() > 0 && !(Locks.exclusiveLock.containsKey(transaction.id)))
        {
            for (Map.Entry<String, Boolean> entry : Locks.exclusiveLock.entrySet()) //Find the transaction which has acquired the Write lock
            {
                if (entry.getValue().equals(true)) {
                    writeLockTransactionId = entry.getKey();
                }
                try {
                    System.out.println("A Write lock has been acquired by Transaction: " + writeLockTransactionId + " ......Please Wait!");
                    Thread.sleep(200);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
        }
         else
            {
                if (query.toLowerCase().contains("select")) //Read the first statement, if it's a "Select" statement than a shared lock is to be acquired
                {
                    Locks.sharedLock.put(transaction.id, true); //The transaction acquires the Shared/Read lock
                    System.out.println("Transaction - " + transaction.id + " has acquired an Shared/Read lock ");
                }
                else
                {
                    Locks.exclusiveLock.put(transaction.id, true); //The transaction acquires the Exclusive/Write lock
                    System.out.println("Transaction - " + transaction.id + " has acquired an Exclusive/Write lock ");
                }
            }
        }

    public void transaction(String query) //Method to execute queries in the transaction
    {
        try
        {
            Statement stmt = con.createStatement();
            stmt.execute(query);
            stmt.close();
            System.out.println("Query - " + query + ".... Execution Complete for Transaction: " + transaction.id);
            release_locks(transaction);
        }
        catch (SQLException e)
        {
            e.printStackTrace();
        }
    }

    public void release_locks(Transactions transaction)
    {
        if(Locks.exclusiveLock.containsKey(transaction.id))
        {
            //Locks.exclusiveLock.put(transaction.id,false);
            Locks.exclusiveLock.remove(transaction.id);
            System.out.println("Releasing Exclusive Lock held by Transaction: " + transaction.id);
        }
        if(Locks.sharedLock.containsKey(transaction.id))
        {
            //Locks.sharedLock.put(transaction.id,false);
            Locks.sharedLock.remove(transaction.id);
            System.out.println("Releasing Shared Lock held by Transaction: " + transaction.id);
        }
    }

    public void closeConnection()
    {
        try {
            con.setAutoCommit(true);
            con.close();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    public void commit()
    {
        try {
            con.commit();
            System.out.println("Committed!");
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

}
