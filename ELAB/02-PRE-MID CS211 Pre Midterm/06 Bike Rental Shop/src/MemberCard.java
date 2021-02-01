//elab-source:MemberCard.java

public class MemberCard {
    private String name;
    private int numberOfRent;
    private Bike bike;

    public MemberCard(String name){
        this.name = name;
        numberOfRent = 0;
        bike = null;
    }

    public String getName() {
        return name;
    }

    public int getNumberOfRent() {
        return numberOfRent;
    }

    public void rentBike(Bike bike){
        if(this.bike == null && bike.isAvailable()){
            this.bike = bike;
            numberOfRent++;
            bike.rent();

        }
    }

    public String viewBikeLicensePlate(){
        if(bike != null){
            return bike.getLicensePlate();
        }
        return "";
    }

    public void returnBike(){
        if(bike!=null){
            bike.free();
            bike = null;
        }
    }
}