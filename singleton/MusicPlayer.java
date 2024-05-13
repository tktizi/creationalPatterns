package creational.singleton;

public class MusicPlayer {
    private static MusicPlayer instance;

    private MusicPlayer() {
    }

    public static MusicPlayer getInstance() {
        if (instance == null) {
            instance = new MusicPlayer();
        }
        return instance;
    }

    public void playMusic() {
        System.out.println("Playing music...");
    }
}
