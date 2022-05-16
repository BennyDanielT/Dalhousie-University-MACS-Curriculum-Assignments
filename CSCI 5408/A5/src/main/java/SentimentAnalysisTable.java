public class SentimentAnalysisTable
{
    String tweetNumber;
    String tweetMessage;
    String tweetPositiveWords;
    String tweetNegativeWords;
    String tweetPolarity;

    public SentimentAnalysisTable(String tweetNumber, String tweetMessage, String tweetPositiveWords, String tweetNegativeWords, String tweetPolarity) {
        this.tweetNumber = tweetNumber;
        this.tweetMessage = tweetMessage;
        this.tweetPositiveWords = tweetPositiveWords;
        this.tweetNegativeWords = tweetNegativeWords;
        this.tweetPolarity = tweetPolarity;
    }

    public String getTweetNumber() {
        return tweetNumber;
    }

    public String getTweetMessage() {
        return tweetMessage;
    }

    public String getTweetPositiveWords() {
        return tweetPositiveWords;
    }

    public String getTweetNegativeWords() {
        return tweetNegativeWords;
    }

    public String getTweetPolarity() {
        return tweetPolarity;
    }

    public void setTweetNumber(String tweetNumber) {
        this.tweetNumber = tweetNumber;
    }

    public void setTweetMessage(String tweetMessage) {
        this.tweetMessage = tweetMessage;
    }

    public void setTweetPositiveWords(String tweetPositiveWords) {
        this.tweetPositiveWords = tweetPositiveWords;
    }

    public void setTweetNegativeWords(String tweetNegativeWords) {
        this.tweetNegativeWords = tweetNegativeWords;
    }

    public void setTweetPolarity(String tweetPolarity) {
        this.tweetPolarity = tweetPolarity;
    }

    @Override
    public String toString()
    {
        return this.tweetNumber + "\t" + this.tweetMessage + "\t" + this.tweetPositiveWords + "\t" + this.tweetNegativeWords + "\t" + this.tweetPolarity;
    }
}
