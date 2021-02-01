//elab-source:CableCar.java

import java.util.ArrayList;

public class CableCar {
    private double weight;
    private double maxWeight;
    private int capacity;
    private int maxCapacity;
    private ArrayList<Passenger> passengerOnCable = new ArrayList<>();

    public CableCar(int maxCapacity, double maxWeight){
        this.maxCapacity = maxCapacity;
        this.maxWeight = maxWeight;
        weight = 0;
        capacity = 0;
    }

    public double getWeight() {
        return weight;
    }

    public int getCapacity() {
        return capacity;
    }

    public void pickUp(Passenger passenger){
        if(capacity < maxCapacity){
            if(weight+passenger.getWeight() <= maxWeight){
                passengerOnCable.add(passenger);
                weight += passenger.getWeight();
                capacity++;
            }
        }

    }

    public void drive(){
        if(passengerOnCable.size()>0){
            for (int i=0; i<passengerOnCable.size(); i++){
                System.out.print(passengerOnCable.get(i).getName() + " ");
            }
            System.out.println();
            weight = 0;
            capacity = 0;
            passengerOnCable.clear();
        }

    }
}