public class Dog implements Washable {
    private String name;
    private int maxEnergy;
    private int energy;

    public Dog(String name, int maxEnergy) {
        this.name = name;
        this.maxEnergy = maxEnergy;
        this.energy = maxEnergy;
        System.out.println("Generate [Dog] - "+toString());
    }

    @Override
    public void wash() {
        energy += maxEnergy *0.1;
        energy = energy > maxEnergy ? maxEnergy : energy;
        System.out.println("[Dog] <"+name+"> ໒( = ᴥ =)ʋ : Ah~ Washing Kimochii~~~");
        System.out.println(this);
    }

    public void eat(Edible food) {
        energy += food.giveEnergy();
        energy = energy > maxEnergy ? maxEnergy : energy;
        System.out.println("[Dog] <"+name+"> V✪ω✪V : Wow~ Food Oishii!!!");
        System.out.println(this);
    }

    public void play() {
        if(energy < maxEnergy *0.3){
            System.out.println("[Dog] <"+name+"> U ´x` U : Zzz~ Tired, lazy to play...");
        }
        else {
            System.out.println("[Dog] <"+name+"> ໒( ̿❍ ᴥ ̿❍)ʋ : Run! Run! Run! ");
            energy -= maxEnergy *0.25;
            if(energy < maxEnergy *0.3){
                System.out.println("[Dog] <"+name+"> U・ﻌ・U : I'm so hungry, want to eat food...");
            }
        }
        System.out.println(this);
    }

    @Override
    public String toString() {
        return "Dog Status: Name<"+name+"> Energy<"+energy+"/"+maxEnergy+">\n";
    }
}
