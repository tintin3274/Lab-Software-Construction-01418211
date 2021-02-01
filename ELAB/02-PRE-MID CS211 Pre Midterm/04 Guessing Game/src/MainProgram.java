//elab-source:MainProgram.java
//elab-mainclass:MainProgram

import java.util.Scanner;
public class MainProgram {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        GuessingGame g = null;
        switch (sc.nextInt()){
            case 1: g = new Hangman();
                break;
            case 2: g = new WordMatch();
                break;
        }
        g.setAnswer(sc.next());
        while (!(g.isWon() || g.isLost())){
            g.guess(sc.next());
            System.out.println(g.getOutput());
        }
        if (g.isLost()) System.out.println("Sorry you lose!");
        if (g.isWon()) System.out.println("You won!");
    }
}