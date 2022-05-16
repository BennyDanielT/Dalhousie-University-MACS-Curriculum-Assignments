import com.mongodb.MongoClient;
import com.mongodb.MongoClientURI;
import com.mongodb.client.FindIterable;
import com.mongodb.client.MongoDatabase;
import org.bson.Document;
import org.davidmoten.text.utils.WordWrap;

import java.io.BufferedWriter;
import java.io.IOException;
import java.util.*;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class SemanticAnalysis
{
    private static double totalDocuments=0,weatherCounter=0,peopleCounter=0,conditionCounter=0;
    private static double weatherTF_IDF,peopleTF_IDF,conditionTF_IDF;
    private static List<String> tweetsContainingWeather = new ArrayList<>();
    private static List<SemanticAnalysisTable> termFrequencyTable = new ArrayList<>();

    public static void main(String args[]) throws IOException
    {
        int rowCount=0;
        retrieveTweets();
        calculateTermFrequency();
        displayTF_IDFTable();
        System.out.println("\n\n\n");
        displayTermFreqencyTable();
    }

    public static void retrieveTweets()
    {
        GLOBAL con = new GLOBAL();
        String URL = con.getMongoURL();
        MongoClientURI connectionString = new MongoClientURI(URL);
        MongoClient mongoClient = new MongoClient(connectionString);
        MongoDatabase database = mongoClient.getDatabase("MyMongoTweets");

        String csvRow;
        String message="";
        BufferedWriter writeToCSV = null;

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
                calculateTF_IDF(message);
                totalDocuments++;
            }
        }
        weatherTF_IDF = Math.log10(totalDocuments/weatherCounter);
        peopleTF_IDF = Math.log10(totalDocuments/peopleCounter);
        conditionTF_IDF = Math.log10(totalDocuments/conditionCounter);
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

    public static void calculateTF_IDF(String message)
    {
        String CSVRow;
        String checkRetweets="";
        Boolean weatherFlag=false,peopleFlag=false,conditionFlag=false;

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
            if (Objects.equals(bagOfWord, "weather") && !weatherFlag)
            {
                tweetsContainingWeather.add(message);
                weatherCounter++;
                weatherFlag=true;
            }
            if (Objects.equals(bagOfWord, "people") && !peopleFlag)
            {
                peopleCounter++;
                peopleFlag=true;
            }
            if (Objects.equals(bagOfWord, "condition") && !conditionFlag)
            {
                conditionCounter++;
                conditionFlag=true;
            }
        }
    }

    public static void calculateTermFrequency()
    {
        SemanticAnalysisTable semanticAnalysisTable;
        int totalWordsInTweet=0,frequencyOfWordWeather=0,tweetNumber=0;
        for(String weatherTweet:tweetsContainingWeather)
        {
            tweetNumber++;
            totalWordsInTweet = weatherTweet.split(" ").length;
            Matcher weatherMatcher = Pattern.compile("weather").matcher(weatherTweet); //Use Regular Expressions to determine the number of times "weather" is matched inside a tweet Message
            while (weatherMatcher.find())
            {
                frequencyOfWordWeather++;
            }
            semanticAnalysisTable = new SemanticAnalysisTable(String.valueOf(tweetNumber),weatherTweet,String.valueOf(totalWordsInTweet),String.valueOf(frequencyOfWordWeather));
            termFrequencyTable.add(semanticAnalysisTable);
            frequencyOfWordWeather=0;
        }
    }

    public static void displayTF_IDFTable()
    {
        final String tableFormatH1 = "%15s %15s %20s %20s\n";
        Formatter tableH1 = new Formatter();

        tableH1.format(tableFormatH1,"Total Documents (N): " + totalDocuments," "," "," ");

        final String tableFormat = "%15s %15s %20s %20s\n";
        Formatter table = new Formatter();
//        "%20s %20s %20s %20s\n";
        //System.out.println(String.format("N: %d", documentCount));
        table.format(tableFormat, "Search Query", "(df)", "(N)/(df)", "Log10(N/df)");
        table.format(tableFormat,"weather", weatherCounter, (double) totalDocuments / weatherCounter, weatherTF_IDF);
        table.format(tableFormat,"people", peopleCounter, (double) totalDocuments / peopleCounter, peopleTF_IDF);
        table.format(tableFormat,"condition", conditionCounter, (double) totalDocuments / conditionCounter, conditionTF_IDF);

        System.out.println("TF-IDF Table");
        System.out.println("---------------------------------------------------------------------------");
        System.out.print(tableH1);
        System.out.println("---------------------------------------------------------------------------");
        System.out.print(table);
        System.out.println("---------------------------------------------------------------------------");
    }

    public static void displayTermFreqencyTable()
    {
        double maxRelativeFrequency=0,tempFrequency=0;
        SemanticAnalysisTable tweetWithMaxFrequency = null;
        final String tableFormatH1 = "%10s %10s %20s %20s\n";
        Formatter tableH1 = new Formatter();
        tableH1.format(tableFormatH1,"Term","weather"," "," ");

        String WrappedTweet;
        final String tableFormat = "%100s %25s %25s %25s\n";
        Formatter table = new Formatter();
        table.format(tableFormat,"Tweets with 'weather'","Tweet Number", "Total Words (m)", "Frequency (f)");
        for(SemanticAnalysisTable row:termFrequencyTable) //Loop to add
        {
            tempFrequency = (Double.parseDouble(row.weatherFrequency)/Double.parseDouble(row.totalWords));
            if(tempFrequency>maxRelativeFrequency)
            {
                maxRelativeFrequency = tempFrequency;
                tweetWithMaxFrequency = row;
            }
//            WrappedTweet = WordWrap.from(row.tweetMessage.trim()).maxWidth(200).insertHyphens(true).wrap();
            row.tweetMessage = row.tweetMessage.replaceAll("\\s{2,}", " ").trim();
            String [] words = row.tweetMessage.split(" ");
            String temp = "";
            int count = 0;
            int tableFlag = 0;
            for(String s : words)
            {
                if(count == 15)
                {
                    if(tableFlag == 0)
                    {
                        table.format(tableFormat, temp, row.tweetNumber, row.totalWords, row.weatherFrequency);
                        tableFlag = 1;
                    }
                    else
                    {
                        table.format(tableFormat, temp, "","","");
                    }
                    count=0;
                    temp = s;
                }
                else
                {
                    temp += s;
                    temp +=" ";
                    count++;
                }
            }
            if(count != 0) {
                if(tableFlag == 0) {
                    table.format(tableFormat, temp, row.tweetNumber, row.totalWords, row.weatherFrequency);
                    tableFlag = 1;
                }
                else{
                    table.format(tableFormat, temp, "","","");
                }
            }
        }
        System.out.println("Term frequency Table");
        System.out.println("---------------------------------------------------------------------------");
        System.out.print(tableH1);
        System.out.println("---------------------------------------------------------------------------");
        System.out.print(table);
        System.out.println("---------------------------------------------------------------------------");
        if(maxRelativeFrequency>0)
        {
            System.out.println(String.format("Tweet Number: %s has the highest relative frequency with a value of %s for the term weather. The tweet message is: %s", tweetWithMaxFrequency.tweetNumber, maxRelativeFrequency, tweetWithMaxFrequency.tweetMessage));
        }
        else
            System.out.println("No Tweets with the word weather were logged.");
        System.out.println();
    }
}
