//elab-source:Driver.java

import java.util.ArrayList;

public class Driver {
    private String name;
    private Bus bus;
    private int totalDrive;
    private ArrayList<String> history = new ArrayList<>();

    public Driver(String name){
        this.name = name;
        bus = null;
        totalDrive = 0;
    }

    public void setBus(Bus bus) {
        this.bus = bus;
    }

    public void drive(){
        if(bus != null){
            bus.drive(this);
            totalDrive++;
            history.add(bus.getLineNumber());
            bus = null;
        }
    }

    public String getName() {
        return name;
    }

    public int getTotalDrive() {
        return totalDrive;
    }

    public boolean hasDriven(String busLine) {
        if(history.indexOf(busLine)>=0){
            return true;
        }
        return false;
    }
}
