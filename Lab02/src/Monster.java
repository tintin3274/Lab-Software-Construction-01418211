public class Monster {
    private String name;
    private int maxHp;
    private int hp;
    private int atk;
    private int def;
    private boolean cooldown;

    public Monster(String name, int maxHp, int atk, int def) {
        this.name = name;
        this.maxHp = maxHp;
        this.hp = maxHp;
        this.atk = atk;
        this.def = def;
        this.cooldown = false;
    }

    public String getName() {
        return name;
    }

    public int getMaxHp() {
        return maxHp;
    }

    public int getHp() {
        return hp;
    }

    public int getAtk() {
        return atk;
    }

    public int getDef() {
        return def;
    }

    public boolean getCooldown() { return cooldown; }

    public void attacked(int atk) {
        atk -= def;
        if (atk < 0) {
            atk = 0;
        }
        hp -= atk;
        if (hp < 0) {
            hp = 0;
        }
    }

    public void recovery(int recovery) {
        if (recovery > 0) {
            hp += recovery;
            if (recovery > maxHp) {
                hp = maxHp;
            }
            cooldown = true;
        }
    }

    public void reCooldown() {
        cooldown = false;
    }

    public String toString(){
        return "Monster " + name + " atk : " + atk + " def : " + def + " hp : " + hp + "/" + maxHp;
    }
}
