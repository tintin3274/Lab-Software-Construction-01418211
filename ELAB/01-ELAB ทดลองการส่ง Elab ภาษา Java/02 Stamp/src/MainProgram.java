//elab-source:MainProgram.java
//elab-mainclass:MainProgram

import java.util.Scanner;

public class MainProgram {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int i, n;
        Stamp s1 = new Stamp();
        n = sc.nextInt();
        for(i=0; i<n; i++){
            s1.purchase(sc.nextDouble());
        }
        System.out.println(s1.calculateStamp());
    }
}
