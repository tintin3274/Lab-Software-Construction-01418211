//elab-source:MainProgram.java
//elab-mainclass:MainProgram

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;

public class MainProgram {
    public static void main(String[] args) {
        MonsterParty party = new MyParty();
        ArrayList<Monster> monsters = party.createMonsters();
        System.out.println(monsters);
        Collections.sort(monsters, new Comparator<Monster>() {
            @Override
            public int compare(Monster o1, Monster o2) {
                int diff = o1.getHitPoint() - o2.getHitPoint();
                return diff < 0 ? 1 : diff == 0 ? 0 : -1;
            }
        });
        System.out.println(monsters);
    }
}
