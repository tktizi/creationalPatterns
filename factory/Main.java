package creational.factory;

interface Instrument {
    void play();
}

class Guitar implements Instrument {
    @Override
    public void play() {
        System.out.println("Playing guitar");
    }
}

class Piano implements Instrument {
    @Override
    public void play() {
        System.out.println("Playing piano");
    }
}

abstract class MusicInstrumentFactory {
    abstract Instrument createInstrument();

    void playMusic() {
        Instrument instrument = createInstrument();
        System.out.print("Let's play some music: ");
        instrument.play();
    }
}

class GuitarFactory extends MusicInstrumentFactory {
    @Override
    Instrument createInstrument() {
        return new Guitar();
    }
}

class PianoFactory extends MusicInstrumentFactory {
    @Override
    Instrument createInstrument() {
        return new Piano();
    }
}

public class Main {
    public static void main(String[] args) {
        MusicInstrumentFactory guitarFactory = new GuitarFactory();
        guitarFactory.playMusic();

        MusicInstrumentFactory pianoFactory = new PianoFactory();
        pianoFactory.playMusic();
    }
}
