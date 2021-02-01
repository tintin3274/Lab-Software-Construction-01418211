//elab-source:MainProgram.java
//elab-mainclass:MainProgram

import java.util.Scanner;

public class MainProgram {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int i;
        String trueAnswer = sc.next();
        int n = sc.nextInt();
        ExamChecker exam = new ExamChecker(trueAnswer, n);

        for(i=0; i<n; i++){
            exam.Check(sc.next(), i);
        }

        System.out.println(exam.toString());
    }
}
