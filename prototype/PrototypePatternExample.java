package creational.prototype;
import java.util.HashMap;
import java.util.Map;

abstract class MusicComposition implements Cloneable {
    protected String title;
    protected String artist;
    protected String genre;

    public abstract void play();

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getArtist() {
        return artist;
    }

    public void setArtist(String artist) {
        this.artist = artist;
    }

    public String getGenre() {
        return genre;
    }

    public void setGenre(String genre) {
        this.genre = genre;
    }

    @Override
    public MusicComposition clone() throws CloneNotSupportedException {
        return (MusicComposition) super.clone();
    }
}

class Song extends MusicComposition {
    public Song(String title, String artist, String genre) {
        this.title = title;
        this.artist = artist;
        this.genre = genre;
    }

    @Override
    public void play() {
        System.out.println("Playing song: " + title + " by " + artist);
    }
}

class MusicCompositionRegistry {
    private Map<String, MusicComposition> prototypes = new HashMap<>();

    public MusicCompositionRegistry() {
        // Додати початкові прототипи музичних композицій
        prototypes.put("pop", new Song("Shape of You", "Ed Sheeran", "Pop"));
        prototypes.put("rock", new Song("Bohemian Rhapsody", "Queen", "Rock"));
    }

    public void addComposition(String key, MusicComposition composition) {
        prototypes.put(key, composition);
    }

    public MusicComposition getComposition(String key) {
        try {
            return prototypes.get(key).clone();
        } catch (CloneNotSupportedException e) {
            e.printStackTrace();
            return null;
        }
    }
}

public class PrototypePatternExample {
    public static void main(String[] args) {
        MusicCompositionRegistry registry = new MusicCompositionRegistry();

        MusicComposition popSongClone = registry.getComposition("pop");
        if (popSongClone != null) {
            popSongClone.play();
        }

        registry.addComposition("classical", new Song("Für Elise", "Ludwig van Beethoven", "Classical"));
        
        MusicComposition classicalSongClone = registry.getComposition("classical");
        if (classicalSongClone != null) {
            classicalSongClone.play();
        }
    }
}

