import com.amazonaws.auth.BasicSessionCredentials;
import com.amazonaws.services.dynamodbv2.AmazonDynamoDBClient;
import com.amazonaws.services.dynamodbv2.document.*;

import java.util.*;

/*
***
Structure of DynamoDB Table:
* name:
* place:
* properties:
* size:
* types_of_Campsites:
***
*/
public class UpdateDynamoDb
{
    private static AmazonDynamoDBClient client;
    public static AmazonDynamoDBClient connectToAWS()
    {
        System.out.println("Establishing a connection with AWS...");
        String accessKey = Globals.getAccessKey();
        String secretKey = Globals.getSecretKey();
        String sessionToken = Globals.getSessionToken();
        BasicSessionCredentials awsCred = new BasicSessionCredentials(accessKey, secretKey, sessionToken);
        client  =new AmazonDynamoDBClient(awsCred);
        System.out.println("Connected to AWS DynamoDB...");
        return client;
    }

    public static void addAttribute(String parkName, List<String> input)
    {
        DynamoDB dynamoDB = new DynamoDB (client);
        Table table = dynamoDB.getTable("Parks_NovaScotia");

        Map<String, String> attributes = new HashMap<String, String>();
        attributes.put("#s", "types_of_Campsites");


        Map<String, Object> vals = new HashMap<String, Object>();
        vals.put(":val1",new HashSet<String>(input));

        UpdateItemOutcome outcome =  table.updateItem(
                "Name",
                parkName,
                "add #s :val1",
                attributes,
                vals);

        System.out.println("Update Operation Outcome: " + outcome.toString());

        //---------------------
//        UpdateItemSpec updateItemSpec2 = new UpdateItemSpec().withPrimaryKey("Name", parkName)
//                .withUpdateExpression("add #t :val1")
//                .withValueMap(new ValueMap().withString(":val1", String.valueOf(new HashSet<String>(input))))
//                .withNameMap(new NameMap().with("#t","ty_of_Campsites"));
//        UpdateItemOutcome updateItemOutcome2 = table.updateItem(updateItemSpec2);

    }

    public static void addItem(List<List<String>> items)
    {
        DynamoDB dynamoDB = new DynamoDB (client);
        Table table = dynamoDB.getTable("Parks_NovaScotia");
        System.out.println(table.describe());
        for(List<String>input:items)
        {
            Item item = new Item()
                    .withPrimaryKey("Name",input.get(0))
                    .withString("Place",input.get(1))
                    .withString("properties",input.get(2))
                    .withString("size",input.get(3));
            PutItemOutcome outcome = table.putItem(item);

        }
    }

    public static void main(String[] args)
    {

        connectToAWS();

        List<String> input1 = Arrays.asList("Crystal Crescent Beach","223 Sambro Creek Rd","Campsites & Camper shelter","44 Campsites");

        List<String> input2 = Arrays.asList("Amherst Shore","6596 Hwy 366","Park office,Vault toilet,Restroom with shower","32 Campsites");

        List<String> input3 = Arrays.asList("Battery","10110 Hwy 4","Restroom with showers & Campsites","45 Campsites");

        List<String> input4 = Arrays.asList("Blomidon","3138 Pereau Road","Park office, Restrooms with showers, Look-off","94 Campsites");

        List<String> input5 = Arrays.asList("Boylston","11131 Hwy 16","Registration kiosk, Restrooms with showers, Campsites","34 Campsites");

        List<String> input6 = Arrays.asList("Cape Chignecto","1108 West Advocate Road","Restrooms, BBQ Sites & Kayaking","47 Campsites");

        List<String> input7 = Arrays.asList("Caribou-Munroes Island","2119 Three Brooks Road","Park office & Restroom with shower","89 Campsites");

        List<String> input8 = Arrays.asList("Mira River","439 Brickyard Road","Park office & Registration kiosk, Restrooms with shower, Beach access","156 Campsites");

        List<String> input9 = Arrays.asList("Porters Lake","1160 West Porters Lake Road","Registration kiosk, Restroom with shower, Campsites","80 Campsites");

        List<String> input10 = Arrays.asList("Valleyview","960 Hampton Mountain Road","Park office, Restroom with shower, Campsites","31 Campsites");

        List<List<String>> inputList = new ArrayList<>();
        inputList.add(input1);
        inputList.add(input2);
        inputList.add(input3);
        inputList.add(input4);
        inputList.add(input5);
        inputList.add(input6);
        inputList.add(input7);
        inputList.add(input8);
        inputList.add(input9);
        inputList.add(input10);

        addItem(inputList);

        addAttribute("Battery",Arrays.asList("Serviced, Unserviced, Walk-In"));
        addAttribute("Blomidon",Arrays.asList("Unserviced, Group"));
        addAttribute("Boylston",Arrays.asList("Unserviced"));
        addAttribute("Mira River",Arrays.asList("Serviced, Unserviced, Walk-In"));
        addAttribute("Valleyview",Arrays.asList("Serviced, Unserviced, Group"));
    }


}
