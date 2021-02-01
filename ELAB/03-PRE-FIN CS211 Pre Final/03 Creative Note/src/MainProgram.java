//elab-source:MainProgram.java
//elab-mainclass:MainProgram

import java.util.ArrayList;
import java.util.Scanner;

public class MainProgram {
    public static void main(String[] args) {
        int i, n;
        String line;
        String data[];
        Scanner sc = new Scanner(System.in);
        ArrayList<Note> notes = new ArrayList<>();
        n = sc.nextInt();
        sc.nextLine();
        for(i=0; i<n; i++){
            line = sc.nextLine();
            data = line.split(" ");
            switch (data[0]){
                case "Normal" : notes.add(new Note(data[1].charAt(0), Integer.parseInt(data[2]))); break;
                case "Creative" : notes.add(new CreativeNote(data[1].charAt(0), Integer.parseInt(data[2]))); break;
            }
        }
        n = sc.nextInt();
        for(i=0; i<n; i++){
            line = "";
            for (Note note : notes){
                line += note.playNote();
            }
            System.out.println(line);
        }
    }
}
