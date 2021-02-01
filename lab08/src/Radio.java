public class Radio implements VolumeChangeable{
    private static final int MAX_VOLUME = 200;
    private static final int MIN_VOLUME = 0;
    private String name;
    private int volume;

    public Radio(String name) {
        this.name = name;
        this.volume = 100;
    }

    @Override
    public void increaseVolume() {
        volume = ++volume > MAX_VOLUME ? MAX_VOLUME : volume;
        System.out.println(this);
    }

    @Override
    public void decreaseVolume() {
        volume = --volume < MIN_VOLUME ? MIN_VOLUME : volume;
        System.out.println(this);
    }

    @Override
    public String toString() {
        return "Radio Status: Name<"+name+"> Volume<"+volume+"/"+MAX_VOLUME+">\n";
    }
}
