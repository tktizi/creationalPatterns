package creational.ab_factory;

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

// аб. фаб.
interface MusicInstrumentFactory {
    Instrument createInstrument();
}

class GuitarFactory implements MusicInstrumentFactory {
    @Override
    public Instrument createInstrument() {
        return new Guitar();
    }
}

class PianoFactory implements MusicInstrumentFactory {
    @Override
    public Instrument createInstrument() {
        return new Piano();
    }
}

class AllInstrumentFactory {
    public MusicInstrumentFactory create(String type){
        return switch (type){
            case "Guitar" -> new GuitarFactory();
            case "Piano" -> new PianoFactory();
            default -> throw new IllegalArgumentException("Unknown Instrument: " + type);
        };
    }
}


public class Main {
    public static void main(String[] args) {
        AllInstrumentFactory AllInstrumentFactory = new AllInstrumentFactory();
        MusicInstrumentFactory guitarFactory = AllInstrumentFactory.create("Guitar");
        Instrument guitar = guitarFactory.createInstrument();
        guitar.play();

        MusicInstrumentFactory pianoFactory = AllInstrumentFactory.create("Piano");
        Instrument piano = pianoFactory.createInstrument();
        piano.play();
    }
}
