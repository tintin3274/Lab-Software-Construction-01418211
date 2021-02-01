//elab-source:Monster.java

public class Monster implements Comparable {
    private String name;
    private int hitPoint;

    public Monster(String name, int hitPoint){
        this.name = name;
        this.hitPoint = hitPoint;
    }

    public int getHitPoint() {
        return hitPoint;
    }

    @Override
    public int compareTo(Object o) {
        return 0;
    }

    @Override
    public String toString() {
        return name+":"+hitPoint;
    }
}
