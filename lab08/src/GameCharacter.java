public class GameCharacter {
    private int hp;
    private String name;
    private int damage;
    private Weapon weapon;

    public GameCharacter(String name, int hp, int damage, Weapon weapon){
        this.name = name;
        this.hp = hp;
        this.damage = damage;
        this.weapon = weapon;
        System.out.println("Generate [GameCharacter] - "+toString()+"\n");
    }

    public int getDamage(){
        return damage + weapon.getDamage();
    }

    public String getName() {
        return name;
    }

    public void isAttackedWith(int damage){
        hp -= damage;
        if(hp < 0) hp = 0;
        System.out.println(this+"\n");
    }

    public void attack(GameCharacter enemy){
        if(hp>0){
            System.out.println("<<<<< "+name + " ⚡ Attack ⚡ " + enemy.getName()+" >>>>>");
            System.out.println(this);
            enemy.isAttackedWith(getDamage());
            weapon.use();
        }
    }

    @Override
    public String toString() {
        return "GameCharacter Status: Name<"+name+"> HP<"+hp+"> Damage<"+getDamage()+">";
    }
}
