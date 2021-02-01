//elab-source:MainProgram.java
//elab-mainclass:MainProgram

import java.util.ArrayList;
import java.util.Scanner;

public class MainProgram {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        ArrayList<MiniFileSystem> file = new ArrayList<>();

        while (true){
            String command = sc.next();

            if(command.equals("touch")){
                MiniFileSystem.touch(file, sc.next());
            }

            else if(command.equals("echo")){
                MiniFileSystem.echo(file, sc.nextLine());
            }

            else if(command.equals("cat")){
                MiniFileSystem.cat(file, sc.next());
            }

            else if(command.equals("exit")){
                break;
            }
        }
    }
}
