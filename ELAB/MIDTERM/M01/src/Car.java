//elab-source:Car.java

public class Car {
    private double maxFuel;
    private double fuel;
    private double oilConsumptionRate;
    private double velocity;
    private double distance;
    private double hour;


    public Car(double maxFuel, double oilConsumptionRate){
        this.maxFuel = maxFuel;
        this.oilConsumptionRate = oilConsumptionRate;
        velocity = 0;
        distance = 0;
        fuel = 0;
        hour = 0;
    }

    public void setVelocity(double velocity) {
        this.velocity = velocity;
    }

    public void addFuel(double fuel){
        if(fuel>=0){
            this.fuel += fuel;
            if(this.fuel > maxFuel){
                this.fuel = maxFuel;
            }
        }
    }

    public void setHour(double hour){
        this.hour = hour;
    }

    public void drive(){
        if(fuel>0){
            double range = fuel*oilConsumptionRate;
            double run = velocity*hour;

            if(range >= run){
                fuel -= (run/oilConsumptionRate);
                distance += run;
            }

            else{
                fuel = 0;
                distance += range;
            }
        }

    }

    public double getFuel() {
        return fuel;
    }

    public double getOilConsumptionRate() {
        return oilConsumptionRate;
    }

    public double getDistance() {
        return distance;
    }

    public double getMaxFuel() {
        return maxFuel;
    }
}
