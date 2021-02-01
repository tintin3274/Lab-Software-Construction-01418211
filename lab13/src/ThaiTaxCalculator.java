public class ThaiTaxCalculator implements TaxCalculator {
    @Override
    public double calculateTax(double purchase) {
        return purchase * 0.07;
    }
}
