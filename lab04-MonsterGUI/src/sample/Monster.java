package sample;

public class Monster {
    private String name;
    private int maxHp;
    private int currentHp;
    private int atk;
    private int def;
    private int coolDownCount;
    private boolean coolDown;
    private String imgPath;

    public Monster(String name, int maxHp, int atk, int def, String imgPath) {
        this.name = name;
        this.maxHp = maxHp;
        this.currentHp = maxHp;
        this.atk = atk;
        this.def = def;
        this.coolDown = false;
        this.coolDownCount = 0;
        this.imgPath = imgPath;
    }

    public String getName() {
        return name;
    }

    public int getMaxHp() {
        return maxHp;
    }

    public int getCurrentHp() {
        return currentHp;
    }

    public int getAtk() {
        return atk;
    }

    public int getDef() {
        return def;
    }

    public boolean getCoolDown() { return coolDown; }

    public void attacked(int atk) {
        atk -= def;
        if (atk < 0) {
            atk = 0;
        }
        currentHp -= atk;
        if (currentHp < 0) {
            currentHp = 0;
        }
    }

    public void recovery(int recovery) {
        if (recovery > 0) {
            currentHp += recovery;
            if (currentHp > maxHp) {
                currentHp = maxHp;
            }
            coolDown = true;
        }
    }

    public int getCoolDownCount() {
        return coolDownCount;
    }

    public void reCoolDown() {
        coolDownCount++;
        if(coolDownCount == 2){
            coolDown = false;
            coolDownCount = 0;
        }
    }

    public String toString(){
        return "ATK: " + atk + "\nDEF: " + def + "\nHP: " + currentHp + "/" + maxHp;
    }

    public String getImgPath() {
        return imgPath;
    }

    public void setImgPath(String imgPath) {
        this.imgPath = imgPath;
    }

    public boolean isDead(){
        if (currentHp <= 0){
            return true;
        }
        return false;
    }
}
