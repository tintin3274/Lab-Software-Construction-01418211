//elab-source:Bike.java

public class Bike {
    private String licensePlate;
    private boolean available;
    private int numberOfRent;

    public Bike(String licensePlate){
        this.licensePlate = licensePlate;
        available = true;
        numberOfRent = 0;
    }

    public String getLicensePlate(){
        return licensePlate;
    }

    public boolean isAvailable(){
        return available;
    }

    public int getNumberOfRent() {
        return numberOfRent;
    }

    public void rent(){
        if(available == true){
            available = false;
            numberOfRent++;
        }
    }

    public void free(){
        available = true;
    }
}