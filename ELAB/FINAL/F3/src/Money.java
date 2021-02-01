//elab-source:Money.java

public class Money {
    private String name;
    private double amount;
    private double rate;

    public Money(String name, double amount, double rate) {
        this.name = name;
        this.amount = amount;
        this.rate = rate;
    }

    public String getName() {
        return name;
    }

    public double getAmount() {
        return amount;
    }

    public double getRate() {
        return rate;
    }
}
