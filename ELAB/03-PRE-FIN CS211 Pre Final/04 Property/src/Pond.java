//elab-source: Pond.java

public class Pond implements Realty {
    private double radius;

    public Pond(double radius) {
        this.radius = radius;
    }

    @Override
    public double getArea() {
        return Math.PI*Math.pow(radius, 2);
    }
}
