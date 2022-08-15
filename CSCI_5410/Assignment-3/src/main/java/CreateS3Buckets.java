import com.amazonaws.auth.AWSStaticCredentialsProvider;
import com.amazonaws.auth.BasicSessionCredentials;
import com.amazonaws.regions.Regions;
import com.amazonaws.services.s3.AmazonS3;
import com.amazonaws.services.s3.AmazonS3ClientBuilder;

public class CreateS3Buckets
{

    public static void createBucket(AmazonS3 s3cli,String bucketName)
    {
        var it = s3cli.createBucket(bucketName);
    }

    public static void main(String[] args)
    {
        String id = Credentials.aws_access_key_id;
        String key = Credentials.aws_secret_access_key;
        String token = Credentials.aws_session_token;
        BasicSessionCredentials sessionCredentials = new BasicSessionCredentials(id,key,token);
        AmazonS3 s3cli = AmazonS3ClientBuilder.standard().withCredentials(new AWSStaticCredentialsProvider(sessionCredentials)).withRegion(Regions.DEFAULT_REGION).build();
        createBucket( s3cli,"twitterdatab00899629");
        createBucket( s3cli,"destinationbucketb00899629");

    }
}
