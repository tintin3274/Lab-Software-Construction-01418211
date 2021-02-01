//elab-source:MainProgram.java
//elab-mainclass:MainProgram

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Scanner;

public class MainProgram {
    public static void main(String[] args) {
        ArrayList<Value> wallet = new ArrayList<>();
        Scanner sc = new Scanner(System.in);
        int i, n;
        String line;
        String text[];
        n = sc.nextInt();
        sc.nextLine();
        for(i=0; i<n; i++){
            line = sc.nextLine();
            text = line.split(" ");
            switch (text[0]){
                case "Cash": wallet.add(new Cash(Double.parseDouble(text[1]))); break;
                case "Stock": wallet.add(new Stock(Double.parseDouble(text[1]), Double.parseDouble(text[2]))); break;
                case "Travel":{
                    for (i=1; i<text.length; i+=3){
                        wallet.add(new Travel(text[i], Double.parseDouble(text[i+1]), Double.parseDouble(text[i+2])));
                    }
                    break;
                }
            }
        }

        double sumValue = 0;
        for(Value v : wallet){
            sumValue += v.calculateValue();
        }
        System.out.format("%.2f%n", sumValue);
    }
}
