//elab-source: House.java

public class House implements Realty{
    private double space;

    public House(double space) {
        this.space = space;
    }

    @Override
    public double getArea() {
        return space*4;
    }
}
