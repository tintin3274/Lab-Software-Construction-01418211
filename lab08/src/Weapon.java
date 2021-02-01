public class Weapon {
    private int damage;
    private int durability;
    public Weapon(int dmg, int dur){
        damage = dmg;
        durability = dur;
    }

    public int getDamage(){
        if(durability>0){
            return damage;
        }
        return 0;
    }

    public void use(){
        if(--durability < 0) durability = 0;
    }
}
