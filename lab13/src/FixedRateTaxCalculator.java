public class FixedRateTaxCalculator implements TaxCalculator {
    private double rate;

    public FixedRateTaxCalculator(double rate) {
        this.rate = rate;
    }

    @Override
    public double calculateTax(double purchase) {
        return purchase * rate;
    }
}
