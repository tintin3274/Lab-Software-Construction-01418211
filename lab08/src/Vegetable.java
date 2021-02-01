public class Vegetable implements Washable, Edible {
    private String name;
    private double weight;

    public Vegetable(String name, double weight) {
        this.name = name;
        this.weight = weight;
        System.out.println("Generate [Vegetable] - "+toString());
    }

    @Override
    public void wash() {
        System.out.println("[Vegetable] <"+name+"> ／(=⌒x⌒=)＼ : Clean, safe, increased by 300%\n");
    }

    @Override
    public int giveEnergy() {
        System.out.println("[Vegetable] <"+name+"> (╯•﹏•╰) : Eat me. I'm handy.");
        return (int)(0.5 * weight);
    }

    @Override
    public String toString() {
        return "Vegetable Status: Name<"+name+"> Weight<"+weight+">\n";
    }
}
