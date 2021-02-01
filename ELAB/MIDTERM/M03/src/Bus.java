//elab-source:Bus.java

import java.util.ArrayList;

public class Bus {
    private String lineNumber;
    private String plateNumber;
    private int totalDriver;
    private ArrayList<String> history = new ArrayList<>();

    public Bus(String lineNumber, String plateNumber){
        this.lineNumber = lineNumber;
        this.plateNumber = plateNumber;
        totalDriver = 0;
    }

    public String getLineNumber() {
        return lineNumber;
    }

    public String getPlateNumber() {
        return plateNumber;
    }

    public int getTotalDriver() {
        return totalDriver;
    }

    public void drive(Driver driver){
        if(history.indexOf(driver.getName())<0){
            history.add(driver.getName());
            totalDriver++;
        }
    }

    @Override
    public String toString() {
        return lineNumber + " (" + plateNumber +")";
    }
}
