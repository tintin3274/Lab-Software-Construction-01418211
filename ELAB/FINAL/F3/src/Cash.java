//elab-source:Cash.java

public class Cash implements Value{
    private double value;

    public Cash(double value) {
        this.value = value;
    }

    @Override
    public double calculateValue() {
        return value;
    }
}
