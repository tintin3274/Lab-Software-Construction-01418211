//elab-source:MainProgram.java
//elab-mainclass:MainProgram

import java.util.Scanner;

public class MainProgram {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        MasterMind m1 = new MasterMind(sc.next());
        System.out.println(m1.guess(sc.next()));
    }
}
