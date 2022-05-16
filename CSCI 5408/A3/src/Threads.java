import java.sql.Connection;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class Threads extends Thread
{
    Transactions transaction;

    public Threads(Transactions transaction)
    {
        this.transaction = transaction;
    }

    @Override
    public void run()
    {
        Orchestration lockOrchestration = new Orchestration(transaction);
//        lockOrchestration.acquire_locks(transaction);
//        lockOrchestration.transaction(transaction);
//        lockOrchestration.release_locks(transaction);
        lockOrchestration.closeConnection();
    }

}