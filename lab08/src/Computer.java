import java.util.ArrayList;

public class Computer implements VolumeChangeable, NetworkInterface {
    private static final int MAX_VOLUME = 100;
    private static final int MIN_VOLUME = 0;
    private String name;
    private int volume;
    private ArrayList<Network> network;

    public Computer(String name) {
        this.name = name;
        this.volume = 50;
        this.network = new ArrayList<>();
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
    public void connect(Network network) {
        if(!this.network.contains(network))
        {
            System.out.println("<<<<< Login network succeed. >>>>>");
            this.network.add(network);
            System.out.println(this);
        }
        else {
            System.out.println("<<<<< The system is already connected to this network. >>>>>");
            System.out.println(this);
        }
    }

    @Override
    public void disconnect(Network network) {
        if(this.network.contains(network))
        {
            System.out.println("<<<<< Logout network succeed. >>>>>");
            this.network.remove(network);
            System.out.println(this);
        }
        else {
            System.out.println("<<<<< The system is not connected to this network. >>>>>");
            System.out.println(this);
        }
    }

    @Override
    public String toString() {
        String output = "";
        for(Network n:network){
            output += "- " + n.toString() + "\n";
        }
        return "Computer Status: Name<"+name+"> Volume<"+volume+"/"+MAX_VOLUME+">\n" +
                "[Network Connection]\n"+output;
    }
}
