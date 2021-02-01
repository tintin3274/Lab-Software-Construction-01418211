//elab-source:Travel.java

public class Travel implements Value {
    private String name;
    private double amount;
    private double rate;

    public Travel(String name, double amount, double rate) {
        this.name = name;
        this.amount = amount;
        this.rate = rate;
    }

    @Override
    public double calculateValue() {
        return amount*rate;
    }
}