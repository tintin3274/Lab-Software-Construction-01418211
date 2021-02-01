//elab-source:MainProgram.java
//elab-mainclass:MainProgram

import java.util.ArrayList;
import java.util.Scanner;

public class MainProgram {
    public static void main(String[] args) {
        int i, n;
        double totalArea = 0;
        Realty realty;
        ArrayList<Realty> realtyArrayList = new ArrayList<>();
        Scanner sc = new Scanner(System.in);
        n = sc.nextInt();
        sc.nextLine();
        for (i=0; i<n; i++){
            switch (sc.next()){
                case "House": realtyArrayList.add(realty = new House(sc.nextDouble())); totalArea += realty.getArea(); break;
                case "Building": realtyArrayList.add(realty = new Building(sc.nextDouble(), sc.nextDouble(), sc.nextInt())); totalArea += realty.getArea(); break;
                case "Pond": realtyArrayList.add(realty = new Pond(sc.nextDouble())); totalArea += realty.getArea(); break;
            }
            sc.nextLine();
        }
        //System.out.println(totalArea);
        System.out.format("%.2f", totalArea);
    }
}
