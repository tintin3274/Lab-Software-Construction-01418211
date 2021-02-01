//elab-source:MainProgram.java
//elab-mainclass:MainProgram

import java.util.Scanner;

public class MainProgram {
    public static void main(String[] args) {
        String line;
        String data[];
        int i, n;
        Scanner sc = new Scanner(System.in);
        Twitter twitter = new Twitter();

        n = sc.nextInt();
        sc.nextLine();
        for(i=0; i<n; i++){
            twitter.addUser(sc.next());
        }

        n = sc.nextInt();
        sc.nextLine();
        for(i=0; i<n; i++){
            line = sc.nextLine();
            data = line.split(" ");
            twitter.follow(data[0], data[1]);
        }

        n = sc.nextInt();
        sc.nextLine();
        for(i=0; i<n; i++){
            line = sc.nextLine();
            data = line.split("/");
            twitter.post(data[0], data[1]);
        }

        twitter.showFeeds();
    }
}
