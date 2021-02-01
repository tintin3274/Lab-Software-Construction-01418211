//elab-source:MainProgram.java
//elab-mainclass:MainProgram

import java.util.Scanner;

public class MainProgram {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int i, n;
        NumberGuessor n1 = new NumberGuessor(sc.nextInt());
        n = sc.nextInt();
        for(i=0; i<n; i++){
            System.out.println(n1.guess(sc.nextInt()));
        }
    }
}
