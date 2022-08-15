import java.io.File;
import java.io.IOException;

public class CreateBuckets
{
    public static void main(String[] args)
    {
        String projectId = Credentials.PROJECT_ID;
        String sourceBucket = "sourcedatab00899629";
        String trainBucket = "traindatab00899629";
        String testBucket = "testdatab00899629";
        File parentDirectory = new File("./src/data/Train");
        File[] trainDataset = parentDirectory.listFiles();

        File testParentDirectory = new File("./src/data/Test");
        File[] testDataset = testParentDirectory.listFiles();

        try {
            CreateBucketWithStorageClassAndLocation.createBucketWithStorageClassAndLocation(projectId,sourceBucket,trainDataset);
            CreateBucketWithStorageClassAndLocation.createBucketWithStorageClassAndLocation(projectId,trainBucket);
            CreateBucketWithStorageClassAndLocation.createBucketWithStorageClassAndLocation(projectId,sourceBucket);
        } catch (IOException e) {
            System.out.println(e);
        }
    }
}



//            CreateBucketWithStorageClassAndLocation.createBucketWithStorageClassAndLocation(projectId,trainBucket);
//            CreateBucketWithStorageClassAndLocation.createBucketWithStorageClassAndLocation(projectId,testBucket);


//    from google.cloud import storage
//        from requests_toolbelt.multipart import decoder
//        import re
//
//        def edit_distance(s1,s2):
//        if len(s1) > len(s2):
//        s1,s2 = s2,s1
//        l1 = len(s1) + 1
//        l2 = len(s2) + 1
//        dp = {}
//        for i in range(l1):
//        dp[i,0] = i
//        for j in range(l2):
//        dp[0,j] = j
//        for i in range(1,l1):
//        for j in range(1,l2):
//        cost = 0 if s1[i - 1] == s2[j - 1] else 1
//        dp[i,j] = min(dp[i,j - 1] + 1, dp[i - 1,j] + 1,dp[i - 1,j - 1] + cost)
//        return dp[l1 - 1,l2 - 1]
//
//        def gen_vec(event, context):
//
//        stopWords = [ ""," ", "a", "about", "above", "across", "after", "again",
//        "against", "all", "almost", "alone", "along", "already", "also",
//        "although", "always", "among", "an", "and", "another", "any",
//        "anybody", "anyone", "anything", "anywhere", "are", "area",
//        "areas", "around", "as", "ask", "asked", "asking", "asks", "at",
//        "away", "b", "back", "backed", "backing", "backs", "be", "became",
//        "because", "become", "becomes", "been", "before", "began",
//        "behind", "being", "beings", "best", "better", "between", "big",
//        "both", "but", "by", "c", "came", "can", "cannot", "case", "cases",
//        "certain", "certainly", "clear", "clearly", "come", "could", "d",
//        "did", "differ", "different", "differently", "do", "does", "done",
//        "down", "down", "downed", "downing", "downs", "during", "e",
//        "each", "early", "either", "end", "ended", "ending", "ends",
//        "enough", "even", "evenly", "ever", "every", "everybody",
//        "everyone", "everything", "everywhere", "f", "face", "faces",
//        "fact", "facts", "far", "felt", "few", "find", "finds", "first",
//        "for", "four", "from", "full", "fully", "further", "furthered",
//        "furthering", "furthers", "g", "gave", "general", "generally",
//        "get", "gets", "give", "given", "gives", "go", "going", "good",
//        "goods", "got", "great", "greater", "greatest", "group", "grouped",
//        "grouping", "groups", "h", "had", "has", "have", "having", "he",
//        "her", "here", "herself", "high", "high", "high", "higher",
//        "highest", "him", "himself", "his", "how", "however", "i", "if",
//        "important", "in", "interest", "interested", "interesting",
//        "interests", "into", "is", "it", "its", "itself", "j", "just", "k",
//        "keep", "keeps", "kind", "knew", "know", "known", "knows", "l",
//        "large", "largely", "last", "later", "latest", "least", "less",
//        "let", "lets", "like", "likely", "long", "longer", "longest", "m",
//        "made", "make", "making", "man", "many", "may", "me", "member",
//        "members", "men", "might", "more", "most", "mostly", "mr", "mrs",
//        "much", "must", "my", "myself", "n", "necessary", "need", "needed",
//        "needing", "needs", "never", "new", "new", "newer", "newest",
//        "next", "no", "nobody", "non", "noone", "not", "nothing", "now",
//        "nowhere", "number", "numbers", "o", "of", "off", "often", "old",
//        "older", "oldest", "on", "once", "one", "only", "open", "opened",
//        "opening", "opens", "or", "order", "ordered", "ordering", "orders",
//        "other", "others", "our", "out", "over", "p", "part", "parted",
//        "parting", "parts", "per", "perhaps", "place", "places", "point",
//        "pointed", "pointing", "points", "possible", "present",
//        "presented", "presenting", "presents", "problem", "problems",
//        "put", "puts", "q", "quite", "r", "rather", "really", "right",
//        "right", "room", "rooms", "s", "said", "same", "saw", "say",
//        "says", "second", "seconds", "see", "seem", "seemed", "seeming",
//        "seems", "sees", "several", "shall", "she", "should", "show",
//        "showed", "showing", "shows", "side", "sides", "since", "small",
//        "smaller", "smallest", "so", "some", "somebody", "someone",
//        "something", "somewhere", "state", "states", "still", "still",
//        "such", "sure", "t", "take", "taken", "than", "that", "the",
//        "their", "them", "then", "there", "therefore", "these", "they",
//        "thing", "things", "think", "thinks", "this", "those", "though",
//        "thought", "thoughts", "three", "through", "thus", "to", "today",
//        "together", "too", "took", "toward", "turn", "turned", "turning",
//        "turns", "two", "u", "under", "until", "up", "upon", "us", "use",
//        "used", "uses", "v", "very", "w", "want", "wanted", "wanting",
//        "wants", "was", "way", "ways", "we", "well", "wells", "went",
//        "were", "what", "when", "where", "whether", "which", "while",
//        "who", "whole", "whose", "why", "will", "with", "within",
//        "without", "work", "worked", "working", "works", "would", "x", "y",
//        "year", "years", "yet", "you", "young", "younger", "youngest",
//        "your", "yours", "z" ]
//
//
//        storage_client = storage.Client()
//
//        file = event
//        bucket = storage_client.get_bucket(file['bucket'])
//        uploadbucket = storage_client.get_bucket('traindatab00899629');
//        blob = bucket.blob(file['name'])
//        contents = blob.download_as_string()
//
//        decodedstring = contents.decode(encoding="utf-8", errors="ignore")
//        decodedstring = decodedstring.replace("\n", " ")
//        words = decodedstring.split(" ")
//        length = len(words)
//        uploadCsv = 'trainVector.csv'
//        StoreInCsv = ""
//        blob = uploadbucket.blob(uploadCsv)
//        if blob.exists():
//        contents = blob.download_as_string()
//        decodedstring = contents.decode(encoding="utf-8", errors="ignore")
//        StoreInCsv = decodedstring
//        else:
//        StoreInCsv = "Current_Word,Next_Word,Levenshtein_distance" + '\n';
//
//        print(StoreInCsv)
//
//        for i in range(length - 1):
//        s1 = re.sub('[^A-Za-z]+', '', words[i])
//        s2 = re.sub('[^A-Za-z]+', '', words[i  + 1])
//        if (s1.lower() not in stopWords) and (s2.lower() not in stopWords):
//        distance = edit_distance(s1.lower(), s2.lower())
//        StoreInCsv += s1 + "," + s2 + "," + str(distance) + '\n'
//
//        print(StoreInCsv)
//
//        uploadblob = uploadbucket.blob(uploadCsv)
//        uploadblob.upload_from_string(StoreInCsv)
//
