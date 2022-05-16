public class GLOBAL
{
    private static final String bearerToken = "AAAAAAAAAAAAAAAAAAAAAHRZZwEAAAAA1Om8ZMn7TMdF0ZLUfEEysqhkeYI%3DVteWw95lrzEBgDrk8youODXjenpkZ1SI0oOFr7gCNOoX8tkDnX";
    private static final String mongoURL = "mongodb+srv://Danny:admin@cluster0.r6eqr.mongodb.net/myFirstDatabase?retryWrites=true&w=majority";
    static final String CSV_SEPARATOR = ",";
    static final String POSITIVE = "positive";
    static final String NEGATIVE = "negative";
    static final String NEUTRAL = "neutral";

    public String getBearerToken()
    {
        return bearerToken;
    }

    public String getMongoURL()
    {
        return mongoURL;
    }


}
