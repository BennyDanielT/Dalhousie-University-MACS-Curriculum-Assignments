public class SemanticAnalysisTable
{
    String tweetNumber;
    String tweetMessage;
    String totalWords;
    String weatherFrequency;

    public SemanticAnalysisTable(String tweetNumber, String tweetMessage, String totalWords, String weatherFrequency) {
        this.tweetNumber = tweetNumber;
        this.tweetMessage = tweetMessage;
        this.totalWords = totalWords;
        this.weatherFrequency = weatherFrequency;
    }

    public String getTweetNumber() {
        return tweetNumber;
    }

    public void setTweetNumber(String tweetNumber) {
        this.tweetNumber = tweetNumber;
    }

    public String getTweetMessage() {
        return tweetMessage;
    }

    public void setTweetMessage(String tweetMessage) {
        this.tweetMessage = tweetMessage;
    }

    public String getTotalWords() {
        return totalWords;
    }

    public void setTotalWords(String totalWords) {
        this.totalWords = totalWords;
    }

    public String getWeatherFrequency() {
        return weatherFrequency;
    }

    public void setWeatherFrequency(String weatherFrequency) {
        this.weatherFrequency = weatherFrequency;
    }

    @Override
    public String toString()
    {
        return this.tweetNumber + "\t" + this.tweetMessage + "\t" + String.valueOf(this.totalWords) + "\t" + String.valueOf(this.weatherFrequency);
    }
}
