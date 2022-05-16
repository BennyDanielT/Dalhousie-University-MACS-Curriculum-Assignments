import java.util.ArrayList;
import java.util.List;

public class Transactions
{
    String id;
    List<String> query= new ArrayList();

    public Transactions(String id, List<String> query)
    {
        this.id=id;
        this.query=query;
    }
}
