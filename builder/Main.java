package creational.builder;
class Track {
    private String title;
    private String artist;
    private String album;
    private int duration;

    private Track(TrackBuilder builder) {
        this.title = builder.title;
        this.artist = builder.artist;
        this.album = builder.album;
        this.duration = builder.duration;
    }

    public String getTitle() {
        return title;
    }

    public String getArtist() {
        return artist;
    }

    public String getAlbum() {
        return album;
    }

    public int getDuration() {
        return duration;
    }

    // вкл. клас
    static class TrackBuilder {
        private String title;
        private String artist;
        private String album;
        private int duration;

        public TrackBuilder setTitle(String title) {
            this.title = title;
            return this;
        }

        public TrackBuilder setArtist(String artist) {
            this.artist = artist;
            return this;
        }

        public TrackBuilder setAlbum(String album) {
            this.album = album;
            return this;
        }

        public TrackBuilder setDuration(int duration) {
            this.duration = duration;
            return this;
        }

        public Track build() {
            return new Track(this);
        }
    }
}

public class Main {
    public static void main(String[] args) {
        Track track = new Track.TrackBuilder()
                .setTitle("Bohemian Rhapsody")
                .setArtist("Queen")
                .setAlbum("A Night at the Opera")
                .setDuration(355)
                .build();

        System.out.println("Title: " + track.getTitle());
        System.out.println("Artist: " + track.getArtist());
        System.out.println("Album: " + track.getAlbum());
        System.out.println("Duration: " + track.getDuration() + " seconds");
    }
}

