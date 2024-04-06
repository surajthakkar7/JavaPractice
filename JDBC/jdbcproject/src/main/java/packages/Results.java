package packages;

public class Results {
    private String artistName;
    private String collectionName;
    private String trackName;
    private String collectionPrice;
    private String trackPrice;
    private String releaseDate;

    @Override
    public String toString() {
        return "YourClassName{" +
                "artistName='" + artistName + '\'' +
                ", collectionName='" + collectionName + '\'' +
                ", trackName='" + trackName + '\'' +
                ", collectionPrice='" + collectionPrice + '\'' +
                ", trackPrice='" + trackPrice + '\'' +
                ", releaseDate='" + releaseDate + '\'' +
                '}';
    }

    // Getters and Setters for all the attributes of the class.

    // Getter methods
    public String getArtistName() {
        return artistName;
    }

    public String getCollectionName() {
        return collectionName;
    }

    public String getTrackName() {
        return trackName;
    }

    public String getCollectionPrice() {
        return collectionPrice;
    }

    public String getTrackPrice() {
        return trackPrice;
    }

    public String getReleaseDate() {
        return releaseDate;
    }

    // Setter methods
    public void setArtistName(String artistName) {
        this.artistName = artistName;
    }

    public void setCollectionName(String collectionName) {
        this.collectionName = collectionName;
    }

    public void setTrackName(String trackName) {
        this.trackName = trackName;
    }

    public void setCollectionPrice(String collectionPrice) {
        this.collectionPrice = collectionPrice;
    }

    public void setTrackPrice(String trackPrice) {
        this.trackPrice = trackPrice;
    }

    public void setReleaseDate(String releaseDate) {
        this.releaseDate = releaseDate;
    }
}