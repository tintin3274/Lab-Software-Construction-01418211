//elab-source:MainProgram.java
//elab-mainclass:MainProgram

public class MainProgram {
    public static void main(String[] args) {
        Obstacle obs = new Obstacle();
        Obstacle sqObs = new SquareObstacle();
        Obstacle patObs = new PatternSquareObstacle();

        System.out.println("/////////////////////////////////");

        obs.setLength(8);
        System.out.println(obs.image());

        System.out.println("/////////////////////////////////");

        sqObs.setLength(5);
        System.out.println(sqObs.image());

        System.out.println("/////////////////////////////////");

        patObs.setLength(4);
        System.out.println(patObs.image());

        System.out.println("/////////////////////////////////");

        ((PatternSquareObstacle)patObs).setPattern('X');
        System.out.println(patObs.image());
    }
}
