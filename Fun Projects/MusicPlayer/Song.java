public class Song {
    private String title;
    private String artist;
    private int duration; // in seconds

    public Song(String title, String artist, int duration) {
        // information about the song 
        this.title = title;
        this.artist = artist;
        this.duration = duration;
    }

    // getter methods 
    public String getTitle() {
        return title;
    }

    public String getArtist() {
        return artist;
    }

    public int getDuration() {
        return duration;
    }

    @Override
    public String toString() {
        return title + " - " + artist + " (" + formatDuration() + ")";
    }

    //helper functions 
    private String formatDuration() {
        int minutes = duration / 60;
        int seconds = duration % 60;
        return String.format("%d:%02d", minutes, seconds);
    }
}
