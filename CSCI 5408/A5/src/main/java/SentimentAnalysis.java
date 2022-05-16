import com.mongodb.MongoClient;
import com.mongodb.MongoClientURI;
import com.mongodb.client.FindIterable;
import com.mongodb.client.MongoDatabase;
import org.bson.Document;
import java.io.*;
import java.util.*;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

/*
* *** Overview of my Algorithm***
        Obtain Mongo Tweets
        Retrieve the text component from each tweet
        For each Tweet in the database:
            Create a bag of word for each tweet
            Compare the Bag of words with Lists of Positive and Negative Words
            For each word in the bag for a Tweet:
                Verify if the word exists in the list of Positive/Negative words
                Increment the score for the tweet Accordingly
            Add the scores for the bag (Positive - Negative)
            Display the Tweet Number, Tweet, Words in the Bag and the appropriate Polarity
    * */

public class SentimentAnalysis
{
    private static int tweetNumber=0;
    private static Set<String> positiveWordSet = new HashSet<>();
    private static Set<String> negativeWordSet = new HashSet<>();
    private static List<SentimentAnalysisTable> sentimentAnalysisTable = new ArrayList<>();

    public static void main(String args[]) throws IOException
    {
        int rowCount=0;
        configureWordLists();
        retrieveTweets();
        System.out.println("**********Sentiment Analysis SentimentAnalysisTable:Sample Rows**********");
        System.out.println("| Tweet Number | \t Message | \t Positive Words | \t Negative Words | \t Polarity |");
        for(SentimentAnalysisTable row:sentimentAnalysisTable)
        {
            if(rowCount==10) //limit 10 rows as a sample
            {
                break;
            }
            System.out.println(row.toString());
            rowCount++;
        }
        System.out.println("Analysis Results have been written to SentimentAnalysisTable.csv!");
    }

    public static void configureWordLists()
    {

        String p,n;
        try {
            BufferedReader readPositiveWords = new BufferedReader(new FileReader(new File("./positive-words.txt")));
            while((p = readPositiveWords.readLine())!=null)
            {
                positiveWordSet.add(p.trim().toLowerCase());
            }
            BufferedReader readNegativeWords = new BufferedReader(new FileReader(new File("./negative-words.txt")));
            while((n = readNegativeWords.readLine())!=null)
            {
                negativeWordSet.add(n.trim().toLowerCase());
            }
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }

    }

    public static void retrieveTweets()
    {
    /*In this method:
        Retrieve the Tweets from MongoDB
        Subsequently retrieve the text/message from the tweet
        subsequently count the number of positive and negative words in each tweet and display it in tabular format along with the polarity
     */
        GLOBAL con = new GLOBAL();
        String URL = con.getMongoURL();
        MongoClientURI connectionString = new MongoClientURI(URL);
        MongoClient mongoClient = new MongoClient(connectionString);
        MongoDatabase database = mongoClient.getDatabase("MyMongoTweets");
        String csvRow;
        String message="";
        BufferedWriter writeToCSV = null;
        try
        {
            writeToCSV = new BufferedWriter(new OutputStreamWriter(new FileOutputStream("./SentimentAnalysisTable.csv")));
            ArrayList<String> listKeywords = new ArrayList<String>(
                    List.of("cold",
                        "flu",
                        "immune",
                        "mask",
                        "vaccine",
                        "snow"
                    ));
            for(int i=0;i<6;i++)//REMOVE change to 6
            {
                var store = database.getCollection(listKeywords.get(i));
                FindIterable<Document> iterDoc = store.find();
                Iterator iterator = iterDoc.iterator();
                while(iterator.hasNext())
                {
                    Object rows = iterator.next();//Obtain the Tweet from MongoDB
                    String rowsString = rows.toString();//Convert the Tweet to String format
                    //System.out.println("\nMongoDB Tweet: " + rowsString);
                    String messagePart = retrieveTextFromTweet(rowsString);

                    String[] messageArray = messagePart.split("=",2);
                    if(messageArray.length>1) {
                        message = messageArray[1].trim().toLowerCase();
                    }
                    //System.out.println("Final Message: " + message);

                    csvRow = calculatePolarity(message);
                    writeToCSV.write(csvRow);
                    writeToCSV.newLine();
                }
            }
            writeToCSV.flush();
            writeToCSV.close();
        }
        catch (IOException e)
        {
            e.printStackTrace();
        }

    }

