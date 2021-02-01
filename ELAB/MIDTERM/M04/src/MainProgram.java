//elab-source:MainProgram.java
//elab-mainclass:MainProgram

public class MainProgram {
    public static void main(String[] args) {
        FireFightingPlane c130 = new FireFightingPlane();
        c130.fillWater(5);
        c130.drive();
        System.out.println("//////////////////////");

        c130.fillWater(7);
        c130.drive();

        System.out.println("//////////////////////");

        ChemicalFireFightingPlane tanker = new ChemicalFireFightingPlane('$');
        tanker.fillWater(6);
        tanker.drive();
        System.out.println("//////////////////////");

        tanker.setChemical('+');
        tanker.fillWater(7);
        tanker.drive();
    }
}
