import com.amazonaws.auth.AWSStaticCredentialsProvider;
import com.amazonaws.auth.BasicSessionCredentials;
import com.amazonaws.regions.Regions;
import com.amazonaws.services.s3.AmazonS3;
import com.amazonaws.services.s3.AmazonS3ClientBuilder;
import java.io.File;
import java.util.concurrent.TimeUnit;

public class UploadTweetFile {
    public static void main(String[] args) throws InterruptedException
    {
        CreateS3Buckets obj = new CreateS3Buckets();
        String id = Credentials.aws_access_key_id;
        String key = Credentials.aws_secret_access_key;
        String token = Credentials.aws_session_token;
        BasicSessionCredentials sessionCredentials = new BasicSessionCredentials(id,key,token);
        AmazonS3 s3Client = AmazonS3ClientBuilder.standard().withCredentials(new AWSStaticCredentialsProvider(sessionCredentials)).withRegion(Regions.US_WEST_2).build();
        String s3Bucket1 = "twitterdatab00899629";
        File folderPath = new File("./src/tweets");
        File[] allFiles = folderPath.listFiles();
        for (File f : allFiles)
        {
            s3Client.putObject(s3Bucket1, f.getName(), f);
            System.out.println("The Tweet File - " + f.getName() + " has been uploaded to the S3 Bucket - " + s3Bucket1);
        }


    }
}