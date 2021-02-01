//elab-source:Stock.java

public class Stock implements Value {
    private double amount;
    private double price;

    public Stock(double amount, double price) {
        this.amount = amount;
        this.price = price;
    }

    @Override
    public double calculateValue() {
        return amount*price;
    }
}
