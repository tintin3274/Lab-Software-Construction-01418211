//elab-source:MainProgram.java
//elab-mainclass:MainProgram

import java.util.Scanner;
import java.util.TreeMap;

public class MainProgram {
    public static void main(String[] args) {
        TreeMap<String, Student> students = new TreeMap<>();
        TreeMap<String, Subject> subjects = new TreeMap<>();
        Scanner sc = new Scanner(System.in);
        int i, n, weight, pass;
        String line;
        String text[];
        String name, subject;


        n = sc.nextInt();
        sc.nextLine();
        line = sc.nextLine();
        text = line.split(" ");
        for(i=0; i<text.length; i++){
            students.put(text[i], new Student(text[i]));
        }

        n = sc.nextInt();
        sc.nextLine();
        for(i=0; i<n; i++){
            line = sc.nextLine();
            text = line.split(" ");
            name = text[0];
            weight = Integer.parseInt(text[1]);
            subjects.put(name, new Subject(name, weight));
        }

        pass = sc.nextInt();
        n = sc.nextInt();
        sc.nextLine();
        for(i=0; i<n; i++){
            line = sc.nextLine();
            text = line.split(" ");
            name = text[0];
            subject = text[1];
            subjects.get(subject).register(students.get(name));
            students.get(name).register(subjects.get(subject));
        }

        for(String subjectName : subjects.keySet()){
            Subject s = subjects.get(subjectName);
            System.out.print("("+subjectName+")");
            for(String student : s.getStudents().keySet()){
                System.out.print(student+",");
            }
            System.out.println();
        }

        for(String studentName : students.keySet()){
            Student student = students.get(studentName);
            weight = student.sumWeight();
            if(weight>=pass){
                System.out.println(studentName+","+weight);
            }
        }
    }
}
