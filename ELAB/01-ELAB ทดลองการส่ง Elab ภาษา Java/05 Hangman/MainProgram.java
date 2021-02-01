//elab-source:MainProgram.java
//elab-mainclass:MainProgram

import java.util.Scanner;

public class MainProgram {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        HangMan h1 = new HangMan(sc.next());
        h1.toString();
        while(!h1.isDead()){
            h1.guess(sc.next());
        }


    }
}
