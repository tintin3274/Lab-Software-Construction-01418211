//elab-source:MainProgram.java
//elab-mainclass:MainProgram

public class MainProgram {
    public static void main(String[] args) {
        MonsterBall monsterBall[] = {new MonsterBall ("Poke Ball", 200, 100, 1),
                new MonsterBall ("Great Ball", 600, 300, 1.5),
                new MonsterBall ("Ultra Ball", 1200, 600, 2),
                new MonsterBall ("Drive Ball", 1000, 500, 3.5)};
        System.out.println(monsterBall[0]);
        System.out.println(monsterBall[1]);
        System.out.println(monsterBall[2]);
        System.out.println(monsterBall[3]);
    }
}
