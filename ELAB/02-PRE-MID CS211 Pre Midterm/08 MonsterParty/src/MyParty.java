//elab-source:MyParty.java

import java.util.ArrayList;

public class MyParty implements MonsterParty {
    @Override
    public ArrayList<Monster> createMonsters() {
        ArrayList<Monster> monsters = new ArrayList<>();
        monsters.add(new Monster("Thief Bug", 500));
        monsters.add(new Monster("Ant Egg", 5000));
        monsters.add(new Monster("Poring", 10));
        monsters.add(new Monster("Rare Mandragora", 38));
        return monsters;
    }
}
