import java.io.*;
import java.util.ArrayList;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        if (args.length == 0) {
            System.err.println("Please enter filename as command line argument.");
            return;
        }
        String filename = args[0];
        System.out.println("Filename: "+filename+"\n");

        ArrayList<Student> students = new ArrayList<>();
        Scanner sc = new Scanner(System.in);
        try {
            String line;
            String data[];
            File file = new File(filename);
            FileReader fileReader = new FileReader(file);
            BufferedReader reader = new BufferedReader(fileReader);
            while ((line = reader.readLine()) != null){
                data = line.split(",");
                students.add(new Student(data[0].trim(), Double.parseDouble(data[1].trim())));
            }
            reader.close();
        } catch (FileNotFoundException e) {
            //e.printStackTrace();
            System.err.println("Error File not found. "+e.getMessage());
            return;
        } catch (IOException e) {
            e.printStackTrace();
        }

        AverageScore averageScore = new AverageScore(students);
        SortScore sortScore;
        double average = averageScore.getAverageScore();
        double expect = 0.0;
        boolean run = true;
        while (run){
            System.out.println("Mode | [E]-Exit, [A]-Average, [X]-Expect");
            System.out.print("Mode: ");
            switch (sc.next().toUpperCase()){
                case "E" : run = false; continue;
                case "A" : expect = average; break;
                case "X" :
                    System.out.print("Enter Expect Score: ");
                    try {
                        expect = Double.parseDouble(sc.next());
                    } catch (NumberFormatException e) {
                        System.err.println("Error "+e.getMessage()+". Please input number only.\n");
                        continue;
                    }
                    break;
                default: System.err.println("Command not found. Please select again.\n"); continue;
            }

            System.out.println("Sort Pattern | [1]-Most to Least, [2]-Least to Most");
            System.out.print("Sort Pattern: ");
            switch (sc.next()){
                case "1" : sortScore = new ScoreMostToLeast(); break;
                case "2" : sortScore = new ScoreLeastToMost(); break;
                default: System.err.println("Command not found. Please select again.\n"); continue;
            }

            sortScore.sortScore(students);
            String namePassed = "";
            int numberPassed = 0;
            for (Student s : students){
                if(s.getScore() >= expect){
                    namePassed += s.toString()+"\n";
                    numberPassed++;
                }
            }
            System.out.println("The number of students score greater than or equal to of "+expect+" is "+numberPassed+" people.");
            System.out.println(namePassed);
            System.out.println();
        }
    }

//        System.out.println(args.length);
//        System.out.println(Arrays.toString(args));
}

