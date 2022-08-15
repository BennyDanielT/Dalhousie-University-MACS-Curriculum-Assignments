import com.amazonaws.auth.BasicAWSCredentials;
import com.amazonaws.auth.BasicSessionCredentials;
import com.amazonaws.services.s3.AmazonS3;
import com.amazonaws.services.s3.AmazonS3Client;
import com.amazonaws.services.s3.model.AmazonS3Exception;
import com.amazonaws.services.s3.model.ObjectListing;
import com.amazonaws.services.s3.model.S3ObjectSummary;

import java.io.File;
import java.util.Formatter;

public class InsertObjectS3Bucket
{
    public static AmazonS3 connectToAWS()
    {
        System.out.println("Establishing a connection with AWS...");
        String accessKey = Globals.getAccessKey();
        String secretKey = Globals.getSecretKey();
        String sessionToken = Globals.getSessionToken();
        BasicSessionCredentials awsCred = new BasicSessionCredentials(accessKey, secretKey, sessionToken);
        AmazonS3 s3client = new AmazonS3Client(awsCred);
        System.out.println(s3client.getRegionName());
        var w = s3client.getS3AccountOwner();
        System.out.println(w);
        System.out.println("Connected to AWS...");
        return s3client;

    }


    public static void uploadFile(AmazonS3 s3client)
    {
        String bucketName = Globals.getBucketName();
        try
        {
            s3client.putObject(bucketName,"./Benny.txt",new File("./Benny.txt"));
        }
        catch(AmazonS3Exception e)
        {
            e.printStackTrace();
            System.out.println("Could not connect to AWS! Please verify your credentials.");
        }

        //List the contents of the Bucket after uploading the file
        ObjectListing objectListing = s3client.listObjects(bucketName);
        Formatter fmt = new Formatter();
        fmt.format("%15s %15s\n", "Object Key", "Owner");
        for (S3ObjectSummary os : objectListing.getObjectSummaries())
        {
            fmt.format("%14s %14s\n",os.getKey(),os.getOwner());

        }
        System.out.println(fmt);
    }

    public static void main(String[] args)
    {

        System.out.println("Uploading a File to a S3 Bucket...");
        AmazonS3 s3client = connectToAWS();
        uploadFile(s3client);

    }

    }
