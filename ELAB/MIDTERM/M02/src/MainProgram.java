//elab-source:MainProgram.java
//elab-mainclass:MainProgram

import java.util.ArrayList;

public class MainProgram {
    public static void main(String[] args) {
        CableCar cableCar = new CableCar(3, 100);
        Passenger jumbo, nook, tonmai;
        jumbo = new Passenger("Jumbo", 45.5);
        nook = new Passenger("Nook", 54.4);
        tonmai = new Passenger("Tonmai", 78);
        cableCar.pickUp(jumbo);
        System.out.println(cableCar.getWeight());
        System.out.println(cableCar.getCapacity());
        cableCar.pickUp(nook);
        System.out.println(cableCar.getWeight());
        System.out.println(cableCar.getCapacity());
        cableCar.pickUp(tonmai);
        System.out.println(cableCar.getWeight());
        System.out.println(cableCar.getCapacity());
        cableCar.drive();
        System.out.println(cableCar.getWeight());
        System.out.println(cableCar.getCapacity());
        cableCar.pickUp(tonmai);
        System.out.println(cableCar.getWeight());
        System.out.println(cableCar.getCapacity());
        cableCar.drive();
    }
}
