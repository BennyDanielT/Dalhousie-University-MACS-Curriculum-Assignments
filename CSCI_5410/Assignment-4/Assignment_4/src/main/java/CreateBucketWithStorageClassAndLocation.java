import com.google.auth.Credentials;
import com.google.auth.oauth2.GoogleCredentials;
import com.google.cloud.storage.BlobId;
import com.google.cloud.storage.BlobInfo;
import com.google.cloud.storage.Storage;
import com.google.cloud.storage.StorageOptions;
import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.nio.file.Files;
import com.google.cloud.storage.BucketInfo;
import com.google.cloud.storage.Bucket;


public class CreateBucketWithStorageClassAndLocation {
    public static void createBucketWithStorageClassAndLocation(String projectId, String bucketName,  File[] dataset) throws IOException
    {
        Credentials credentials = GoogleCredentials.fromStream(new FileInputStream("src/csci5410-assignment-4-0356bf0945f3.json"));
        Storage storage = StorageOptions.newBuilder().setCredentials(credentials).setProjectId(projectId).build().getService();
        Bucket bucket = storage.create(BucketInfo.newBuilder(bucketName).build());
        System.out.println("Created bucket " + bucket.getName());
int count=0;
        for(File file : dataset)
        {
            if(count<10) {
                BlobId blobId = BlobId.of(bucketName, file.getName());
                BlobInfo blobInfo = BlobInfo.newBuilder(blobId).build();
                storage.create(blobInfo, Files.readAllBytes(file.toPath()));
                System.out.println("File - " + file.getName() + " has been uploaded to bucket - " + bucketName);
                count++;
            }
            else {
                break;
            }
        }
    }

    public static void createBucketWithStorageClassAndLocation(String projectId, String bucketName) throws IOException
    {
        Credentials credentials = GoogleCredentials.fromStream(new FileInputStream("src/csci5410-assignment-4-0356bf0945f3.json"));
        Storage storage = StorageOptions.newBuilder().setCredentials(credentials).setProjectId(projectId).build().getService();
        Bucket bucket = storage.create(BucketInfo.newBuilder(bucketName).build());
        System.out.println("Created bucket " + bucket.getName());
    }
}