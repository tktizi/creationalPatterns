package creational.singleton;

public class Main {
    public static void main(String[] args) {
        MusicPlayer player1 = MusicPlayer.getInstance();
        MusicPlayer player2 = MusicPlayer.getInstance();

        if (player1 == player2) {
            System.out.println("player1 та player2 вказують на один і той же об'єкт");
        }

        player1.playMusic();
        player2.playMusic();

    }
}
