public class Chicken implements Washable, Edible{
    private String name;
    private double weight;

    public Chicken(String name, double weight) {
        this.name = name;
        this.weight = weight;
        System.out.println("Generate [Chicken] - "+toString());
    }

    @Override
    public void wash() {
        System.out.println("[Chicken] <"+name+"> ⋛⋋( ‘Θ’)⋌⋚ : Ah~ Washing Kimochii~~~\n");
    }

    @Override
    public int giveEnergy() {
        System.out.println("[Chicken] <"+name+"> ლ(⁰⊖⁰ლ) : No~ Don't eat me!#@$@#%");
        return (int)(4 * weight);
    }

    @Override
    public String toString() {
        return "Chicken Status: Name<"+name+"> Weight<"+weight+">\n";
    }
}
