import java.io.*;
import java.util.InputMismatchException;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        if (args.length == 0) {
            System.err.println("Please enter filename as command line argument.");
            return;
        }

        Scanner sc = new Scanner(System.in);
        int n = args.length, i;
        String line;
        String data[];
        BowlingGame bowlingGame = new BowlingGame();


        for(i=0; i<n; i++){
            String filename = args[i];
            System.out.println("Filename: "+filename);

            try {
                int round = 1;
                int count = 0;

                File file = new File(filename);
                FileReader fileReader = new FileReader(file);
                BufferedReader reader = new BufferedReader(fileReader);

                BowlingPlayer player = new BowlingPlayer(reader.readLine());
                bowlingGame.addPlayer(player);

                while ((line = reader.readLine()) != null){
                    if(line.contains(",")){
                        data = line.split(",");
                        player.addScore(round, Integer.parseInt(data[0]) , Integer.parseInt(data[1]));
                    }
                    else {
                        player.addScore(round, Integer.parseInt(line));
                    }
                    count++;
                    if(count%10 == 0) round++;
                }
                reader.close();
            } catch (FileNotFoundException e) {
                e.printStackTrace();
            } catch (IOException e) {
                e.printStackTrace();
            }
        }

        System.out.println();

        ScoreResult scoreResult;
        boolean run = true;
        while (run){
            System.out.println("Mode | [E]-Exit, [A]-Total Score, [B]-Weighted Total Score, [C]-Strike Total Score");
            System.out.print("Mode: ");
            switch (sc.nextLine().toUpperCase()){
                case "E" : run = false; continue;
                case "A" : scoreResult = new HighestScore(); break;
                case "B" :
                    System.out.print("Enter Weighting Factor: ");
                    try {
                        line = sc.nextLine();
                        data = line.split(" ");
                        if(data.length != 3) throw new InputMismatchException();
                        scoreResult = new HighestWeightedScore(Double.parseDouble(data[0].trim()), Double.parseDouble(data[1].trim()), Double.parseDouble(data[2].trim()));
                    } catch (InputMismatchException e) {
                        System.err.println("Error input invalid format.\n");
                        continue;
                    }
                    catch (NumberFormatException e) {
                        System.err.println("Error "+e.getMessage()+". Please input number only.\n");
                        continue;
                    }
                    break;
                case "C" : scoreResult = new HighestStrike(); break;
                default: System.err.println("Command not found. Please select again.\n"); continue;
            }
            scoreResult.result(bowlingGame);
            System.out.println();
        }
    }
}
