//elab-source:MainProgram.java
//elab-mainclass:MainProgram

import java.util.ArrayList;
import java.util.Collection;
import java.util.Collections;
import java.util.Comparator;

public class MainProgram {
    public static void main(String[] args) {
        FinalExam finalExam = new FinalExam();

        try {
            finalExam.methodA(101);
        }
        catch (ArithmeticException exceptionObject){
            System.out.println(exceptionObject.getMessage());
        }

        try {
            finalExam.methodB("0123456789E");
        }
        catch (StringIndexOutOfBoundsException exceptionObject){
            System.out.println(exceptionObject.getMessage());
        }

        try {
            finalExam.methodC("FILENAME");
        }
        catch (FileNotFoundException exceptionObject){
            System.out.println(exceptionObject.getMessage());
        }

        try {
            finalExam.methodD(null);
        }
        catch (NullPointerException exceptionObject){
            System.out.println(exceptionObject.getMessage());
        }

        try {
            finalExam.methodE(0);
        }
        catch (IndexOutOfBoundsException exceptionObject){
            System.out.println(exceptionObject.getMessage());
        }
    }
}