    public static String retrieveTextFromTweet(String tweet)
    {
        /*In this method:
            Obtain the entire Tweet Message
            Split the Tweet based on Commas "," since tweet fields are separated by commas when retrieved from MongoDB
            Use Regular Expressions to retrieve only the field - "text":"TWEET_MESSAGE" from the Tweet Fields
                Create a pattern for Texts - "text=" The length of this pattern is FIVE
                Loop Through the Tweet Fields:
                    Search for the first occurrence of the pattern in the Tweet Fields by matching the first FIVE letters of each field with the pattern
                    If a match is found, remove the String - "text=" from the field
            Return the Tweet Message Field
     */
        String text ="";
        String[] tweetFields = tweet.split(",");
        Pattern textPattern = Pattern.compile("text=.*");//REGEX Pattern for obtaining the message part of a tweet5
        for(String fields:tweetFields)
        {
            Matcher patternMatcher = textPattern.matcher(fields);
            if(patternMatcher.find())
            {
                text = patternMatcher.group();
            }
        }
        return text;
    }

    public static String calculatePolarity(String message)
    {
        int polarity,positiveCounter=0,negativeCounter=0;
        Set<String> positiveWordSet = new HashSet<>();
        Set<String> negativeWordSet = new HashSet<>();
        String tweetPolarity;
        String CSVRow;
        String checkRetweets="";
        if(message.length()>2)
        {
            checkRetweets = message.substring(0, 2);
        }

        if(checkRetweets.equals("rt"))
        {
            message = message.replaceFirst("rt", "").trim();
        }
        String[] bagOfWords = message.split(" ");
        //System.out.println("Bag of Words: " + Arrays.toString(bagOfWords));

        for (String bagOfWord : bagOfWords)
        {
            if (SentimentAnalysis.negativeWordSet.contains(bagOfWord))
            {
                negativeWordSet.add(bagOfWord);
                negativeCounter++;
            }
            else if (SentimentAnalysis.positiveWordSet.contains(bagOfWord))
            {
                positiveWordSet.add(bagOfWord);
                positiveCounter++;
            }

        }
        polarity = (positiveCounter-negativeCounter);
        if(polarity<0)
        {
         tweetPolarity = GLOBAL.NEGATIVE;
        }
        else if(polarity==0)
        {
            tweetPolarity = GLOBAL.NEUTRAL;
        }
        else
        {
            tweetPolarity = GLOBAL.POSITIVE;
        }
        tweetNumber++;
        SentimentAnalysisTable row = new SentimentAnalysisTable(String.valueOf(tweetNumber),message,positiveWordSet.toString(),negativeWordSet.toString(),tweetPolarity);
        CSVRow = writeSentimentAnalysisTable(row); //Obtain the row in CSV format
        sentimentAnalysisTable.add(row); // Storing the row in an Arraylist to print the first 10 rows of the table as a sample
        return CSVRow;
    }

    public static String writeSentimentAnalysisTable(SentimentAnalysisTable row)
    {
        StringBuilder rowAsCSV = new StringBuilder();
//Append the contents of each SentimentAnalysisTable object into a StringBuffer and append commas after each field of the object
        rowAsCSV.append(row.tweetNumber);
        rowAsCSV.append(GLOBAL.CSV_SEPARATOR);
        rowAsCSV.append(row.tweetMessage);
        rowAsCSV.append(GLOBAL.CSV_SEPARATOR);
        rowAsCSV.append(row.tweetPositiveWords);
        rowAsCSV.append(GLOBAL.CSV_SEPARATOR);
        rowAsCSV.append(String.valueOf(row.tweetNegativeWords));
        rowAsCSV.append(GLOBAL.CSV_SEPARATOR);
        rowAsCSV.append(String.valueOf(row.tweetPolarity));
        //System.out.println("ROW: " + rowAsCSV.toString());
        return rowAsCSV.toString();

    }



}
