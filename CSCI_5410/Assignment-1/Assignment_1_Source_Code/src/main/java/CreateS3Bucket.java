
import com.amazonaws.auth.BasicSessionCredentials;
import com.amazonaws.services.s3.AmazonS3;
import com.amazonaws.services.s3.AmazonS3Client;
import java.io.*;
import java.util.Formatter;

import com.amazonaws.services.s3.model.ObjectListing;
import com.amazonaws.services.s3.model.AmazonS3Exception;
import com.amazonaws.services.s3.model.S3ObjectSummary;

public class CreateS3Bucket
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

    public static void createS3Bucket(AmazonS3 s3client)
    {
        String bucketName = Globals.getBucketName();

        if(s3client.doesBucketExistV2(bucketName)) {
            System.out.println("Bucket name is not available. Try again with a different Bucket name.");
            return;
        }

        try
        {
        s3client.createBucket(bucketName);
    }
        catch(AmazonS3Exception e)
    {
        e.printStackTrace();
        System.out.println("Could not connect to AWS! Please verify your credentials.");
    }
        System.out.println("A S3 bucket with name - '" + bucketName + "' has been generated!");
    }

    public static void main(String[] args)
    {

        System.out.println("Creating a S3 Bucket...");
        AmazonS3 s3client=connectToAWS();
        createS3Bucket(s3client);
    }

    }
