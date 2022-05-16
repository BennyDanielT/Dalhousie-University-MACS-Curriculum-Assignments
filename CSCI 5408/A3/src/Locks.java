import java.util.HashMap;
import java.util.Map;

public class Locks
{
    public Locks()
    {
    }

    static Map<String,Boolean> sharedLock = new HashMap<>(); // Lock only for READING
    static Map<String, Boolean> exclusiveLock = new HashMap<>(); // Lock only for WRITING

    //Getters & Setters
    public static Map<String, Boolean> getSharedLock() {
        return sharedLock;
    }

    public static void setSharedLock(Map<String, Boolean> sharedLock) {
        Locks.sharedLock = sharedLock;
    }

    public static Map<String, Boolean> getExclusiveLock() {
        return exclusiveLock;
    }

    public static void setExclusiveLock(Map<String, Boolean
            > exclusiveLock) {
        Locks.exclusiveLock = exclusiveLock;
    }



}
